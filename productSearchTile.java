import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 *  The productSearchTile class
 *      Service tile that lets the shopper search for products
 *      by name all display addresses that have it.
 */

public class productSearchTile extends gameObject implements interactable {

    private BufferedImage sprite;

    public productSearchTile(int posX, int posY, int floor) {
        super(posX, posY, true, floor);

        try {
            // Use whatever icon you saved for the info/search tile
            sprite = ImageIO.read(new File("assets/product_search.png"));
            // or "assets/info.png" if that's what you used
        } catch (IOException exc) {
            System.out.println("Error opening image file (productSearchTile): " + exc.getMessage());
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

        String query = JOptionPane.showInputDialog(
            null,
            "Enter product name:",
            "Product Search",
            JOptionPane.QUESTION_MESSAGE
        );

        if (query == null) {
            // User cancelled
            return;
        }

        query = query.trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "Search term must not be empty.",
                "Product Search",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String queryLower = query.toLowerCase();
        ArrayList<String> matches = new ArrayList<>();

        // Scan all objects on the board
        for (gameObject obj : board.getObjects()) {
            if (obj instanceof displayTile) {
                displayTile disp = (displayTile) obj;
                if (displayHasMatchingProduct(disp, queryLower)) {
                    // Use the display's address from displayTile
                    matches.add(disp.getDisplayAddress().toString());
                }
            }
        }

        if (matches.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "No displays found containing a product matching \"" + query + "\".",
                "Product Search",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Displays containing products matching \"")
              .append(query)
              .append("\":\n\n");

            for (String addr : matches) {
                sb.append("• ").append(addr).append("\n");
            }

            JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Product Search Results",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Check if this display has at least one product that matches the search text
    private boolean displayHasMatchingProduct(displayTile display, String queryLower) {
        // Table
        if (display instanceof tableDisplay) {
            for (Product p : ((tableDisplay) display).getProducts()) {
                if (productMatches(p, queryLower)) return true;
            }
        }
        // Shelf
        else if (display instanceof shelfDisplay) {
            for (Product p : ((shelfDisplay) display).getProducts()) {
                if (productMatches(p, queryLower)) return true;
            }
        }
        // Fridge
        else if (display instanceof fridgeDisplay) {
            for (Product p : ((fridgeDisplay) display).getProducts()) {
                if (productMatches(p, queryLower)) return true;
            }
        }
        // Chilled counter
        else if (display instanceof chilledDisplay) {
            for (Product p : ((chilledDisplay) display).getProducts()) {
                if (productMatches(p, queryLower)) return true;
            }
        }

        return false;
    }

    // What counts as a "match"?
    private boolean productMatches(Product p, String queryLower) {
        if (p == null) return false;

        // Match on productType 
        if (p.getProductType() != null &&
            p.getProductType().toLowerCase().contains(queryLower)) {
            return true;
        }

        // for matching serial ID
        if (p.getSerialID() != null &&
            p.getSerialID().toLowerCase().contains(queryLower)) {
            return true;
        }

        //yehey
        return false;
    }
}
