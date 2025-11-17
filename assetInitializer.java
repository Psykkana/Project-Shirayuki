import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/*
 *  The Asset Initializer Class
 *      Does things like initialize the map objects to be placed in the board
 */

public class assetInitializer {
    
    // For readabilities sake
    static final int isSolid = 1;   

    // Objects and displays of the 1st Floor    
    public static void intializeFloorOne(Board board) {

        // Stairs
        board.addObject(new stairTile(1, 15, isSolid, 1, 15, 2));

        // The walls on the top side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 0, isSolid));            
        }

        // The walls on the bottom side
        for (int x = 0; x <= 9; x++) {
            board.addObject(new wallTile(x, 21, isSolid));            
        }        

        for (int x = 12; x <= 21; x++) {
            board.addObject(new wallTile(x, 21, isSolid));            
        }

        // The walls on the left side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(0, y, isSolid));           
        }

        // The walls on the right side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(21, y, isSolid));           
        }

        // The walls between the checkout counters
        board.addObject(new wallTile(1, 18, isSolid));
        board.addObject(new wallTile(3, 18, isSolid));
        board.addObject(new wallTile(5, 18, isSolid));
        board.addObject(new wallTile(7, 18, isSolid));
        board.addObject(new wallTile(14, 18, isSolid));
        board.addObject(new wallTile(16, 18, isSolid));
        board.addObject(new wallTile(18, 18, isSolid));
        board.addObject(new wallTile(20, 18, isSolid));        

        // The middle walls
        board.addObject(new wallTile(10, 17, isSolid));
        board.addObject(new wallTile(11, 17, isSolid));
        board.addObject(new wallTile(10, 18, isSolid));
        board.addObject(new wallTile(11, 18, isSolid));
    }

    // Objects and displays of the 2nd Floor     
    public static void intializeFloorTwo(Board board) {
        // The walls on the top side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 0, isSolid));            
        }

        // The walls on the bottom side
        for (int x = 0; x <= 21; x++) {
            board.addObject(new wallTile(x, 21, isSolid));            
        }        

        // The walls on the left side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(0, y, isSolid));           
        }

        // The walls on the right side
        for (int y = 1; y <= 21; y++) {
             board.addObject(new wallTile(21, y, isSolid));           
        }        
    }

}
