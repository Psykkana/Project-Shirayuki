import java.awt.*;          // Drawing graphics
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;       // Stuff like JPanel and timer 

/*
 *      The Board Class
 *          Handles the actual board / map itself
 *          The primary View class of the MVC
 * 
 */

public class Board extends JPanel {

    // Size of each tile on the board (in pixels)
    public static final int TILE_SIZE = 30;
    public static final int X_AXIS_SIZE = 22;
    public static final int Y_AXIS_SIZE = 22;

    // // Suppresses serialization warning
    // private static final long serialVersionUID = 490905409104883233L;

    // Represents the player position on the board
    private BufferedImage playerChar;
    // Objects that appear in the game board
    private Player player;

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

    private void loadImages() {
        try {
            playerChar = ImageIO.read(new File("assets/player_up.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (Board): " + exc.getMessage());
        }
    }    

    @Override
    public void paintComponent(Graphics g) {
        // Use this to call the methods that build and fill up the grid

        super.paintComponent(g);        // Clears the screen first
        // When calling g.drawImage() we can use "this" for the ImageObserver
        // Component implments the ImageObserver interface and JPanel
        // extends from Component
        // "this" Board instance as a component can react to imageUpdate()
        // events triggered by g.drawImage()

        drawBackground(g);      // Draws the tiles
        drawText(g);           // Draws the text

        // Draw player based on position
        Point pos = player.getPos();
        playerChar = player.getCurrentSprite();;
        g.drawImage(playerChar, pos.x * TILE_SIZE, pos.y * TILE_SIZE, this);   // Draws the player character

        // Smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawBackground(Graphics g) {
        // Draw a checkered background
        g.setColor(new Color(218, 255, 169));

        // Generate tiled grid
        for (int yAxis = 0; yAxis < Y_AXIS_SIZE; yAxis++) {
            for (int xAxis = 0; xAxis < X_AXIS_SIZE; xAxis++) {
                // Only color every other tile
                if ((yAxis + xAxis) % 2 == 1) {
                    // Draw a square tile at current coordinate
                    g.fillRect(yAxis * TILE_SIZE, xAxis * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    private void drawText(Graphics g) {
        // Set text to be displayed
        String text = "Project Shirayuki";

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

}
