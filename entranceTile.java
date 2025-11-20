import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class entranceTile extends gameObject {

    private BufferedImage sprite;
    
    public entranceTile(int posX, int posY, int floor) {
        super(posX, posY, false, floor);

        try {
            sprite = ImageIO.read(new File("assets/entrance.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (exitTile): " + exc.getMessage());
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
    } 

}
