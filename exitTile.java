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
    public void draw(Graphics g) {
        g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
    }

    @Override
    public void onPlayerStep(Player player, Board board) {

        //  Block exit if the player is still carrying any products
        if (!player.getAllCarriedProducts().isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "You still have items with you.\n" +
                "Please return them to their displays or proceed to checkout before exiting.",
                "Cannot Exit Yet",
                JOptionPane.WARNING_MESSAGE
            );
            // Move player back in front of exit (your map uses 10,20)
            player.setPosition(10, 20);
            return;
        }

        // Block exit if the player is still holding any equipments
        if (player.hasEquipment()) {
            String equipmentName = player.getEquipment().getName();
            JOptionPane.showMessageDialog(
                null,
                "You are still carrying a " + equipmentName + ".\n" +
                "Please return it to a basket/cart station before exiting.",
                "Equipment Not Returned",
                JOptionPane.WARNING_MESSAGE
            );
            player.setPosition(10, 20);
            return;
        }

        // Only if inventory is clear, ask for final confirmation to exit
        int exitChoice = JOptionPane.showConfirmDialog(
            null,
            "Exit supermarket?",
            "Confirm",
            JOptionPane.YES_NO_OPTION
        );

        if (exitChoice == JOptionPane.YES_OPTION) {
            board.endSimulation();
        } else {
            // Place in front of the exit tile
            player.setPosition(10, 20);
        }
    }
}
