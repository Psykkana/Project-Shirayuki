import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 *      The Player Class
 *          The user character
 *          Moves with W, A, S, D
 *          The primary Model class of the MVC
 * 
 */

public class Player {

    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    // Loads up the 4 different sprites for the player
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight; 

    // Current position of the player on the board
    private Point pos;

    // Direction faced by the user
    private Direction facing = Direction.UP;

    // Constant location for Spawn
    public static final int spawnX = 11;
    public static final int spawnY = 21;

    // Tracker for current floor
    private int currentFloor = 1;   // Starts on 1st floor

    public Player(int posX, int posY) {
        // Load character sprites
        loadSprites();

        // Initialize the character at spawn point 
        pos = new Point(spawnX, spawnY);
    }

    private void loadSprites() {
        try {
            // Load the assets
            playerUp = ImageIO.read(new File("assets/player_up.png"));
            playerDown = ImageIO.read(new File("assets/player_down.png"));
            playerLeft = ImageIO.read(new File("assets/player_left.png"));
            playerRight = ImageIO.read(new File("assets/player_right.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (Player): " + exc.getMessage());
        }        
    }


    // Right now this just enforces bounds
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

    // Handles the player's movements
    public void moveUp() {      // W
        pos.translate(0, -1);
        tick();
    }

    public void moveDown() {      // S
        pos.translate(0, 1);
        tick();
    }

    public void moveRight() {      // D
        pos.translate(1, 0);
        tick();
    }
    
    public void moveLeft() {      // A
        pos.translate(-1, 0);
        tick();
    }

    // Handles the player's vision
    public void faceUp() {
        facing = Direction.UP;
    }

    public void faceDown() {
        facing = Direction.DOWN;
    }    
 
    public void faceLeft() {
        facing = Direction.LEFT;
    }

    public void faceRight() {
        facing = Direction.RIGHT;
    }    

    // Position getter
    public Point getPos() {
        return pos;
    }

    // Direction getter
    public Direction getFacing() {
        return facing;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int setFloor(int targetFloor) {
        return currentFloor = targetFloor;
    }
    
    // Get the current direction sprite of the player
    public BufferedImage getCurrentSprite() {
        switch (facing) {
            case UP:
                return playerUp;
            case DOWN:
                return playerDown;
            case LEFT:
                return playerLeft;
            case RIGHT:
                return playerRight;
        }
        return playerUp;
    }

    // Get the tiles just in front of the player depending on what direction they move
    public Point getNextTile(Direction direction) {
        Point nextTile = new Point(pos.x, pos.y);

        switch (direction) {
            case UP:
                nextTile.translate(0, -1);     // The tile directly up by 1
                break;
            case DOWN:
                nextTile.translate(0, 1);
                break;
            case LEFT:
                nextTile.translate(-1, 0);
                break;
            case RIGHT:
                nextTile.translate(1, 0);
                break;
        }
    return nextTile;    
    }
} 
