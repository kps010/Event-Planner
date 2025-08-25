package Main;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class image {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("profile.png");
        JFrame frame = new JFrame();

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 250, 500);
        p1.setBackground(Color.BLUE);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setBounds(0, 0, 45, 50);
        // button.setVerticalAlignment(SwingConstants.WEST);
        button.setBackground(Color.WHITE);
        button.setBorder(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setTitle("Image");

        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setVisible(true);
        label.setBounds(0, 0, 200, 200);

        // frame.add(label);
        p1.add(button);
        frame.add(p1);
    }
}