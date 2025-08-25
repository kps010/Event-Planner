package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class demo extends JFrame implements ActionListener {
    static JButton button;
    static JTextField name;
    static JTextField pass;
    static JRadioButton male;
    static JRadioButton female;

    demo() {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // String dbUrl = "jdbc:mysql://localhost:3306/eventplanner";
        // String dbUseer = "root";
        // String dbPass = "";

        // Connection con = DriverManager.getConnection(dbUrl, dbUseer, dbPass);
        // Statement st = con.createStatement();

        this.setTitle("LOGIN");
        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(null);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JLabel name_label = new JLabel();
        name_label.setHorizontalAlignment(SwingConstants.LEADING);
        name_label.setText("Enter Name : ");
        name_label.setBounds(20, 0, 100, 40);

        JLabel pass_label = new JLabel();
        pass_label.setHorizontalAlignment(SwingConstants.LEADING);
        pass_label.setText("Enter Password : ");
        pass_label.setBounds(20, 60, 100, 40);

        JLabel gender_label = new JLabel();
        gender_label.setText("Gender : ");

        name = new JTextField();
        name.setPreferredSize(new Dimension(250, 40));
        name.setFont(new Font("Consolas", Font.PLAIN, 20));
        name.setBounds(120, 0, 250, 40);

        pass = new JTextField();
        pass.setPreferredSize(new Dimension(250, 40));
        pass.setFont(new Font("Consolas", Font.PLAIN, 20));
        pass.setBounds(120, 60, 250, 40);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        p3.setBounds(20, 130, 200, 50);

        // JFrame frame = new JFrame("EventPlanner");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        button = new JButton("Submit");
        button.setBackground(Color.CYAN);
        button.setForeground(Color.DARK_GRAY);
        button.setBounds(150, 250, 100, 50);

        male.addActionListener(this);
        female.addActionListener(this);
        button.addActionListener(this);

        this.add(name_label);
        this.add(name);
        this.add(pass_label);
        this.add(pass);
        p3.add(gender_label);
        p3.add(male);
        p3.add(female);
        this.add(p3);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gender = "";
        if (e.getSource() == button) {
            System.out.println("Name : " + name.getText());
            System.out.println("Password : " + pass.getText());
            System.out.println("Gender : " + gender);
        } else if (e.getSource() == male) {
            // System.out.println("Gender : " + male.getText());
            gender = male.getText();
        } else if (e.getSource() == female) {
            gender = female.getText();
            // System.out.println("Gender : " + female.getText());
        }
    }

}

class run {
    public static void main(String[] args) {
        demo obj = new demo();
    }
}
