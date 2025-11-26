import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class stairTile extends gameObject {

    private int targetFloor;
    private BufferedImage sprite;

    public stairTile(int posX, int posY, int currentFloor, int targetFloor) {      
        super(posX, posY, false, currentFloor);        
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

    // Not using interact cause its only does its job by stepping on it
    // This has caused ridiculous amounts of annoyances
    @Override
    public void onPlayerStep(Player player, Board board) {

        player.setFloor(targetFloor);

        // This is getting ridiculous
        // Just spawn the player 1 tile above the stair when using it
        player.setPosition(posX, posY - 1);

        board.changeFloor(targetFloor);
        
        // Debug
        System.out.println("DEBUG: Stepped on stairs. Player floor: " 
                            + player.getCurrentFloor() + 
                            ", Board floor: " + board.getCurrentfloor());
    }
}
