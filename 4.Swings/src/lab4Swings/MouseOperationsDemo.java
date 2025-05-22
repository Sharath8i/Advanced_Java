/*Develop a simple swing program for illustrating mouse operations such as mouse down, up
 double click , single click with help of a button */

package lab4Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseOperationsDemo extends JFrame {

    private JButton clickButton;
    private JLabel messageLabel;

    public MouseOperationsDemo() {
        // Frame setup
        setTitle("Mouse Operations Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Center panel with button
        JPanel centerPanel = new JPanel();
        clickButton = new JButton("Click Me!");
        clickButton.setFont(new Font("Arial", Font.BOLD, 16));
        centerPanel.add(clickButton);

        // Message label at bottom
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Add components to frame
        add(centerPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);

        // Mouse events
        clickButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                messageLabel.setText("Mouse Down on Button");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                messageLabel.setText("Mouse Up on Button");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    messageLabel.setText("Double Click on Button");
                } else {
                    messageLabel.setText("Single Click on Button");
                }
            }
        });

        // Center on screen and display
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseOperationsDemo::new);
    }
}
