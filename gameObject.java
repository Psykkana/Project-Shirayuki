
import java.awt.Graphics;

/*
 *  The gameObject class
 *      The superclass for all physical simulation objects (displays, services, etc.)
 *      To be used for inheritance purposes
 *      Has position coordiantes and boolean solid properties
 */

public abstract class gameObject {
    
    // Coordinate position of the object
    protected int posX;
    protected int posY;

    // Floor of the object
    protected int floor;

    // Flag for passability (primarily for walls)
    protected boolean solid;

    public gameObject(int posX, int posY, boolean solid, int floor) {
        this.posX = posX;
        this.posY = posY;
        this.solid = solid;
        this.floor = floor;
    }

    public boolean isSolid() {
        return solid;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getFloor() {
        return floor;
    }

    public void setPox(int x, int y) {
        posX = x;
        posY = y;
    }

    // Every object that extends this class must know how to draw itself
    public abstract void draw(Graphics g);

    // Empty so as to act as a placeholder for subclasses
    public void interact(Player player) {
    }

    // For tiles that can be stepped on (stairs, doors)
    public void onPlayerStep(Player player, Board board) {
    }
}
