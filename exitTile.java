import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 *  The exitTile class
 *      For the exit amenity on the first floor of the simulation
 *  
 */
public class exitTile extends gameObject {
    
    private BufferedImage sprite;

    public exitTile(int posX, int posY, int floor) {      
        super(posX, posY, false, floor);    
        
        try {
            sprite = ImageIO.read(new File("assets/exit.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (exitTile): " + exc.getMessage());
        }         
    }

    @Override
    public void onPlayerStep(Player player, Board board) {
        // NOTE: ADD ON LATER
        // make sure to check if the player has equipment and that they have
        // already paid before exiting

        int exitChoice = JOptionPane.showConfirmDialog(null, "Exit supermarket?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (exitChoice == JOptionPane.YES_OPTION) {
            // TODO: Check player equipment status
            
            // TODO: Check if player paid for products
            
            board.endSimulation();            
        } else {
            // Place in front of the exit tile
            player.setPosition(10, 20);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
    }
}
