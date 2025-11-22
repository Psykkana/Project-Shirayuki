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

/*
 *  The tableDisplay subclass
 *      A displayTile     
 * 
 */

public class tableDisplay extends displayTile {

    private ArrayList<Product> products;    // Max of

    public tableDisplay(int posX, int posY, int floor, displayAddress address) {
        super(posX, posY, floor, address, "Table Display" , 4);
        loadSprite("assets/table.png");
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        if (products.size() < 4) {  // If there are less than 4 products
            products.add(p);    // Add the product
        }
    }

    @Override
    public void onInteract(Player player, Board board) {

        // DEBUG
        System.out.println("Interacted with table at " + getPosX() + ", " + getPosY());

        // THE ACTUAL GUI FRAMEWORK HERE
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setPreferredSize(new Dimension(300, 300));        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));
    
        // The Text above the Products (the Address)
        JLabel mainTitle = new JLabel("Table (" + address + ")", JLabel.CENTER);
        mainTitle.setFont(new Font("Leto", Font.BOLD, 20));
        mainPanel.add(mainTitle, java.awt.BorderLayout.NORTH);

        // The Inner Product Panel (2x2)
        JPanel productPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        productPanel.setBackground(Color.GRAY);
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        productPanel.setPreferredSize(new Dimension(220, 220));

        mainPanel.add(productPanel, java.awt.BorderLayout.CENTER);
    
        // Create 4 buttons for 4 product slots
        for (int i = 0; i < 4; i++) {
            final JButton productButton;

            if (i < products.size()) {
                final Product p = products.get(i);
                
                // Set the button to have an image
                ImageIcon icon = new ImageIcon("assets/placeholder100x100.png");
                icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
                
                productButton = new JButton(icon);
                productButton.setPreferredSize(new Dimension(100, 100));
                productButton.setFocusable(false);

                productButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // DEBUG
                        System.out.println("DEBUG: " + player.getName() + " picked up " + p.getProductType() + " - " + p.getSerialID());

                        products.remove(p);
                        productButton.setEnabled(false);
                        productButton.setBackground(Color.LIGHT_GRAY);      // Visually make ianctive
                        productButton.setIcon(null);                        // optionally remove the icon
                        productButton.setText("Product taken");                    // optional text
                    }
                });

            } else {
                // Empty slot
                productButton = new JButton();
                productButton.setEnabled(false);
                productButton.setBackground(Color.LIGHT_GRAY);
            }
            
            productButton.setFocusable(false);
            productPanel.add(productButton);
        }

        JFrame frame = new JFrame("Table Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);  // Center on screen
        frame.setVisible(true);
    }    
}
