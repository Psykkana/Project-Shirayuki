import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 *  The displayTile superclass
 *      Extends the gameObject class (so has location, solidity, and floor location)
 *      
 * 
 */

public abstract class displayTile extends gameObject implements  interactable {

    protected displayAddress address;
    protected String displayName;
    protected int capacity;
    protected BufferedImage sprite;

    public displayTile(int posX, int posY, int floor, displayAddress address, 
                        String name, int capacity) {
        super(posX, posY, true, floor);     // ALL DISPLAYS ARE SOLID
        this.address = address;
        this.displayName = name;
        this.capacity = capacity;
    }
    
    public displayAddress getDisplayAddress() {
        return address;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void loadSprite(String path) {
        try {
            sprite = ImageIO.read(new File(path));
        } catch (IOException exc) {
            System.out.println("Error opening image file (displayTile): " + exc.getMessage());
        }        
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, posX * Board.TILE_SIZE, posY * Board.TILE_SIZE, null);
    }

    @Override
    public void onInteract(Player player, Board board) {
        JOptionPane.showMessageDialog(null, "A displayTile at " + address.toString(), "DEBUG", JOptionPane.PLAIN_MESSAGE);
    }

}