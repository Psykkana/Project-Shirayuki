import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/*
 *  The checkoutStationTile subclass
 *      Extends displayTile, press E to interact
 *      Lets user checkout items in their inventory
 * 
 */

public class checkoutStationTile extends displayTile {

    private Random rand = new Random();

    public checkoutStationTile(int posX, int posY, int floor) {
        super(posX, posY, floor, null, "Checkout Counter", 0);   // No capacity needed
        loadSprite("assets/checkout_counter.png");
    }

    // Helper class for summarizing unique products
    private static class ProductSummary {
        String name;
        double unitPrice;
        double discountedUnitPrice;
        int quantity;
        double totalPrice;

        ProductSummary(String name, double unitPrice, double discountedUnitPrice) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.discountedUnitPrice = discountedUnitPrice;
            this.quantity = 0;
            this.totalPrice = 0.0;
        }
    }

    // Randomly select between list of names to put in the cashier part of receipt
    private String generateEmployeeName() {
        List<String> names = new ArrayList<>();
        names.add("Shizuko Konoe");
        names.add("Shinshuu Maru");
        names.add("Hisamichi Kongo");
        names.add("Souya Maru");
        names.add("Joe Biden");
        names.add("William Halsey");
        names.add("James Thompson");
        names.add("Hiroshi Saito");                
        names.add("Ishikawa Hanako");
        names.add("Haida Smith");        

        // Shuffle the names around
        Collections.shuffle(names);

        // Random int between 0 and 9 (10 total names available)
        return names.get(rand.nextInt(9));
    }

    // Print out the receipt and remove the products from user's inventory
    private void processCheckout(Player player, List<Product> productsToCheckout, double runningTotal, double discountedTotal) {

        // Date and Time (month, day, year hour, minute)
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);

        // Receipt txt file name
        String outputName = "Receipt-" + player.getName() + ".txt";

        try (PrintWriter writer = new PrintWriter(outputName)) {

            // Receipt Header
            writer.println("================================================================");
            writer.println("************************ Shirayuki Mart ************************"); 
            writer.println("************************ SALES  INVOICE ************************");                    
            writer.println("================================================================");
            writer.println("Transaction time & date: " + formattedDateTime);
            writer.println("Cashier: " + generateEmployeeName());
            writer.println("Customer: " + player.getName());
            writer.println("Age: " + player.getAge());
            writer.println("----------------------------------------------------------------");

            // Goup products by type
            Map<String, List<Product>> grouped = new HashMap<>();      

            for (Product p : productsToCheckout) {
                String type = p.getProductType();

                List<Product> list = grouped.get(type);
                if (list == null) {
                    list = new ArrayList<>();
                    grouped.put(type, list);
                }

                list.add(p);
            }

            // Print per product category
            for (String productType : grouped.keySet()) {

                writer.println(productType); // print product name

                List<Product> list = grouped.get(productType);

                for (Product p : list) {
                    boolean discountEligible = player.getAge() >= 60;
                    double finalPrice = (p.isDiscountEligible() && discountEligible) ? 
                                            p.getDiscountedPrice() : p.getPrice();

                    // Print:    serialID   Quantity   Price
                    writer.printf("\t%-12s %-10d %-10.2f%n",
                            p.getSerialID(),
                            1,              // quantity always 1 per instance
                            finalPrice);              
                }

                writer.println(); // blank line between product categories
            }
            writer.println("----------------------------------------------------------------");
            writer.printf("SUBTOTAL: %.2f PHP%n", runningTotal);
            writer.printf("DISCOUNTED TOTAL %.2f PHP%n", discountedTotal);
            writer.printf("SAVINGS %.2f PHP%n", (runningTotal - discountedTotal));
            writer.println("================================================================");
            writer.println("Thank you for shopping with us!");

            System.out.println("DEBUG: Printed receipt successfully (" + outputName + ")");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to write receipt: " + e.getMessage(),
                                                "Error", JOptionPane.ERROR_MESSAGE);
        return;       
        }

        // After processing sales invoice, clear player inventory
        player.getHandProducts().clear();
        if (player.hasEquipment()) {
            player.getEquipment().clear();
        }

        // GUI notification of successful checkout
        JOptionPane.showMessageDialog(null, "Checkout complete! Thank you for shopping with us", 
                                "Checkout Successful!", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void onInteract(Player player, Board board) {

        // Layout should be similar to the inventory view

        // Make local list of products the user is carrying
        List<Product> productsToCheckout = player.getAllCarriedProducts();

        if (productsToCheckout.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "You have no products to checkout.", 
                "Checkout Denied", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if user is eligible for discounts or not
        boolean discountEligible = player.getAge() >= 60;

        // Group by productType
        Map<String, ProductSummary> summaryMap = new HashMap<>();

        // Go through each product in the checkout list and add as a label
        for (Product p : productsToCheckout) {
            String key = p.getProductType();
            ProductSummary sum = summaryMap.get(key);

            if (sum == null) {
                sum = new ProductSummary(key, p.getPrice(), p.getDiscountedPrice());
                summaryMap.put(key, sum);
            }

            sum.quantity++; 

            if (p.isDiscountEligible() && discountEligible) {
                sum.totalPrice += p.getDiscountedPrice();
            } else {
                sum.totalPrice += p.getPrice();
            }
        }

        // Build table data
        Object[][] rowData;  
        String[] columnNames;

        // If user is eligible for discounts, show in table
        if (discountEligible) {
            columnNames = new String[] { "Product", "Quantity", "Unit Price", "Cost", "Per Unit Discount" };
            rowData = new Object[summaryMap.size()][5];
        } else {    // If not eligible, show without discount price
            columnNames = new String[] { "Product", "Quantity", "Unit Price", "Cost"};
            rowData = new Object[summaryMap.size()][4];
        }


        int i = 0;
        for (ProductSummary sum : summaryMap.values()) {
            double costBeforeDiscount = sum.unitPrice * sum.quantity;

            rowData[i][0] = sum.name;
            rowData[i][1] = sum.quantity;
            rowData[i][2] = String.format("%.2f", sum.unitPrice);
            rowData[i][3] = String.format("%.2f", costBeforeDiscount);

            if (discountEligible) {
                rowData[i][4] = String.format("%.2f", sum.discountedUnitPrice);                  // Discounted total
            }
            i++;
        }
        
        // Compute the overall total price
        double overallRunningTotal = 0.0;
        double overallDiscountedTotal = 0.0;

        for (ProductSummary sum : summaryMap.values()) {
            overallRunningTotal += sum.unitPrice * sum.quantity;
            overallDiscountedTotal += sum.totalPrice;
        }

        // The Checkout GUI
        String displayTotalPrice;
        if (player.getAge() >= 60) {     // The discounted total
            displayTotalPrice = String.format("RUNNING TOTAL (DISCOUNT APPLIED): %.2f PHP (From %.2f PHP)", 
                                                overallDiscountedTotal, overallRunningTotal);
        } else {    // The regular total
            displayTotalPrice = String.format("RUNNING TOTAL: %.2f PHP", overallRunningTotal);
        }

        // Table inside ScrollPane
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Main panel layout
        JPanel panel = new JPanel(new BorderLayout());
        String equipmentName = player.hasEquipment() ? player.getEquipment().getName() : "Hands";
        JLabel label = new JLabel("Equipment: " + equipmentName, SwingConstants.CENTER);

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Show overall total at bottom
        JLabel totalLabel = new JLabel(
            displayTotalPrice,
            SwingConstants.CENTER
        );
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(totalLabel, BorderLayout.SOUTH);

        Object[] options = { "Confirm Checkout", "Cancel" };
        int choice = JOptionPane.showOptionDialog(null, panel, "Checkout Summary", 
                                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
                                    null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            processCheckout(player, productsToCheckout, overallRunningTotal, overallDiscountedTotal);
        } else {
            System.out.println("DEBUG: Checkout cancelled by user");
        }
    }
}