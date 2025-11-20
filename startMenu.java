import java.awt.*;          // Drawing graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class startMenu extends JPanel {
    
    private BufferedImage titleImage;
    private static final int TITLE_WIDTH = 450;
    private static final int TITLE_HEIGHT = 225;
    private static final int IMG_OFFSET_X = 90;
    private static final int IMG_OFFSET_Y = 150;

    // Calculations for centering the buttons and other assets    
    private static final int buttonWidth = 200;
    private static final int buttonHeight = 50;
    private static final int frameWidth = Board.TILE_SIZE * Board.Y_AXIS_SIZE;    
    private static final int frameCenter = (frameWidth - buttonWidth) / 2;

    public startMenu(JFrame frame, Board simulation) {

        // Layout manager - use no layout manager 
        setLayout(null);

        setBackground(new Color(160, 225, 78));        

        setPreferredSize(new Dimension(Board.TILE_SIZE * Board.Y_AXIS_SIZE,
                                       Board.TILE_SIZE * Board.X_AXIS_SIZE));

        loadTitleImage();

        // The JPanel for the Start button
        // NOTE TO SELF: CHANGE THE LOCATIONS OF THE BUTTONS
        JButton startButton = new JButton("Start Simulation");
        // Center the button
        startButton.setBounds(frameCenter, 400, buttonWidth, buttonHeight);   
        startButton.addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                // Collect and parse the inputs
                String playerName = JOptionPane.showInputDialog(startMenu.this, "Enter your name: ");
                int playerAge = Integer.parseInt(JOptionPane.showInputDialog(startMenu.this, "Enter your age: "));
                Player player = simulation.getPlayer();

                player.setName(playerName);
                player.setAge(playerAge);

                // Switch to the actual simulation
                frame.getContentPane().removeAll();
                frame.getContentPane().add(simulation);
                frame.revalidate();     // update the layout of components
                frame.repaint();        
                simulation.requestFocusInWindow();
            }
        });

        // The Exit button
        JButton exitButton = new JButton("Exit Program");
        exitButton.setBounds(frameCenter, 500, buttonWidth, buttonHeight);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);     // Terminates the Java Virtual Machine 
            }
        });

        add(startButton);
        add(exitButton);
    } 

    private void loadTitleImage() {
        try {
            titleImage = ImageIO.read(new File("assets/titleImage.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file (startMenu): " + exc.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        // Draw the background color

        g.drawImage(titleImage, frameCenter - IMG_OFFSET_X, IMG_OFFSET_Y, TITLE_WIDTH, TITLE_HEIGHT, this);

        // Smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

}
