import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 *  The cartStationTile class
 *      Player can pick up / return a cart here
 */

public class cartStationTile extends gameObject implements interactable {

    private BufferedImage sprite;

    public cartStationTile(int posX, int posY, int floor) {
        // Solid so the player can't walk in the same tile
        super(posX, posY, true, floor);

        try {
            // Change filename if needed to match your assets
            sprite = ImageIO.read(new File("assets/cart_station.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (cartStationTile): " + exc.getMessage());
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

        // No equipment yet → give cart
        if (current == null) {
            player.setEquipment(new Cart());
            JOptionPane.showMessageDialog(
                null,
                "You picked up a cart.",
                "Cart Station",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // Already carrying a cart → try to return it
        if (current instanceof Cart) {
            if (current.getCurrentLoad() > 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "You must empty your cart before returning it.",
                    "Cart Station",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                player.setEquipment(null);
                JOptionPane.showMessageDialog(
                    null,
                    "You returned your cart.",
                    "Cart Station",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            return;
        }

        // Carrying a basket, trying to use cart station
        JOptionPane.showMessageDialog(
            null,
            "You are already using a " + current.getName() + ".\n" +
            "Return it before taking a cart.",
            "Cart Station",
            JOptionPane.WARNING_MESSAGE
        );
    }
}
