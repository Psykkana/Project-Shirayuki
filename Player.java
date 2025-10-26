import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Player {
    
    // Represents the player position on the board
    private BufferedImage image;
    // Current position of the player on the board
    private Point pos;

    public Player() {
        // Load assets
        loadImage();

        // Initialize the character
        pos = new Point(11, 21);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/player.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        // With Point class, pos.getX() returns a double but pos.x returns an int
        // translation of grid position to canvas pixel
        // position by multiplying by tile size
        g.drawImage(image, pos.x * Board.TILE_SIZE, pos.y * Board.TILE_SIZE, observer);
    }

    public void handleInput(KeyEvent e) {
        // Every keyboard get has a certain code
        // Get the value of that code from the keyboard event so we can compare with KeyEvent constants

        int key = e.getKeyCode();

        // LOOK INTO THE KeyEvent's potential outputs
        // https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
        switch (key) {
            case KeyEvent.VK_W:             // Move up 1 tile
                pos.translate(0, -1);
                break;
            case KeyEvent.VK_S:             // Move down 1 tile
                pos.translate(0, 1);
                break;
            case KeyEvent.VK_A:             // Move left 1 tile
                pos.translate(-1,0);
                break;
            case KeyEvent.VK_D:             // Move right 1 tile
                pos.translate(1,0);
        }
    }

    public void tick() {
        // Gets called once every tick
        
        // Prevent player from moving out of bounds on Y axis
        if (pos.x < 0 ) {
            pos.x = 0;
        } else if (pos.x >= Board.Y_AXIS_SIZE) {
            pos.x = Board.Y_AXIS_SIZE - 1;
        }

        // Prevent player from moving out of bounds on X axis
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= Board.X_AXIS_SIZE) {
            pos.y = Board.X_AXIS_SIZE - 1;
        }
    }

    // Position getter
    public Point getPos() {
        return pos;
    }
}
