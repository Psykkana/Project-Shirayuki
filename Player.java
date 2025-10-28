import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
// import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.io.File;
import javax.imageio.ImageIO;

/*
 *      The Player Class
 *          The Model part of the MVC design model
 *          internal representation of information
 */

public class Player {

    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
    // Represents the player position on the board
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;    
    // Current position of the player on the board
    private Point pos;
    // Current floor of the player
    private int floor = 0;          // Starts on 0
    // Direction the player is facing in
    private Direction facing = Direction.UP;

    public Player() {
        // Load assets
        loadImage();

        // Initialize the character starting position
        pos = new Point(11, 21);
    }

    // Load the player icon
    private void loadImage() {
        try {
            // Load the assets
            playerUp = ImageIO.read(new File("assets/player_up.png"));
            playerDown = ImageIO.read(new File("assets/player_down.png"));
            playerLeft = ImageIO.read(new File("assets/player_left.png"));
            playerRight = ImageIO.read(new File("assets/player_right.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        BufferedImage playerSprite = playerUp;

        // Switch case to handle player direction visually
        switch (facing) {
            case UP:
                playerSprite = playerUp;
                break;
            case DOWN:
                playerSprite = playerDown;
                break;
            case LEFT:
                playerSprite = playerLeft;
                break;
            case RIGHT:
                playerSprite = playerRight;
                break;
        }

        // With Point class, pos.getX() returns a double but pos.x returns an int
        // translation of grid position to canvas pixel
        // position by multiplying by tile size
        g.drawImage(playerSprite, pos.x * Board.TILE_SIZE, pos.y * Board.TILE_SIZE, observer);
    }

    public void handleInput(KeyEvent e) {
        // Every keyboard get has a certain code
        // Get the value of that code from the keyboard event so we can compare with KeyEvent constants

        int key = e.getKeyCode();

        // LOOK INTO THE KeyEvent's potential outputs
        // https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
        switch (key) {
            // NOTE: Movement and direction faced are independent of each other

            // Movement inputs
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
                break;

            // Direction inputs
            case KeyEvent.VK_I:
                facing = Direction.UP;      // Look up
                break;
            case KeyEvent.VK_K:
                facing = Direction.DOWN;    // Look down
                break;
            case KeyEvent.VK_J:
                facing = Direction.LEFT;    // Look left
                break;
            case KeyEvent.VK_L:
                facing = Direction.RIGHT;   // Look right
                break;
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

    public Direction getDirection() {
        return facing;
    }

    // Position getter
    public Point getPos() {
        return pos;
    }

    // Floor level getter
    public int getFloor() {
        return floor;
    }

    // Method to change between GF and 2F
    public void moveFloor(int change) {
        int newFloor = floor + change;
        
        if (newFloor >= 0 && newFloor < Board.FLOORS) {
            floor = newFloor;
        }
    }

}
