import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/*
 *  fridgeDisplay
 *      DisplayTile for refrigerator items
 */
public class fridgeDisplay extends displayTile {

    private ArrayList<Product> products;    // up to 9

    public fridgeDisplay(int posX, int posY, int floor, displayAddress address) {
        super(posX, posY, floor, address, "Refrigerator Display", 9);
        loadSprite("assets/refrigerator.png");   // adjust filename if needed
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        if (products.size() < capacity) {
            products.add(p);
        }
    }

    @Override
    public void onInteract(Player player, Board board) {

        System.out.println("Interacted with fridge at " + getPosX() + ", " + getPosY());

        final JFrame frame = new JFrame("Refrigerator Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setPreferredSize(new Dimension(400, 350));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));

        JLabel mainTitle = new JLabel("Refrigerator (" + address + ")", JLabel.CENTER);
        mainTitle.setFont(new Font("Leto", Font.BOLD, 20));
        mainPanel.add(mainTitle, BorderLayout.NORTH);

        // Fridge: 3 x 3 grid
        JPanel productPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        productPanel.setBackground(Color.GRAY);
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productPanel.setPreferredSize(new Dimension(340, 260));
        mainPanel.add(productPanel, BorderLayout.CENTER);

        for (int i = 0; i < capacity; i++) {
            final JButton productButton;

            if (i < products.size()) {
                final Product p = products.get(i);

                ImageIcon icon = new ImageIcon("assets/placeholder100x100.png");
                icon = new ImageIcon(
                    icon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)
                );

                productButton = new JButton(icon);
                productButton.setPreferredSize(new Dimension(80, 80));
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

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
                // empty slot -> return fridge-allowed item
                productButton = new JButton("Empty");
                productButton.setBackground(Color.LIGHT_GRAY);
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Product toReturn = null;

                        for (Product hp : player.getHandProducts()) {
                            if (canBeOnFridge(hp)) {
                                toReturn = hp;
                                break;
                            }
                        }

                        if (toReturn == null && player.getEquipment() != null) {
                            for (Product ep : player.getEquipment().getProducts()) {
                                if (canBeOnFridge(ep)) {
                                    toReturn = ep;
                                    break;
                                }
                            }
                        }

                        if (toReturn == null) {
                            JOptionPane.showMessageDialog(
                                frame,
                                "You have no items that can be placed in this refrigerator.",
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
                                + " (" + toReturn.getSerialID() + ") to fridge at "
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

    private boolean canBeOnFridge(Product p) {
        String prefix = p.getSerialID().substring(0, 3);
        return prefix.equals("MLK") || prefix.equals("FRZ") || prefix.equals("CHS");
    }
}
