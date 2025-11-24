import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 *  The basketStationTile class
 *      Player can pick up / return a basket here
 */

public class basketStationTile extends gameObject implements interactable {

    private BufferedImage sprite;

    public basketStationTile(int posX, int posY, int floor) {
        // Solid so the player can't walk through it, must stand in front & press E
        super(posX, posY, true, floor);

        try {
            // Change the path/name if your actual asset file is different
            sprite = ImageIO.read(new File("assets/basket_station.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (basketStationTile): " + exc.getMessage());
        }
    }

    @Override
    public void draw(Graphics g) {
        if (sprite != null) {
            g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
        }
    }

    @Override
    public void onInteract(Player player, Board board) {
        Equipment current = player.getEquipment();

        // No equipment yet → give basket
        if (current == null) {
            player.setEquipment(new Basket());
            JOptionPane.showMessageDialog(
                null,
                "You picked up a basket.",
                "Basket Station",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // Already carrying a basket → try to return it
        if (current instanceof Basket) {
            if (current.getCurrentLoad() > 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "You must empty your basket before returning it.",
                    "Basket Station",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                player.setEquipment(null);
                JOptionPane.showMessageDialog(
                    null,
                    "You returned your basket.",
                    "Basket Station",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            return;
        }

        // Carrying a cart, trying to use basket station
        JOptionPane.showMessageDialog(
            null,
            "You are already using a " + current.getName() + ".\n" +
            "Return it before taking a basket.",
            "Basket Station",
            JOptionPane.WARNING_MESSAGE
        );
    }
}
