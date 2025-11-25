import java.awt.*;          // Drawing graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.JTextField;

public class startMenu extends JPanel {
    
    private BufferedImage titleImage;
    private static final int TITLE_WIDTH = 600;
    private static final int TITLE_HEIGHT = 300;
    private static final int IMG_OFFSET_X = 180;
    private static final int IMG_OFFSET_Y = 50;

    // Calculations for centering the buttons and other assets    
    private static final int buttonWidth = 200;
    private static final int buttonHeight = 50;
    private static final int frameWidth = Board.TILE_SIZE * Board.Y_AXIS_SIZE;    
    private static final int frameCenter = (frameWidth - buttonWidth) / 2;

    // Audio 
    private Clip bgm;

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
                JPanel inputPanel = new JPanel();
                // Use GridLayout Layout Manager
                inputPanel.setLayout(new GridLayout(2, 2, 10, 10));

                JTextField nameInput = new JTextField();
                JTextField ageInput = new JTextField();

                inputPanel.add(new JLabel("Enter Name: "));
                inputPanel.add(nameInput);                
                inputPanel.add(new JLabel("Enter age: "));
                inputPanel.add(ageInput);

                // If we still want separate dialog inputs
                // String playerName = JOptionPane.showInputDialog(startMenu.this, "Enter your name: ");
                // int playerAge = Integer.parseInt(JOptionPane.showInputDialog(startMenu.this, "Enter your age: "));
               
                int choice = JOptionPane.showConfirmDialog(startMenu.this, inputPanel, 
                                                    "User Information", JOptionPane.OK_CANCEL_OPTION, 
                                                    JOptionPane.PLAIN_MESSAGE);
                
                // If user clicks CANCEL, then do nothing
                if (choice != JOptionPane.OK_OPTION) {
                    return;
                }

                // Extract the name and age
                String playerName = nameInput.getText();
                String age = ageInput.getText();

                // Name validation - field musn't be empty
                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(startMenu.this, "Player name must not be empty", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int playerAge;

                // Age validation - must be valid number
                try {
                    playerAge = Integer.parseInt(age);  // Turn to int                    
                } catch (NumberFormatException numex) {
                    JOptionPane.showMessageDialog(startMenu.this, "Age must be a valid number input", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return; // Don't start the simulation
                }

                // Age validation - must be reasonable (within range)
                if (playerAge <= 1 || playerAge > 99) {
                    JOptionPane.showMessageDialog(startMenu.this, "Age must be between 1 - 99", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Player player = simulation.getPlayer();

                player.setName(playerName);
                player.setAge(playerAge);

                // Switch to the actual simulation
                frame.getContentPane().removeAll();
                frame.getContentPane().add(simulation);
                frame.revalidate();     // update the layout of components
                frame.repaint();       
                playBGM("assets/tf_bgm.wav");   // Start playing the bgm
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

    private void playBGM(String location) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(location));
            bgm = AudioSystem.getClip();
            bgm.open (audioInput);
            bgm.loop(bgm.LOOP_CONTINUOUSLY);
            bgm.start();
        } catch (Exception e) {
            System.out.println("DEBUG: Error playing bgm:  " + e.getMessage());
        }
    }
}
