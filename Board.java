import java.awt.*;
import java.awt.event.*;
import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.Random;        // Might not use
import javax.swing.Timer;
import javax.swing.*;


public class Board extends JPanel implements ActionListener, KeyListener{

    // Tick delay controller (in ms)
    private final int DELAY = 25;

    // Size of the Board
    public static final int TILE_SIZE = 30;
    public static final int X_AXIS_SIZE = 22;
    public static final int Y_AXIS_SIZE = 22;

    // Suppresses serialization warning
    private static final long serialVersionUID = 490905409104883233L;

    // Keep a reference to the timer object that triggers actionPerfomed() 
    // in case we need access to it in another method
    private Timer timer;

    // Objects that appear in the game board
    private Player player;

    public Board() {
        // Set game board size
        setPreferredSize(new Dimension(TILE_SIZE * Y_AXIS_SIZE, TILE_SIZE * X_AXIS_SIZE));

        // Set board background color
        setBackground(new Color(163, 246, 48));

        // Initialize game state
        player = new Player();

        // timer will cal the actionPerformed() method every DELAY ms
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Called by the timer every DELAY ms
        // used to update state of the game or animation before graphics are redrawn

        // Prevent player from disappearing offscreen
        player.tick();

        // Calling repaint() will trigger paintComponent() to run again
        // which will refresh/redraw the graphics
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // When calling g.drawImage() we can use "this" for the ImageObserver
        // Component implments the ImageObserver interface and JPanel
        // extends from Component
        // "this" Board instance as a component can react to imageUpdate()
        // events triggered by g.drawImage()

        drawBackground(g);

        player.draw(g, this);

        // Smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // this is not used but must be defined as part of the KeyListener interface
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // React to key down events
        player.handleInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // React to key up events
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
