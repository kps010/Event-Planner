package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Setting extends JFrame implements ActionListener {

    JFrame loginFrame;
    JPanel headPanel;
    JPanel mainPanel;
    JPanel funPanel;
    JPanel profilePanel;
    JPanel historyPanel;
    JPanel aboutUsPanel;
    JButton profile;
    JButton history;
    JButton aboutUs;
    JButton edit;
    JButton save;
    JButton cancle;
    JButton show;
    JButton hide;
    JButton logout;
    JButton back;
    JTextField email;
    JTextField name;
    JPasswordField pass;
    JTextField phno;
    JLabel emailLabel;
    JLabel nameLabel;
    JLabel passLabel;
    JLabel phnoLabel;
    JScrollPane his;
    User user;
    Connection con;
    GridBagConstraints gbc;

    Setting(JFrame of, User details) {
        loginFrame = of;
        user = details;
        con = ConnectionClass.getConnection();

        headPanel = new JPanel(null);
        headPanel.setBounds(0, 0, 1366, 768);
        headPanel.setVisible(true);

        ImageIcon mainIcon = new ImageIcon("home.png");
        JLabel mainLabel = new JLabel(mainIcon);
        // mainLabel.setIcon(mainIcon);
        mainLabel.setBounds(0, 0, 1116, 768);

        JLabel profileLabel = new JLabel(mainIcon);
        // mainLabel.setIcon(mainIcon);
        profileLabel.setBounds(0, 0, 1116, 768);

        JLabel historyLabel = new JLabel(mainIcon);
        JLabel aboutUsLabel = new JLabel(mainIcon);
        aboutUsLabel.setBounds(0, 0, 1116, 768);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(250, 0, 1116, 768);
        mainPanel.setVisible(true);

        funPanel = new JPanel(null);
        funPanel.setBounds(0, 0, 250, 768);
        funPanel.setVisible(true);
        // funPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        profilePanel = new JPanel(null);
        profilePanel.setBounds(250, 0, 1116, 768);
        profilePanel.setVisible(false);

        historyPanel = new JPanel(null);
        historyPanel.setLayout(new GridBagLayout());
        historyPanel.setBounds(250, 0, 1116, 768);
        gbc = new GridBagConstraints();
        historyPanel.setVisible(true);

        aboutUsPanel = new JPanel(null);
        aboutUsPanel.setBounds(250, 0, 1116, 768);
        aboutUsPanel.setVisible(false);

        profile = new JButton("Profile");
        profile.setBounds(25, 75, 200, 75);
        profile.setForeground(Color.BLACK);
        profile.setOpaque(false);
        profile.setContentAreaFilled(false);
        profile.setBorderPainted(false);
        profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profile.setFont(new Font("Poppins", Font.BOLD, 18));
        profile.addActionListener(this);
        profile.setFocusable(false);

        history = new JButton("History");
        history.setBounds(25, 165, 200, 75);
        history.setForeground(Color.BLACK);
        history.setOpaque(false);
        history.setContentAreaFilled(false);
        history.setBorderPainted(false);
        history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        history.setFont(new Font("Poppins", Font.BOLD, 18));
        history.addActionListener(this);
        history.setFocusable(false);

        aboutUs = new JButton("About Us");
        aboutUs.setBounds(25, 255, 200, 75);
        aboutUs.setForeground(Color.BLACK);
        aboutUs.setOpaque(false);
        aboutUs.setContentAreaFilled(false);
        aboutUs.setBorderPainted(false);
        aboutUs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aboutUs.setFont(new Font("Poppins", Font.BOLD, 18));
        aboutUs.addActionListener(this);
        aboutUs.setFocusable(false);

        back = new JButton("Back");
        back.setBounds(25, 345, 200, 75);
        back.setForeground(Color.BLACK);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setFont(new Font("Poppins", Font.BOLD, 18));
        back.addActionListener(this);
        back.setFocusable(false);

        ImageIcon logoutIcon = new ImageIcon("logout.png");
        JLabel logoutLabel = new JLabel(logoutIcon);
        logoutLabel.setBounds(0, 0, 250, 75);
        logoutLabel.setText("Logout");
        logoutLabel.setIconTextGap(15);
        logoutLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        logout = new JButton();
        logout.setBounds(50, 675, 250, 75);
        logout.setForeground(Color.BLACK);
        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.add(logoutLabel);
        logout.addActionListener(this);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(340, 198, 100, 50);
        email = new JTextField();
        email.setBounds(460, 198, 350, 50);
        email.setBorder(null);
        email.setBackground(new Color(0x344274));
        email.setForeground(new Color(0xC6C6C6));
        email.setOpaque(false);
        email.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        email.setEditable(false);
        email.setFont(new Font("Poppins", Font.PLAIN, 18));
        emailLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        email.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        emailLabel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        emailLabel.setForeground(new Color(0xC6C6C6));

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(340, 268, 100, 50);
        name = new JTextField();
        name.setBounds(460, 268, 350, 50);
        name.setBorder(null);
        name.setBackground(new Color(0x344274));
        name.setForeground(new Color(0xC6C6C6));
        name.setOpaque(false);
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        name.setEditable(false);
        name.setFont(new Font("Poppins", Font.PLAIN, 18));
        nameLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        name.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        nameLabel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        nameLabel.setForeground(new Color(0xC6C6C6));

        phnoLabel = new JLabel("Phone No.");
        phnoLabel.setBounds(340, 338, 100, 50);
        phno = new JTextField();
        phno.setBounds(460, 338, 350, 50);
        phno.setBorder(null);
        phno.setBackground(new Color(0x344274));
        phno.setForeground(new Color(0xC6C6C6));
        phno.setOpaque(false);
        phno.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        phno.setEditable(false);
        phno.setFont(new Font("Poppins", Font.PLAIN, 18));
        phnoLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        phno.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        phnoLabel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        phnoLabel.setForeground(new Color(0xC6C6C6));

        ImageIcon showImage = new ImageIcon("show.png");
        JLabel showLabel = new JLabel(showImage);
        showLabel.setBounds(0, 0, 32, 32);
        show = new JButton();
        show.add(showLabel);
        show.setBounds(310, 10, 32, 32);
        show.setOpaque(false);
        show.setBorder(null);
        show.setContentAreaFilled(false);
        show.setVisible(true);
        show.setCursor(new Cursor(Cursor.HAND_CURSOR));
        show.addActionListener(this);

        ImageIcon hideImage = new ImageIcon("hide.png");
        JLabel hideLabel = new JLabel(hideImage);
        hideLabel.setBounds(0, 0, 32, 32);
        hide = new JButton();
        hide.add(hideLabel);
        hide.setBounds(310, 10, 32, 32);
        hide.setOpaque(false);
        hide.setBorder(null);
        hide.setContentAreaFilled(false);
        hide.setVisible(false);
        hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hide.addActionListener(this);

        passLabel = new JLabel("Password");
        passLabel.setBounds(340, 408, 100, 50);
        pass = new JPasswordField();
        pass.setBounds(460, 408, 350, 50);
        pass.setBorder(null);
        pass.setBackground(new Color(0x344274));
        pass.setForeground(new Color(0xC6C6C6));
        pass.setOpaque(false);
        pass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        pass.setEditable(false);
        pass.setEchoChar('*');
        pass.setFont(new Font("Poppins", Font.PLAIN, 18));
        passLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        pass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passLabel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passLabel.setForeground(new Color(0xC6C6C6));
        pass.add(show);
        pass.add(hide);

        name.setText(user.getName());
        email.setText(user.getEmail());
        phno.setText(user.getPhno());
        pass.setText(user.getPass());

        edit = new JButton("Edit");
        edit.setBorder(null);
        edit.setBounds(550, 550, 100, 50);
        edit.setBackground(new Color(0x1a2342));
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("Poppins", Font.PLAIN, 18));
        edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        edit.setFocusable(false);
        edit.setOpaque(false);
        edit.setContentAreaFilled(false);
        edit.setBorderPainted(false);
        edit.addActionListener(this);
        edit.setFocusable(false);

        save = new JButton("Save");
        save.setBorder(null);
        save.setBounds(600, 550, 100, 50);
        save.setBackground(new Color(0x1a2342));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Poppins", Font.PLAIN, 18));
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.setFocusable(false);
        save.setOpaque(false);
        save.setContentAreaFilled(false);
        save.setBorderPainted(false);
        save.addActionListener(this);
        save.setFocusable(false);
        // save.setEnabled(false);
        save.setVisible(false);

        cancle = new JButton("Cancle");
        cancle.setBorder(null);
        cancle.setBounds(475, 550, 100, 50);
        cancle.setBackground(new Color(0x1a2342));
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Poppins", Font.PLAIN, 18));
        cancle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancle.setFocusable(false);
        cancle.setOpaque(false);
        cancle.setContentAreaFilled(false);
        cancle.setBorderPainted(false);
        cancle.addActionListener(this);
        cancle.setFocusable(false);
        cancle.setVisible(false);

        profilePanel.add(emailLabel);
        profilePanel.add(email);
        profilePanel.add(nameLabel);
        profilePanel.add(name);
        profilePanel.add(phnoLabel);
        profilePanel.add(phno);
        profilePanel.add(passLabel);
        profilePanel.add(pass);
        profilePanel.add(edit);
        profilePanel.add(cancle);
        profilePanel.add(save);
        profilePanel.add(profileLabel);

        ImageIcon emailIcon = new ImageIcon("mail.png");
        JLabel email_Label = new JLabel(emailIcon);
        email_Label.setText("K29EventPlanner@gmail.com");
        email_Label.setIconTextGap(15);
        email_Label.setBounds(400, 300, 300, 50);
        email_Label.setFont(new Font("Poppins", Font.PLAIN, 18));
        email_Label.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        email_Label.setForeground(Color.WHITE);

        Random r = new Random();
        long a = r.nextLong(90, 99);
        long b = r.nextLong(10000000, 99999999);
        String s = String.valueOf(a);
        String x = String.valueOf(b);
        String p = s + x;

        ImageIcon callIcon = new ImageIcon("call.png");
        JLabel call_Label = new JLabel(callIcon);
        call_Label.setText("+91 " + p);
        call_Label.setIconTextGap(15);
        call_Label.setBounds(400, 400, 300, 50);
        call_Label.setFont(new Font("Poppins", Font.PLAIN, 18));
        call_Label.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        call_Label.setForeground(Color.WHITE);

        aboutUsPanel.add(email_Label);
        aboutUsPanel.add(call_Label);
        aboutUsPanel.add(aboutUsLabel);

        his = new JScrollPane(historyPanel);
        his.setBounds(250, 0, 1116, 768);
        his.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        his.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        funPanel.add(profile);
        funPanel.add(history);
        funPanel.add(aboutUs);
        funPanel.add(back);
        funPanel.add(logout);
        headPanel.add(funPanel);
        mainPanel.add(mainLabel);
        headPanel.add(mainPanel);
        headPanel.add(profilePanel);
        // headPanel.add(historyPanel);
        headPanel.add(his);
        headPanel.add(aboutUsPanel);
        loginFrame.add(headPanel);
    }

    Statement st;
    String query;
    PreparedStatement pst;
    CallableStatement cst;
    ResultSet rs;
    int r;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profile) {
            profilePanel.setVisible(true);
            mainPanel.setVisible(false);
            his.setVisible(false);
            aboutUsPanel.setVisible(false);
        } else if (e.getSource() == history) {
            mainPanel.setVisible(false);
            profilePanel.setVisible(false);
            his.setVisible(true);
            historyPanel.removeAll();
            aboutUsPanel.setVisible(false);

            JPanel head = new JPanel();
            JLabel title = new JLabel("HISTORY");
            title.setFont(new Font("Georgia", Font.BOLD, 50));
            head.add(title);
            gbc.gridy = 0;
            historyPanel.add(head);
            // historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.PAGE_AXIS));
            try {
                query = "select count(*) from event_history where client_id=?";
                pst = con.prepareStatement(query);
                pst.setString(1, user.getUser_id());
                rs = pst.executeQuery();
                rs.next();
                if (rs.getInt(1) > 0) {
                    query = "select * from event_history where client_id=? order by event_date desc";
                    pst = con.prepareStatement(query);
                    pst.setString(1, user.getUser_id());
                    rs = pst.executeQuery();
                    Date date = new Date();
                    while (rs.next()) {
                        String venue_id = rs.getString("venue_id");
                        String event_id = rs.getString("event_id");
                        Date d = rs.getDate("event_date");

                        query = "{call getEventName(?,?)}";
                        cst = con.prepareCall(query);
                        cst.setString(1, event_id);
                        cst.execute();
                        String event_name = cst.getString(2);

                        query = "{call getVenueName(?,?)}";
                        cst = con.prepareCall(query);
                        cst.setString(1, venue_id);
                        cst.execute();
                        String venue_name = cst.getString(2);

                        JPanel hisPanel = new JPanel();
                        hisPanel.setLayout(new BoxLayout(hisPanel, BoxLayout.PAGE_AXIS));
                        hisPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,
                                (int) hisPanel.getMinimumSize().getHeight()));
                        hisPanel.setPreferredSize(new Dimension(historyPanel.getWidth() - 200, 200));
                        // hisPanel.setBackground(Color.RED);
                        hisPanel.setVisible(true);

                        // JPanel top = new JPanel();
                        // top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));

                        JPanel event_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        JLabel event_Label = new JLabel(event_name);
                        event_Label.setFont(new Font("Poppins", Font.PLAIN, 24));
                        // event_Label.setAlignmentX(Component.LEFT_ALIGNMENT);
                        event_panel.add(event_Label);

                        JPanel venue_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        JLabel venue_Label = new JLabel(venue_name);
                        venue_Label.setFont(new Font("Poppins", Font.PLAIN, 18));
                        // venue_Label.setAlignmentX(Component.LEFT_ALIGNMENT);
                        venue_panel.add(venue_Label);

                        JPanel date_Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        JLabel date_Label = new JLabel(d.toString());
                        date_Label.setFont(new Font("Poppins", Font.PLAIN, 18));
                        // date_Label.setAlignmentX(Component.LEFT_ALIGNMENT);
                        date_Panel.add(date_Label);

                        JPanel compPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        Date d1 = d;
                        JLabel compLabel = new JLabel();
                        compLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
                        // compLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
                        compPanel.add(compLabel);

                        if (d1.compareTo(date) < 0) {
                            compLabel.removeAll();
                            compLabel.setText("completed");
                        } else if (d1.compareTo(date) > 0) {
                            compLabel.removeAll();
                            compLabel.setText("coming");
                        } else {
                            compLabel.removeAll();
                            compLabel.setText("It's Event day");
                        }
                        // top.add(event_panel);
                        // top.add(compPanel);
                        hisPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                        hisPanel.add(event_panel);
                        hisPanel.add(venue_panel);
                        hisPanel.add(date_Panel);
                        hisPanel.add(compPanel);
                        hisPanel.setBorder(new CompoundBorder(hisPanel.getBorder(), new EmptyBorder(10, 0, 10, 0)));
                        gbc.gridy++;
                        gbc.fill = 1;
                        historyPanel.add(hisPanel, gbc);
                    }
                    historyPanel.revalidate();
                    historyPanel.repaint();
                } else {
                    JPanel notFound = new JPanel();
                    notFound.setLayout(new FlowLayout(FlowLayout.CENTER));
                    JLabel noEvent = new JLabel("Not booked any events yet");
                    noEvent.setFont(new Font("Poppins", Font.PLAIN, 24));
                    notFound.add(noEvent);
                    gbc.gridy += 10;
                    gbc.fill = 1;
                    historyPanel.add(notFound, gbc);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        } else if (e.getSource() == aboutUs) {
            mainPanel.setVisible(false);
            profilePanel.setVisible(false);
            his.setVisible(false);
            aboutUsPanel.setVisible(true);
        } else if (e.getSource() == back) {
            headPanel.setVisible(false);
            new HomePage(loginFrame, user);
        } else if (e.getSource() == logout) {
            new LoginPage();
            loginFrame.dispose();
        } else if (e.getSource() == show) {
            hide.setVisible(true);
            show.setVisible(false);
            pass.setEchoChar((char) 0);
        } else if (e.getSource() == hide) {
            show.setVisible(true);
            hide.setVisible(false);
            pass.setEchoChar('*');
        } else if (e.getSource() == edit) {
            edit.setVisible(false);
            email.setEditable(true);
            name.setEditable(true);
            phno.setEditable(true);
            pass.setEditable(true);
            cancle.setVisible(true);
            save.setVisible(true);
        } else if (e.getSource() == save) {
            String user_name = name.getText();
            String user_email = email.getText();
            String user_phno = phno.getText();
            String user_pass = pass.getText();

            int c = JOptionPane.showConfirmDialog(null, "Do you want to save changes ?", "Save",
                    JOptionPane.YES_NO_OPTION);
            if (c == 0) {
                try {
                    query = "update user set username=?,email=?,password=?,phone_no=? where email=?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, user_name);
                    pst.setString(2, user_email);
                    pst.setString(3, user_pass);
                    pst.setString(4, user_phno);
                    pst.setString(5, user.getEmail());
                    r = pst.executeUpdate();
                    if (r > 0) {
                        JOptionPane.showMessageDialog(null, "Changes Saved", "Save",
                                JOptionPane.PLAIN_MESSAGE);
                        edit.setVisible(true);
                        email.setEditable(false);
                        name.setEditable(false);
                        phno.setEditable(false);
                        pass.setEditable(false);
                        cancle.setVisible(false);
                        save.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Changes doesn't Saved", "Save",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == cancle) {
            edit.setVisible(true);
            email.setEditable(false);
            name.setEditable(false);
            phno.setEditable(false);
            pass.setEditable(false);
            cancle.setVisible(false);
            save.setVisible(false);

            email.setText(user.getEmail());
            name.setText(user.getName());
            pass.setText(user.getPass());
            phno.setText(user.getPhno());
        }
    }
}
