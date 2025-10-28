import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/*
 *  PROJECT SHIRAYUKI
 *      Basis for the MC02
 *      The GUI based supermarket simulator
 *      2D system using JFrames
 * 
 *  Major Sources:
 *      [1] https://github.com/learncodebygaming/java_2d_game/tree/master
 * 
 * 
 */

class Driver {

    private static void initializeWindow() {

        // Create window frame with title at toolbar
        JFrame window = new JFrame("Project Shirayuki b0.2");
        // Close app upon pressing exit button        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set window icon
        Image icon = Toolkit.getDefaultToolkit().getImage("assets/icon.png");
        window.setIconImage(icon);

        // Create the jpanel to draw on
        // also initialize the game loop
        Board board = new Board();

        // Add the JPanel to the window
        window.add(board);

        // Pass keyboard inputs to JPanel
        window.addKeyListener(board);

        // Disallow resizing of the window
        window.setResizable(false);

        // pack() fits window size around components (just the JPanel)
        // pack() should be called after setResizable() to avoid issues on some platforms
        window.pack();

        // Open window in the center of the screen
        window.setLocationRelativeTo(null);

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