import java.awt.*;          // Drawing graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class startMenu extends JPanel {
    
    public startMenu(JFrame frame, Board simulation) {

        // Layout manager - use no layout manager 
        setLayout(null);

        setBackground(new Color(160, 225, 78));        

        setPreferredSize(new Dimension(Board.TILE_SIZE * Board.Y_AXIS_SIZE,
                                       Board.TILE_SIZE * Board.X_AXIS_SIZE));

        // The JPanel for the Start button
        // NOTE TO SELF: CHANGE THE LOCATIONS OF THE BUTTONS
        JButton startButton = new JButton("Start Simulation");
        startButton.setBounds(250, 400, 200, 50); 
        startButton.addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                String playerName = JOptionPane.showInputDialog(startMenu.this, "Enter your name: ");
                int playerAge = Integer.parseInt(JOptionPane.showInputDialog(startMenu.this, "Enter your age: "));

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
        exitButton.setBounds(250, 500, 200, 50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);     // Terminates the Java Virtual Machine 
            }
        });

        add(startButton);
        add(exitButton);
    } 
}
