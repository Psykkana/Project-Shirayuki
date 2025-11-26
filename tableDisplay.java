import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


/*
 *  The tableDisplay subclass
 *      A displayTile     
 */
public class tableDisplay extends displayTile {

    private ArrayList<Product> products;    // max 4

    public tableDisplay(int posX, int posY, int floor, displayAddress address) {
        super(posX, posY, floor, address, "Table Display" , 4);
        loadSprite("assets/table.png");
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
    // Only add items that are allowed on a table
    if (p != null && canBeOnTable(p) && products.size() < capacity) {
        products.add(p);
     } else {
        // Optional: debug if something wrong is being added
        System.out.println("DEBUG: Attempted to add non-table product "
                + (p != null ? p.getSerialID() : "null")
                + " to table at " + getPosX() + ", " + getPosY());
        }
    }

    // Each image will be named 'serialID' + .png
    private ImageIcon getProductImage(Product p) {
        String productPrefix = p.getSerialID().substring(0, 3);
        String location = "assets/products/" + productPrefix + ".png";

        File file = new File(location);

        if (!file.exists()) {
                        System.out.println("DEBUG: Couldn't find " + productPrefix + ".png, switching to placeholder");
            ImageIcon placeholder = new ImageIcon("assets/products/placeholder100x100.png");
            return new ImageIcon(placeholder.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        } else {
            ImageIcon icon = new ImageIcon(location);            
            return new ImageIcon(icon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));            
        }
    }    

    @Override
    public void onInteract(Player player, Board board) {

        System.out.println("Interacted with table at " + getPosX() + ", " + getPosY());

        // Create the popup frame FIRST so listeners can reference it
        final JFrame frame = new JFrame("Table Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ==== MAIN PANEL ====
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setPreferredSize(new Dimension(350, 350));        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));
    
        // Title text (address)
        JLabel mainTitle = new JLabel("Table (" + address + ")", JLabel.CENTER);
        mainTitle.setFont(new Font("Leto", Font.BOLD, 20));
        mainPanel.add(mainTitle, BorderLayout.NORTH);

        // Inner product panel (2x2 grid)
        JPanel productPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        productPanel.setBackground(Color.GRAY);
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productPanel.setPreferredSize(new Dimension(220, 220));
        mainPanel.add(productPanel, BorderLayout.CENTER);
    
        // ==== 4 product slots ====
        for (int i = 0; i < 4; i++) {
            final JButton productButton;

            if (i < products.size()) {
                // --- EXISTING PRODUCT SLOT: take item FROM display ---
                final Product p = products.get(i);
                
                ImageIcon icon = getProductImage(p);
                
                productButton = new JButton(p.getProductType(), icon);
                // b 0.7.9 - Add product name below the button icon
                productButton.setHorizontalTextPosition(JButton.CENTER);
                productButton.setVerticalTextPosition(JButton.BOTTOM);
                productButton.setPreferredSize(new Dimension(100, 100));
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //Age checker 
                        if (p.isRestrictedUnderage() && player.getAge() < 18) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You are too young to get this product.",
                                "Age Restricted",
                                JOptionPane.WARNING_MESSAGE                                                                                                    
                            );
                            return;
                        }

                        // Try to give the product to the player
                        boolean taken = player.pickUpProduct(p);

                        if (!taken) {
                            // Player has no more space (equipment full + 2 hand items)
                            JOptionPane.showMessageDialog(
                                frame,   // <— IMPORTANT: owned by this popup window
                                "You cannot carry any more products.\n" +
                                "Return some items or get equipment with more capacity.",
                                "Inventory Full",
                                JOptionPane.WARNING_MESSAGE
                            );
                            return;
                        }

                        System.out.println("DEBUG: " + player.getName() + " picked up "
                                + p.getProductType() + " - " + p.getSerialID());

                        // Remove from this display
                        products.remove(p);
                        productButton.setEnabled(false);
                        productButton.setBackground(Color.LIGHT_GRAY);
                        productButton.setIcon(null);
                        productButton.setText("Product taken");
                    }
                });

            } else {
                // --- EMPTY SLOT: return item FROM inventory BACK to this table ---
                productButton = new JButton("Empty");
                productButton.setBackground(Color.LIGHT_GRAY);
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // 1) Look for a table-compatible product in player's hands
                        Product toReturn = null;

                        // From hands
                        for (Product hp : player.getHandProducts()) {
                            if (canBeOnTable(hp)) {
                                toReturn = hp;
                                break;
                            }
                        }

                        // 2) If not found in hands, look in equipment
                        if (toReturn == null && player.getEquipment() != null) {
                            for (Product ep : player.getEquipment().getProducts()) {
                                if (canBeOnTable(ep)) {
                                    toReturn = ep;
                                    break;
                                }
                            }
                        }

                        // 3) If still null, nothing suitable to return to this table
                        if (toReturn == null) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You have no items that can be placed on this table.",
                                "Return Product",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                            return;
                        }

                        // 4) Remove from player inventory and add back to this display
                        player.dropProduct(toReturn);
                        products.add(toReturn);

                        // 5) Feedback on this slot
                        productButton.setEnabled(false);
                        productButton.setText("Returned");
                        productButton.setBackground(Color.WHITE);

                        System.out.println("DEBUG: " + player.getName()
                                + " returned " + toReturn.getProductType()
                                + " (" + toReturn.getSerialID() + ") to table at "
                                + getPosX() + ", " + getPosY());
                    }
                });
            }
            
            productButton.setFocusable(false);
            productPanel.add(productButton);
        }

        frame.add(mainPanel);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);  // Center on screen
        frame.setVisible(true);
    }

    public ArrayList<Product> getProducts() { //for product search
        return products;
    }


    // Only allow certain product types on tables (per specs)
    // Fruit, Vegetable, Bread, Eggs => FRU, VEG, BRD, EGG
    private boolean canBeOnTable(Product p) {
        String prefix = p.getSerialID().substring(0, 3);  // FRU, VEG, BRD, EGG
        return prefix.equals("FRU")
            || prefix.equals("VEG")
            || prefix.equals("BRD")
            || prefix.equals("EGG");
    }
}
