package Main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage implements ActionListener {
    Connection con;

    JFrame loginFrame;
    JPanel headPanel;
    JPanel mainPanel;
    JPanel funPanel;
    static JButton birthday;
    static JButton wedding;
    static JButton welcome;
    static JButton nyp;
    static JButton corporate;
    static JButton setting;
    // JPanel birthPanel;
    // ImageIcon birthIcon;
    // ImageIcon wedIcon;
    // ImageIcon welIcon;
    // ImageIcon nypIcon;
    // ImageIcon corIcon;
    // JPanel wedPanel;
    // JPanel welPanel;
    // JPanel nypPanel;
    // JPanel corPanel;
    // JLabel birthday_label;
    // JLabel wedding_label;
    // JLabel welcome_label;
    // JLabel nyp_label;
    // JLabel corporate_label;

    User user;

    HomePage(JFrame of, User details) {
        user = details;
        loginFrame = of;
        headPanel = new JPanel(null);
        headPanel.setBounds(0, 0, 1366, 768);
        headPanel.setVisible(true);

        con = ConnectionClass.getConnection();
        JLabel mainLabel = new JLabel();
        mainLabel.setForeground(Color.WHITE);
        ImageIcon mainIcon = new ImageIcon("home.png");
        mainLabel.setIcon(mainIcon);
        mainLabel.setBounds(0, 0, 1116, 768);

        funPanel = new JPanel(null);
        funPanel.setBounds(0, 0, 250, 768);
        funPanel.setVisible(true);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(250, 0, 1116, 768);
        mainPanel.setVisible(true);

        // birthIcon = new ImageIcon("Birthday.png");
        // wedIcon = new ImageIcon("Wedding.png");
        // welIcon = new ImageIcon("Welcome.png");
        // nypIcon = new ImageIcon("nyp.png");
        // corIcon = new ImageIcon("Corporate1.1.png");

        // birthPanel = new JPanel();
        // birthPanel.setSize(new Dimension(300, 200));

        // wedPanel = new JPanel();
        // wedPanel.setSize(new Dimension(300, 200));
        // // wedPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
        // Color.WHITE));

        // welPanel = new JPanel();
        // welPanel.setSize(new Dimension(300, 200));
        // // welPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
        // Color.WHITE));

        // nypPanel = new JPanel();
        // nypPanel.setSize(new Dimension(300, 200));
        // // nypPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
        // Color.WHITE));

        // corPanel = new JPanel();
        // corPanel.setSize(new Dimension(300, 200));
        // // corPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
        // Color.WHITE));

        birthday = new JButton("BIRTHDAY PARTY");
        birthday.setBounds(25, 75, 200, 75);
        birthday.setForeground(Color.BLACK);
        birthday.setOpaque(false);
        birthday.setContentAreaFilled(false);
        birthday.setBorderPainted(false);
        birthday.setCursor(new Cursor(Cursor.HAND_CURSOR));
        birthday.setFont(new Font("Poppins", Font.BOLD, 18));
        birthday.addActionListener(this);
        // birthday.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        // birthday.add(birthPanel);
        // birthday.add(birthday_label);

        wedding = new JButton("WEDDING");
        wedding.setBounds(25, 165, 200, 75);
        wedding.setForeground(Color.BLACK);
        wedding.setOpaque(false);
        wedding.setContentAreaFilled(false);
        wedding.setBorderPainted(false);
        wedding.setCursor(new Cursor(Cursor.HAND_CURSOR));
        wedding.setFont(new Font("Poppins", Font.BOLD, 18));
        wedding.addActionListener(this);
        // wedding.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        // wedding.add(wedPanel);
        // wedding.add(wedding_label);

        welcome = new JButton("WELCOME");
        welcome.setBounds(25, 255, 200, 75);
        welcome.setForeground(Color.BLACK);
        welcome.setOpaque(false);
        welcome.setContentAreaFilled(false);
        welcome.setBorderPainted(false);
        welcome.setCursor(new Cursor(Cursor.HAND_CURSOR));
        welcome.setFont(new Font("Poppins", Font.BOLD, 18));
        welcome.addActionListener(this);
        // welcome.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        // welcome.add(welcome_label);
        // welcome.add(welPanel);

        nyp = new JButton("NEW YEAR PARTY");
        nyp.setBounds(25, 345, 200, 75);
        nyp.setForeground(Color.BLACK);
        nyp.setOpaque(false);
        nyp.setContentAreaFilled(false);
        nyp.setBorderPainted(false);
        nyp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nyp.setFont(new Font("Poppins", Font.BOLD, 18));
        nyp.addActionListener(this);
        // nyp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        // nyp.add(nyp_label);
        // nyp.add(nypPanel);

        corporate = new JButton("CORPORATE");
        corporate.setBounds(25, 435, 200, 75);
        corporate.setForeground(Color.BLACK);
        corporate.setOpaque(false);
        corporate.setContentAreaFilled(false);
        corporate.setBorderPainted(false);
        corporate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        corporate.setFont(new Font("Poppins", Font.BOLD, 18));
        corporate.addActionListener(this);
        // corporate.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
        // Color.WHITE));
        // corporate.add(corporate_label);

        ImageIcon settingIcon = new ImageIcon("setting.png");
        JLabel settingLabel = new JLabel(settingIcon);
        settingLabel.setBounds(0, 0, 250, 75);
        settingLabel.setText("Setting");
        settingLabel.setIconTextGap(15);
        settingLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        setting = new JButton();
        setting.setBounds(50, 675, 250, 75);
        setting.setForeground(Color.BLACK);
        setting.setOpaque(false);
        setting.setContentAreaFilled(false);
        setting.setBorderPainted(false);
        setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setting.add(settingLabel);
        setting.addActionListener(this);

        birthday.setFocusable(false);
        wedding.setFocusable(false);
        welcome.setFocusable(false);
        nyp.setFocusable(false);
        corporate.setFocusable(false);
        setting.setFocusable(false);

        funPanel.add(birthday);
        funPanel.add(wedding);
        funPanel.add(welcome);
        funPanel.add(nyp);
        funPanel.add(corporate);
        funPanel.add(setting);
        headPanel.add(funPanel);
        mainPanel.add(mainLabel);
        headPanel.add(mainPanel);
        loginFrame.add(headPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == birthday) {
            birthday.setOpaque(true);
            birthday.setContentAreaFilled(true);
            birthday.setBackground(Color.GRAY);
            wedding.setOpaque(false);
            wedding.setContentAreaFilled(false);
            welcome.setOpaque(false);
            welcome.setContentAreaFilled(false);
            nyp.setOpaque(false);
            nyp.setContentAreaFilled(false);
            corporate.setOpaque(false);
            corporate.setContentAreaFilled(false);

            mainPanel.setVisible(false);
            new FunctionalityPage(loginFrame, headPanel, birthday, user);
        } else if (e.getSource() == wedding) {
            wedding.setOpaque(true);
            wedding.setContentAreaFilled(true);
            wedding.setBackground(Color.GRAY);
            birthday.setOpaque(false);
            birthday.setContentAreaFilled(false);
            welcome.setOpaque(false);
            welcome.setContentAreaFilled(false);
            nyp.setOpaque(false);
            nyp.setContentAreaFilled(false);
            corporate.setOpaque(false);
            corporate.setContentAreaFilled(false);

            mainPanel.setVisible(false);
            new FunctionalityPage(loginFrame, headPanel, wedding, user);
        } else if (e.getSource() == welcome) {
            welcome.setOpaque(true);
            welcome.setContentAreaFilled(true);
            welcome.setBackground(Color.GRAY);
            birthday.setOpaque(false);
            birthday.setContentAreaFilled(false);
            wedding.setOpaque(false);
            wedding.setContentAreaFilled(false);
            nyp.setOpaque(false);
            nyp.setContentAreaFilled(false);
            corporate.setOpaque(false);
            corporate.setContentAreaFilled(false);

            mainPanel.setVisible(false);
            new FunctionalityPage(loginFrame, headPanel, welcome, user);
        } else if (e.getSource() == nyp) {
            nyp.setOpaque(true);
            nyp.setContentAreaFilled(true);
            nyp.setBackground(Color.GRAY);
            birthday.setOpaque(false);
            birthday.setContentAreaFilled(false);
            welcome.setOpaque(false);
            welcome.setContentAreaFilled(false);
            wedding.setOpaque(false);
            wedding.setContentAreaFilled(false);
            corporate.setOpaque(false);
            corporate.setContentAreaFilled(false);

            mainPanel.setVisible(false);
            new FunctionalityPage(loginFrame, headPanel, nyp, user);
        } else if (e.getSource() == corporate) {
            corporate.setOpaque(true);
            corporate.setContentAreaFilled(true);
            corporate.setBackground(Color.GRAY);
            birthday.setOpaque(false);
            birthday.setContentAreaFilled(false);
            welcome.setOpaque(false);
            welcome.setContentAreaFilled(false);
            nyp.setOpaque(false);
            nyp.setContentAreaFilled(false);
            wedding.setOpaque(false);
            wedding.setContentAreaFilled(false);

            mainPanel.setVisible(false);
            new FunctionalityPage(loginFrame, headPanel, corporate, user);
        } else if (e.getSource() == setting) {
            headPanel.setVisible(false);
            new Setting(loginFrame, user);
        }
    }

    static JButton getBirthdayButton() {
        return birthday;
    }

    static JButton getWeddingButton() {
        return wedding;
    }

    static JButton getWelcomeButton() {
        return welcome;
    }

    static JButton getNYPButton() {
        return nyp;
    }

    static JButton getCorporateButton() {
        return corporate;
    }

    static JButton getSettingButton() {
        return setting;
    }
}
