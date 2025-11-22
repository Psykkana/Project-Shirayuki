import java.awt.Graphics;
import java.awt.Color;
/*
 *  The wallTile subclass
 *      An solid tile that the user cannot pass through
 *      Thats about it
 */

public class wallTile extends gameObject {

    public wallTile(int posX, int posY, int floor) {
        super(posX, posY, true, floor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
    }

    // No need for interaction (its a wall)
}
