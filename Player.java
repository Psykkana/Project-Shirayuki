import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/*
 *      The Player Class
 *          The user character
 *          Moves with W, A, S, D
 *          The primary Model class of the MVC
 *          Be ready for methods that reach the ends of Earth
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

    // Tracker for current floor
    private int currentFloor = 1;   // Starts on 1st floor

    // Constant location for Spawn
    private static final int spawnX = 11;
    private static final int spawnY = 21;

    // Actual user inputted data
    private String name;
    private int age;

    //Equipments carried by the user
    private Equipment equipment;
    
    //Products carried on hand if user has no equipment currently
    private ArrayList<Product> handProducts = new ArrayList<>();

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
    // 17/11/2025 b0.5 - merged all 4 movement methods into one
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

    // Unified movement method
    public void moveDirection(Direction direction) {
        switch (direction) {
            case UP: 
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
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

    // Current floor getter
    public int getCurrentFloor() {
        return currentFloor;
    }

    // floor setter
    public int setFloor(int targetFloor) {
        return currentFloor = targetFloor;
    }

    public void setPosition(int x, int y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public boolean hasEquipment() {
        return equipment != null;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public ArrayList<Product> getHandProducts() {
        return handProducts;
    }

    // Return every product the player is currently carrying
    public List<Product> getAllCarriedProducts() {
        List<Product> all = new ArrayList<>();

        // Hand-carried products
        all.addAll(handProducts);

        // Products in equipment (basket/cart), if any
        if (equipment != null) {
            all.addAll(equipment.getProducts());
        }

        return all;
    }


    public boolean isHandsFull() {
        return handProducts.size() >= 2;
    }

    public int getTotalCarriedItems() {
        int total = handProducts.size();
        if (equipment != null) {
            total += equipment.getCurrentLoad();
        }
        return total;
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

    // PRIMARILY FOR THE SIMULATION PANEL CLASS
    public void draw(Graphics g) {
        if (playerUp == null) {
            return;
        }

        g.drawImage(getCurrentSprite(), pos.x * Board.TILE_SIZE, pos.y * Board.TILE_SIZE, null);
    }
     /**
     * Attempts to add a product to the player's inventory.
     * Priority:
     *  1. Put in equipment if present and not full.
     *  2. Otherwise, hand-carry (up to 2 items).
     * Returns true if the product was successfully taken.
     */
    public boolean pickUpProduct(Product p) {

        // If player has equipment, try to put product there first
        if (equipment != null && !equipment.isFull()) {
            equipment.addProduct(p);
            return true;
        }

        // Otherwise, use hands (max 2 products)
        if (!isHandsFull()) {
            handProducts.add(p);
            return true;
        }

        // No space anywhere
        return false;
    }

    /**
     * Removes a product the player is carrying.
     * Used when returning items to displays.
     */
    public boolean dropProduct(Product p) {
        if (equipment != null && equipment.getProducts().contains(p)) {
            return equipment.removeProduct(p);
        }
        return handProducts.remove(p);
    }

} 
