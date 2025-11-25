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

        Player player = new Player(spawnX, spawnY);

        Board board = new Board(player);
        // Initialize the assets to be loaded in
        assetInitializer.intializeFloorOne(board);
        assetInitializer.intializeFloorTwo(board);

        inputHandler controller = new inputHandler(player, board);
        controller.attachKeyListener();

        // Create window frame with title at toolbar
        JFrame window = new JFrame("Project Shirayuki");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close app upon pressing exit button
        window.setResizable(false);     // Disallow resizing of the window 
        
        // SHOW THE MENU FIRST
        startMenu menu = new startMenu(window, board);      
        window.add(menu);  // Add the JPanel to the window
        // pack() fits window size around components (just the JPanel)
        // pack() should be called after setResizable() to avoid issues on some platforms
        window.pack();
        window.setLocationRelativeTo(null);     // Open window in the center of the screen
        window.setVisible(true);    // Display the window

        // Set app icon
        ImageIcon image = new ImageIcon(Driver.class.getResource("assets/app_icon.png"));
        window.setIconImage(image.getImage());

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