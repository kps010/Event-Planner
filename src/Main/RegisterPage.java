package Main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DS.UserLL;
import DS.getUserLL;

public class RegisterPage extends JFrame implements ActionListener {

    JFrame loginFrame;
    JPanel headPanel;
    JPanel logiPanel;
    JLabel name_label;
    JLabel pass_label;
    JLabel phno_label;
    JLabel email_label;
    JTextField name;
    JPasswordField pass;
    JTextField phno;
    JTextField email;
    JButton submit;
    JButton login;
    JButton show;
    JButton hide;
    Connection con;

    RegisterPage(JFrame of, JPanel op) {
        loginFrame = of;
        logiPanel = op;
        headPanel = new JPanel();
        headPanel.setBounds(0, 0, 1366, 768);
        headPanel.setLayout(null);
        headPanel.setVisible(true);

        con = ConnectionClass.getConnection();
        JLabel mainLabel = new JLabel();
        ImageIcon mainIcon = new ImageIcon("register.png");
        mainLabel.setIcon(mainIcon);
        mainLabel.setBounds(0, 0, 1376, 778);

        ImageIcon showIcon = new ImageIcon("show.png");
        JLabel showLabel = new JLabel();
        showLabel.setIcon(showIcon);
        showLabel.setBounds(300, 10, 32, 32);

        ImageIcon hideIcon = new ImageIcon("hide.png");
        JLabel hideLabel = new JLabel(hideIcon);
        hideLabel.setBounds(300, 10, 32, 32);

        show = new JButton(showIcon);
        show.setBorder(null);
        show.setBounds(318, 10, 32, 32);
        show.setOpaque(false);
        show.setContentAreaFilled(false);
        show.setBorderPainted(false);
        show.setCursor(new Cursor(Cursor.HAND_CURSOR));
        show.addActionListener(this);
        show.setVisible(true);

        hide = new JButton(hideIcon);
        hide.setBorder(null);
        hide.setBounds(318, 10, 32, 32);
        hide.setOpaque(false);
        hide.setContentAreaFilled(false);
        hide.setBorderPainted(false);
        hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hide.addActionListener(this);
        hide.setVisible(false);

        email_label = new JLabel();
        // email_label.setBounds(450, 400, 150, 50);
        // email_label.setBounds(450, 198, 150, 50);
        email = new JTextField();
        // email.setBounds(510, 408, 350, 50);
        email.setBounds(510, 198, 350, 50);
        email.setBorder(null);
        email.setBackground(new Color(0x344274));
        email.setForeground(Color.WHITE);
        email.setOpaque(false);
        email.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x161d33)));
        email.setText("Enter Email");
        email.selectAll();
        email_label.setFont(new Font("Poppins", Font.PLAIN, 18));
        email.setFont(new Font("Poppins", Font.PLAIN, 18));

        name_label = new JLabel();
        // name_label.setBounds(450, 190, 150, 50);
        // name_label.setBounds(450, 260, 150, 50);
        name = new JTextField();
        // name.setBounds(510, 198, 350, 50);
        name.setBounds(510, 268, 350, 50);
        name.setBorder(null);
        name.setBackground(new Color(0x344274));
        name.setForeground(Color.WHITE);
        name.setOpaque(false);
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x161d33)));
        name.setText("Enter Name");
        name.selectAll();
        name_label.setFont(new Font("Poppins", Font.PLAIN, 18));
        name.setFont(new Font("Poppins", Font.PLAIN, 18));

        phno_label = new JLabel();
        // phno_label.setBounds(450, 330, 150, 50);
        phno = new JTextField();
        phno.setBounds(510, 338, 350, 50);
        phno.setBorder(null);
        phno.setBackground(new Color(0x344274));
        phno.setForeground(Color.WHITE);
        phno.setOpaque(false);
        phno.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x161d33)));
        phno_label.setFont(new Font("Poppins", Font.PLAIN, 18));
        phno.setFont(new Font("Poppins", Font.PLAIN, 18));
        phno.setText("+91 ");
        phno.setEditable(true);

        pass_label = new JLabel();
        // pass_label.setBounds(450, 260, 150, 50);
        // pass_label.setBounds(450, 400, 150, 50);
        pass = new JPasswordField();
        // pass.setBounds(510, 268, 350, 50);
        pass.setBounds(510, 408, 350, 50);
        pass.setBorder(null);
        pass.setBackground(new Color(0x344274));
        pass.setForeground(Color.WHITE);
        pass.setOpaque(false);
        pass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x161d33)));
        pass.setText("Enter Password");
        pass.add(show);
        pass.add(hide);
        pass.setEchoChar('*');
        pass.selectAll();
        pass_label.setFont(new Font("Poppins", Font.PLAIN, 18));
        pass.setFont(new Font("Poppins", Font.PLAIN, 18));

        submit = new JButton("Register");
        submit.setBorder(null);
        submit.setBounds(700, 500, 100, 50);
        submit.setBackground(new Color(0x1a2342));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Poppins", Font.PLAIN, 18));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setFocusable(false);
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.addActionListener(this);

        login = new JButton("Login");
        login.setBorder(null);
        login.setBounds(560, 500, 100, 50);
        login.setBackground(new Color(0x1a2342));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Poppins", Font.PLAIN, 18));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setFocusable(false);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.addActionListener(this);

        headPanel.add(name_label);
        headPanel.add(name);
        headPanel.add(pass_label);
        headPanel.add(pass);
        headPanel.add(phno_label);
        headPanel.add(phno);
        headPanel.add(email_label);
        headPanel.add(email);
        headPanel.add(submit);
        headPanel.add(login);
        headPanel.add(mainLabel);
        loginFrame.add(headPanel);
        // this.setTitle("EventPlanner");
        // this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        // this.setLayout(null);
        // this.setVisible(true);
        // this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    Statement st;
    String query;
    PreparedStatement pst;
    ResultSet rs;
    int r;
    User user;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show) {
            hide.setVisible(true);
            show.setVisible(false);
            pass.setEchoChar((char) 0);
        } else if (e.getSource() == hide) {
            hide.setVisible(false);
            show.setVisible(true);
            pass.setEchoChar('*');
        } else if (e.getSource() == login) {
            // headPanel.setVisible(false);
            loginFrame.dispose();
            new LoginPage();
        } else if (e.getSource() == submit) {
            String user_email = email.getText();
            String user_pass = pass.getText();
            String user_phno = phno.getText();
            String user_name = name.getText();

            Random random = new Random();
            int hash = 1000 + random.nextInt(9000);

            String[] userArr = name.getText().split("\\s+");
            String user_id = userArr[0] + "_" + hash;
            try {
                getUserLL l = new getUserLL();
                UserLL userLl = l.getLL();
                if (userLl.checkOldUser(user_email)) {
                    JOptionPane.showMessageDialog(null, "EMAIL ALREADY EXIST", "Register",
                            JOptionPane.WARNING_MESSAGE);
                }
                // query = "select * from user where email=?";
                // pst = con.prepareStatement(query);
                // pst.setString(1, user_email);
                // rs = pst.executeQuery();
                // if (rs.next()) {
                // JOptionPane.showMessageDialog(null, "EMAIL ALREADY EXIST", "Register",
                // JOptionPane.WARNING_MESSAGE);
                // }
                else {
                    query = "insert into user values(?,?,?,?,?)";
                    pst = con.prepareStatement(query);
                    pst.setString(1, user_id);
                    pst.setString(2, user_name);
                    pst.setString(3, user_email);
                    pst.setString(4, user_phno);
                    pst.setString(5, user_pass);
                    r = pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULLY", "Register",
                            JOptionPane.PLAIN_MESSAGE);
                    headPanel.setVisible(false);
                    user = new User(user_name, user_email, user_phno, user_pass, user_id);
                    new HomePage(loginFrame, user);

                }

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
