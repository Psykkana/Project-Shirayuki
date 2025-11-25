import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 *  The wallTile subclass
 *      An solid tile that the user cannot pass through
 *      Thats about it
 */

public class wallTile extends gameObject {

    private BufferedImage sprite;

    public wallTile(int posX, int posY, int floor) {
        super(posX, posY, true, floor);

    }

    @Override
    public void draw(Graphics g) {

        try {
            sprite = ImageIO.read(new File("assets/wall.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (wallTile): " + exc.getMessage());
        }

        g.drawImage(sprite,posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
        // g.setColor(Color.BLUE);
        // g.fillRect(posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
    }

    // No need for interaction (its a wall)
}
