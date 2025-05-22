/*. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing 
Programming in Blue color plain font with font size of  32  using Jframe and Jlabel */

package lab4Swings;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/** A simple Swing application */
public class SwingExample {

    public SwingExample() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create a new JFrame container
        JFrame jfrm = new JFrame("A Simple Swing Application");

        // Set initial size
        jfrm.setSize(600, 150);

        // Terminate program when the user closes the window
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text-based label
        JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming!", SwingConstants.CENTER);

        // Label properties
        jlab.setFont(new Font("Verdana", Font.PLAIN, 24));
        jlab.setForeground(new Color(0, 0, 255));

        // Add the label to the frame
        jfrm.add(jlab);

        // Center the window on screen
        jfrm.setLocationRelativeTo(null);

        // Display the frame
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the GUI on the Event-Dispatching Thread
        SwingUtilities.invokeLater(SwingExample::new);
    }
}
