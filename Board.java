import java.awt.*;          // Drawing graphics
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;       // Stuff like JPanel and timer 
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 *      The Board Class
 *          Handles the actual board / map itself
 *          The primary View class of the MVC
 * 
 */

public class Board extends JPanel {

    // Size of each tile on the board (in pixels)
    public static final int TILE_SIZE = 35;
    public static final int X_AXIS_SIZE = 22;
    public static final int Y_AXIS_SIZE = 22;

    // Represents the player and player position on the board
    private BufferedImage playerChar;
    private Player player;

    // The Floors
    private int currentFloor = 1;  

    // Store arraylist of objects
    private ArrayList<gameObject> objects;

///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Constructor
    public Board(Player player) {
        this.player = player;

        objects = new ArrayList<>();

        // Set game board size
        setPreferredSize(new Dimension(TILE_SIZE * Y_AXIS_SIZE, TILE_SIZE * X_AXIS_SIZE));

        // Set board background color
        setBackground(new Color(163, 246, 48));

        setFocusable(true);
        requestFocusInWindow();

        loadImages();
    }

    public void addObject(gameObject gObj) {
        objects.add(gObj);
    }

    public void removeObject(gameObject gObj) {
        objects.remove(gObj);
    }

    public ArrayList<gameObject> getObjects() {
        return objects;
    }

    public int getCurrentfloor() {
        return currentFloor;
    }

    // technically a setter
    public void changeFloor(int floor) {
        currentFloor = floor;
        repaint();
    }

    public Player getPlayer() {
        return this.player;
    }

    // Load the starting player position image (facing up)
    private void loadImages() {
        try {
            playerChar = ImageIO.read(new File("assets/player_up.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (Board): " + exc.getMessage());
        }
    }    

    // For non-solid tile checking
    public gameObject getTileObject(int posX, int posY, int floor) {
        for (gameObject obj : objects) {
            if (obj.getPosX() == posX && obj.getPosY() == posY && obj.getFloor() == floor) {
                return obj;
            }
        }
        return null;
    }

///////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void paintComponent(Graphics g) {
        // Use this to call the methods that build and fill up the grid

        super.paintComponent(g);        // Clears the screen first

        drawBackground(g);      // Draws the background tiles

        // Draw the current floor with their corresponding assets
        for (gameObject obj : objects) {
            if (obj.getFloor() == currentFloor) {
                obj.draw(g);
            }
        }

        // Draw player based on position
        if (player.getCurrentFloor() == currentFloor) {
            Point pos = player.getPos();
            playerChar = player.getCurrentSprite();;
            g.drawImage(playerChar, pos.x * TILE_SIZE, pos.y * TILE_SIZE, this);   // Draws the player character

        }

        drawText(g);           // Draws the text

        // Smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

    // PRIMARILY FOR THE SIMULATION PANEL CLASS
    public void drawBoard(Graphics g) {
        drawBackground(g);

        for (gameObject object : objects) {
            if (object.getFloor() == currentFloor) {
                object.draw(g);
            }
        }

        drawText(g);
    }

    public void drawBackground(Graphics g) {
        // Draw a checkered background
        g.setColor(new Color(218, 255, 169));

        // Generate tiled grid
        for (int yAxis = 0; yAxis < Y_AXIS_SIZE; yAxis++) {
            for (int xAxis = 0; xAxis < X_AXIS_SIZE; xAxis++) {
                // Only color every other tile
                if ((xAxis + yAxis) % 2 == 1) {
                    // Draw a square tile at current coordinate
                    g.fillRect(yAxis * TILE_SIZE, xAxis * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    private void drawText(Graphics g) {
        // Set text to be displayed
        String text = "Project Shirayuki b0.8";

        // Cast the Graphics to Graphics2D to draw nicer text
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        // Set text color and font
        g2d.setColor(new Color(255, 0, 0));
        g2d.setFont(new Font("Lato", Font.PLAIN, 25));

        // Draw text on the bottom center of the screen
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());

        // Text will be contained within this rectangle
        Rectangle rect = new Rectangle(0, TILE_SIZE * (Y_AXIS_SIZE - 1), TILE_SIZE * X_AXIS_SIZE, TILE_SIZE);

        // Determine the x coordinate of the text
        // We can add the ascent as in Java 2d 0 is on top of the screen
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;

        // Determine the y coordinate of the text
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        // Draw the string
        g2d.drawString(text, x, y);
    }

    // Shows a popup window with all chosen products and totals
    public void showChosenProductsView() {
        Player p = this.player;

        List<Product> carried = p.getAllCarriedProducts();

        if (carried.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "You are not carrying any products yet.",
                "Chosen Products",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // Group by productType
        Map<String, ProductSummary> summaryMap = new HashMap<>();

        for (Product prod : carried) {
            String key = prod.getProductType();
            ProductSummary sum = summaryMap.get(key);

            if (sum == null) {
                sum = new ProductSummary(key, prod.getPrice());
                summaryMap.put(key, sum);
            }

            sum.quantity++;
            sum.totalPrice = sum.quantity * sum.unitPrice;
        }

        // Build table data
        Object[][] rowData = new Object[summaryMap.size()][3];
        String[] columnNames = { "Product", "Quantity", "Total Price (PHP)" };

        int i = 0;
        for (ProductSummary sum : summaryMap.values()) {
            rowData[i][0] = sum.name;
            rowData[i][1] = sum.quantity;
            rowData[i][2] = String.format("%.2f", sum.totalPrice);
            i++;
        }
        // Compute the overall total price
        double overallTotal = 0.0;
        for (ProductSummary sum : summaryMap.values()) {
            overallTotal += sum.totalPrice;
        }

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        String equipmentName = p.hasEquipment() ? p.getEquipment().getName() : "Hands";
        JLabel label = new JLabel("Equipment: " + equipmentName, SwingConstants.CENTER);

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        // Show overall total at bottom
        JLabel totalLabel = new JLabel(
            "OVERALL TOTAL: " + String.format("%.2f PHP", overallTotal),
            SwingConstants.CENTER
        );
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(totalLabel, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(
            this,
            panel,
            "Chosen Products",
            JOptionPane.PLAIN_MESSAGE
        );
    }

    // Call to end the program
    public void endSimulation() {
        System.out.println("Exiting the simulation");
        System.exit(0);
    }

        // Helper class for summarizing unique products
    private static class ProductSummary {
        String name;
        double unitPrice;
        int quantity;
        double totalPrice;

        ProductSummary(String name, double unitPrice) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.quantity = 0;
            this.totalPrice = 0.0;
        }
    }

}

