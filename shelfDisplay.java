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
 *  shelfDisplay
 *      DisplayTile for all shelf-based products
 */
public class shelfDisplay extends displayTile {

    private ArrayList<Product> products;    // up to 8

    public shelfDisplay(int posX, int posY, int floor, displayAddress address) {
        super(posX, posY, floor, address, "Shelf Display", 8);
        loadSprite("assets/shelf.png");     // lets take note of this. this is the sprite name.
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        if (products.size() < capacity) {
            products.add(p);
        }
    }

    // Each image will be named 'serialID' + .png
    private ImageIcon getProductImage(Product p) {
        String productPrefix = p.getSerialID().substring(0, 3);
        String location;

        // CON is a protected name on windows, have to add a special check for it here
        if (productPrefix.equals("CON")) {
            location = "assets/products/COND.png";  // map to a valid file name
        } else {
            location = "assets/products/" + productPrefix + ".png";
        }

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

        System.out.println("Interacted with shelf at " + getPosX() + ", " + getPosY());

        final JFrame frame = new JFrame("Shelf Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setPreferredSize(new Dimension(550, 350));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));

        JLabel mainTitle = new JLabel("Shelf (" + address + ")", JLabel.CENTER);
        mainTitle.setFont(new Font("Leto", Font.BOLD, 20));
        mainPanel.add(mainTitle, BorderLayout.NORTH);

        // Shelf: 2 rows x 4 columns
        JPanel productPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        productPanel.setBackground(Color.GRAY);
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productPanel.setPreferredSize(new Dimension(340, 220));
        mainPanel.add(productPanel, BorderLayout.CENTER);

        for (int i = 0; i < capacity; i++) {
            final JButton productButton;

            if (i < products.size()) {
                // SLOT WITH PRODUCT: take item
                final Product p = products.get(i);

                ImageIcon icon = getProductImage(p);

                productButton = new JButton(p.getProductType(), icon);
                // b 0.7.9 - Add product name below the button icon
                productButton.setHorizontalTextPosition(JButton.CENTER);
                productButton.setVerticalTextPosition(JButton.BOTTOM);
                productButton.setPreferredSize(new Dimension(80, 80));
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //age checker
                         if (p.isRestrictedUnderage() && player.getAge() < 18) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You are too young to get this product.",
                                "Age Restricted",
                                JOptionPane.WARNING_MESSAGE                                                                                                    
                            );
                            return;
                        }
                        boolean taken = player.pickUpProduct(p);

                        if (!taken) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You cannot carry any more products.\n" +
                                "Return some items or get equipment with more capacity.",
                                "Inventory Full",
                                JOptionPane.WARNING_MESSAGE
                            );
                            return;
                        }

                        System.out.println("DEBUG: " + player.getName() + " picked up "
                                + p.getProductType() + " - " + p.getSerialID());

                        products.remove(p);
                        productButton.setEnabled(false);
                        productButton.setBackground(Color.LIGHT_GRAY);
                        productButton.setIcon(null);
                        productButton.setText("Product taken");
                    }
                });

            } else {
                // EMPTY SLOT: return shelf-allowed item
                productButton = new JButton("Empty");
                productButton.setBackground(Color.LIGHT_GRAY);
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Product toReturn = null;

                        // 1) check hands
                        for (Product hp : player.getHandProducts()) {
                            if (canBeOnShelf(hp)) {
                                toReturn = hp;
                                break;
                            }
                        }

                        // 2) check equipment
                        if (toReturn == null && player.getEquipment() != null) {
                            for (Product ep : player.getEquipment().getProducts()) {
                                if (canBeOnShelf(ep)) {
                                    toReturn = ep;
                                    break;
                                }
                            }
                        }

                        if (toReturn == null) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You have no items that can be placed on this shelf.",
                                "Return Product",
                                JOptionPane.INFORMATION_MESSAGE
                            );
                            return;
                        }

                        player.dropProduct(toReturn);
                        products.add(toReturn);

                        productButton.setEnabled(false);
                        productButton.setText("Returned");
                        productButton.setBackground(Color.WHITE);

                        System.out.println("DEBUG: " + player.getName()
                                + " returned " + toReturn.getProductType()
                                + " (" + toReturn.getSerialID() + ") to shelf at "
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ArrayList<Product> getProducts() { //for product search
        return products;
    }

    // Filter: only products that are only meant for shelves can be here so u cant return others(prefixes)
    private boolean canBeOnShelf(Product p) {
        String prefix = p.getSerialID().substring(0, 3);
        return prefix.equals("CER") || prefix.equals("NDL") || prefix.equals("SNK")
            || prefix.equals("CAN") || prefix.equals("CON") || prefix.equals("SFT")
            || prefix.equals("JUC") || prefix.equals("ALC") || prefix.equals("CLE")
            || prefix.equals("HOM") || prefix.equals("HAR") || prefix.equals("BOD")
            || prefix.equals("DEN") || prefix.equals("CLO") || prefix.equals("STN")
            || prefix.equals("PET");
    }
}
