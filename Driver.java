import javax.swing.*;

/*
 *  PROJECT SHIRAYUKI
 *      Basis for the MC02
 *      The GUI based supermarket simulator
 *      2D system using JFrames
 */


 /*
  *     The Driver Class 
  *         Handles the JFrame window and its properties
  *         Also initalizes and handles the simulation
  *
  */

class Driver {

    private static void initializeWindow() {

        // Constant location for Spawn
        final int spawnX = 11;
        final int spawnY = 21;

        // Create Model
        Player player = new Player(spawnX, spawnY);

        // Create View
        Board board = new Board(player);

        // Create Controller
        inputHandler controller = new inputHandler(player, board);

        // Create window frame with title at toolbar
        JFrame window = new JFrame("Project Shirayuki");
        // Close app upon pressing exit button        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the JPanel to the window
        window.add(board);

        // Disallow resizing of the window
        window.setResizable(false);

        // Set app icon
        ImageIcon image = new ImageIcon("images/player.png");    // create image icon
        window.setIconImage(image.getImage());    // change icon of frame

        // pack() fits window size around components (just the JPanel)
        // pack() should be called after setResizable() to avoid issues on some platforms
        window.pack();

        // Open window in the center of the screen
        window.setLocationRelativeTo(null);

        // Initialize the assets to be loaded in
        assetInitializer.intializeFloorOne(board);

        // Display the window
        window.setVisible(true);

    }

    public static void main(String[] args) {
        // invokeLater() to prevent graphics processing from blocking the GUI
        // Just a lot of boilerplate code
        // When main runs it will call initializeWindow() once
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeWindow();
            }
        });
    }
}