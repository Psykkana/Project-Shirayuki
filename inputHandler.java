import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 *      The InputHandler Class
 *          Handles user inputs
 *          Updates the model
 *          Acts as the controller of the MVC
 *          
 */

public class inputHandler implements KeyListener {  
    // NOTE: NO NEED TO PUT KEYLISTENER IN UML
    
    // Load the board and player
    private Board board;
    private Player player;

    public inputHandler(Player player, Board board) {
        this.player = player;
        this.board = board;
        board.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Every keyboard get has a certain code
        // Get the value of that code from the keyboard event 
        // so we can compare with KeyEvent constants

        int key = e.getKeyCode();

        // NOTE: Look into KeyEvent's potential outputs
        // https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
        switch (key) {
            // Movement Inputs
            case KeyEvent.VK_W:             // Move up 1 tile
                moveAttempt(Player.Direction.UP);
                break;
            case KeyEvent.VK_S:             // Move down 1 tile
                moveAttempt(Player.Direction.DOWN);          
                break;
            case KeyEvent.VK_A:             // Move left 1 tile
                moveAttempt(Player.Direction.LEFT);
                break;
            case KeyEvent.VK_D:             // Move right 1 tile
                moveAttempt(Player.Direction.RIGHT);
                break;

            // Vision inputs (Direction)
            case KeyEvent.VK_I:             // Look up             
                player.faceUp();
                break;
            case KeyEvent.VK_K:             // Look down
                player.faceDown();
                break;
            case KeyEvent.VK_J:             // Look left
                player.faceLeft();
                break;
            case KeyEvent.VK_L:             // Look right
                player.faceRight();
                break;

            // User interaction
            case KeyEvent.VK_E:
                interactAttempt();
                break;
        }
        board.repaint();
    }   

    // Check movement if its possible (Yes or No) then make the move
    private void moveAttempt(Player.Direction direction) {

        Point nextTile = player.getNextTile(direction);

        // Collision check with all the objects on the board
        for (gameObject objects : board.getObjects()) {
            if (objects.getPosX() == nextTile.x && 
                objects.getPosY() == nextTile.y &&
                objects.getFloor() == player.getCurrentFloor()) {
                if (objects.isSolid()) {
                   return;  // Block movement (exits the method)
                }
            }
        }

        // Actually move the character
        player.moveDirection(direction);

        // Interaction checks (for non-solid tiles)
        for (gameObject objects : board.getObjects()) {
            if (objects.getPosX() == player.getPos().x && 
                objects.getPosY() == player.getPos().y &&
                objects.getFloor() == player.getCurrentFloor()) {
                objects.onPlayerStep(player, board);    // trigger interaction
            }
        }
    }

    private void interactAttempt() {
        Point frontTile = player.getNextTile(player.getFacing());
        // Get the tile directly in front of what user is facing

        // Check interactibility
        for (gameObject objects : board.getObjects()) {
            if (objects.getPosX() == player.getPos().x && 
                objects.getPosY() == player.getPos().y &&
                objects.getFloor() == player.getCurrentFloor()) {
                objects.onInteract(player, board);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // this is not used but must be defined as part of the KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // React to key up events
    }    

}
