import java.awt.Graphics;
import java.awt.Color;
/*
 *  The wallTile subclass
 * 
 * 
 */

public class wallTile extends gameObject{

    public wallTile(int posX, int posY, boolean solid) {
        super(posX, posY, true);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
    }

    // No need for interaction (its a wall)
}
