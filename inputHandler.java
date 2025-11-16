import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/*
 *      The InputHandler Class
 *          Handles user inputs
 *          Updates the model
 *          Acts as the controller of the MVC
 *          
 */

public class inputHandler implements KeyListener{
    
    // Load the board
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
        // Get the value of that code from the keyboard event so we can compare with KeyEvent constants

        int key = e.getKeyCode();

        // LOOK INTO THE KeyEvent's potential outputs
        // https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
        switch (key) {
            // Movement Inputs
            case KeyEvent.VK_W:             // Move up 1 tile
                player.moveUp();                    
                break;
            case KeyEvent.VK_S:             // Move down 1 tile
                player.moveDown();;
                break;
            case KeyEvent.VK_A:             // Move left 1 tile
                player.moveLeft();
                break;
            case KeyEvent.VK_D:             // Move right 1 tile
                player.moveRight();
                break;

            // Vision inputs (Direction)
            case KeyEvent.VK_I:
                player.faceUp();
                break;
            case KeyEvent.VK_K:
                player.faceDown();
                break;
            case KeyEvent.VK_J:
                player.faceLeft();
                break;
            case KeyEvent.VK_L:
                player.faceRight();
                break;
        }
        board.repaint();
    }   

    // Check movement if its possible (Yes or No)
    private boolean checkCollisions(Player.Direction direction) {
        Point nextTile = player.getNextTile(direction);

        // Go through the arraylist of game objects
        for (gameObject objects : board.getObjects()) {
            if (objects.getPosX() == nextTile.x && objects.getPosY() == nextTile.y) {
                if (objects.isSolid() == true);
                    return false;   // Block movement
            }
        }
        return true;        // Allow movement
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
