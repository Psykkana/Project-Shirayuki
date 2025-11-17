import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class stairTile extends gameObject {

    private int targetX;
    private int targetY;
    private int targetFloor;
    private BufferedImage sprite;

    public stairTile(int posX, int posY, int currentFloor, int targetX, int targetY, int targetFloor) {      
        super(posX, posY, false, currentFloor);        
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetFloor = targetFloor;

        try {
            sprite = ImageIO.read(new File("assets/stairs.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (stairTile): " + exc.getMessage());
        }        
    }
   
    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
    }

    @Override
    public void interact(Player player) {
        player.setFloor(targetFloor);
    }
}
