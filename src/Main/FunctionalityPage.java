package Main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import DS.LL;
import DS.getEventLL;
import DS.getVenueLL;

public class FunctionalityPage extends JFrame implements ActionListener {

    Connection con;
    JFrame loginFrame;
    JPanel homePanel;
    JPanel headPanel;
    JPanel otherPanel;
    String event_type;
    JComboBox venueBox;
    JLabel venueLabel;
    JLabel otherLabel;
    JLabel dateLabel;
    JDateChooser dc;
    JTextField otherTF;
    JButton book;
    User user;
    String user_name;
    String user_email;
    String user_phno;
    String user_pass;
    static JButton birthday;
    static JButton wedding;
    static JButton welcome;
    static JButton nyp;
    static JButton corporate;
    static JButton setting;

    FunctionalityPage(JFrame of, JPanel op, JButton funButton, User details) {
        user = details;
        user_name = user.getName();
        user_email = user.getEmail();
        user_phno = user.getPhno();
        user_pass = user.getPass();
        con = ConnectionClass.getConnection();
        loginFrame = of;
        homePanel = op;
        event_type = funButton.getText();

        birthday = HomePage.getBirthdayButton();
        wedding = HomePage.getWeddingButton();
        welcome = HomePage.getWelcomeButton();
        nyp = HomePage.getNYPButton();
        corporate = HomePage.getCorporateButton();
        setting = HomePage.getSettingButton();

        birthday.addActionListener(this);
        wedding.addActionListener(this);
        welcome.addActionListener(this);
        nyp.addActionListener(this);
        corporate.addActionListener(this);
        setting.addActionListener(this);

        headPanel = new JPanel(null);
        headPanel.setBounds(250, 0, 1116, 768);
        headPanel.setVisible(true);

        JLabel mainLabel = new JLabel();
        ImageIcon mainIcon = new ImageIcon("home.png");
        mainLabel.setIcon(mainIcon);
        mainLabel.setBounds(0, 0, 1116, 768);

        otherPanel = new JPanel(null);
        otherPanel.setBounds(400, 270, 440, 50);
        otherPanel.setVisible(true);

        venueLabel = new JLabel("Select Venue");
        venueLabel.setForeground(Color.WHITE);
        venueLabel.setBounds(350, 175, 130, 50);
        venueLabel.setFont(new Font("Poppins", Font.PLAIN, 18));

        String[] venue = { "Select Venue", "Malhar Resorts, Gandhinagar", "Hyatt Regency, Ashram Road-Ahmedabad",
                "Dayavan Resort, Kathwada-Ahmedabad", "Radhe Upavan, Hathijan-Ahmedabad", "Taj Skyline, SBR-Shilaj",
                "The Hillock, Vaishnodevi Circle-Ahmedabad", "other" };
        venueBox = new JComboBox(venue);
        venueBox.setSelectedIndex(0);
        venueBox.setBounds(490, 175, 300, 50);
        venueBox.setFont(new Font("Poppins", Font.PLAIN, 18));
        venueBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        venueBox.addActionListener(this);

        otherLabel = new JLabel("Enter Venue");
        otherLabel.setForeground(Color.WHITE);
        otherLabel.setBounds(350, 275, 130, 50);
        otherLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
        otherLabel.setVisible(false);

        otherTF = new JTextField();
        otherTF.setBounds(490, 275, 300, 50);
        otherTF.setBackground(new Color(0x344274));
        otherTF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        otherTF.setOpaque(false);
        otherTF.setForeground(Color.WHITE);
        otherTF.setFont(new Font("Poppins", Font.PLAIN, 18));
        otherTF.setVisible(false);

        dateLabel = new JLabel("Choose Date");
        dateLabel.setBounds(350, 275, 130, 50);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Poppins", Font.PLAIN, 18));

        // Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 5);
        dc = new JDateChooser(c.getTime());
        dc.setBounds(490, 275, 300, 50);
        dc.getJCalendar().setPreferredSize(new Dimension(300, 200));
        dc.setMinSelectableDate(c.getTime());
        dc.setFont(new Font("Poppins", Font.PLAIN, 15));
        dc.getJCalendar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        dc.setCursor(new Cursor(Cursor.HAND_CURSOR));

        book = new JButton("Book Event");
        book.setBorder(null);
        book.setBounds(510, 425, 150, 50);
        book.setBackground(new Color(0x1a2342));
        book.setForeground(Color.WHITE);
        book.setFont(new Font("Poppins", Font.BOLD, 18));
        book.setCursor(new Cursor(Cursor.HAND_CURSOR));
        book.setFocusable(false);
        book.setOpaque(false);
        book.setContentAreaFilled(false);
        book.setBorderPainted(false);
        book.addActionListener(this);

        headPanel.add(venueLabel);
        headPanel.add(venueBox);
        headPanel.add(otherLabel);
        headPanel.add(otherTF);
        headPanel.add(dateLabel);
        headPanel.add(dc);
        headPanel.add(book);
        headPanel.add(mainLabel);
        homePanel.add(headPanel);
    }

    Statement st;
    String query;
    PreparedStatement pst;
    ResultSet rs;
    int r;

    @Override
    public void actionPerformed(ActionEvent e) {
        String loc;
        if (venueBox.getSelectedIndex() == 7) {
            otherLabel.setVisible(true);
            otherTF.setVisible(true);
            dateLabel.setBounds(350, 375, 130, 50);
            dc.setBounds(490, 375, 300, 50);
            book.setBounds(510, 525, 150, 50);
        } else {
            otherLabel.setVisible(false);
            otherTF.setVisible(false);
            dateLabel.setBounds(350, 275, 130, 50);
            dc.setBounds(490, 275, 300, 50);
            book.setBounds(510, 425, 150, 50);
        }
        if (e.getSource() == birthday) {
            headPanel.setVisible(false);
            new FunctionalityPage(loginFrame, homePanel, birthday, user);
        } else if (e.getSource() == wedding) {
            headPanel.setVisible(false);
            new FunctionalityPage(loginFrame, homePanel, wedding, user);
        } else if (e.getSource() == welcome) {
            headPanel.setVisible(false);
            new FunctionalityPage(loginFrame, homePanel, welcome, user);
        } else if (e.getSource() == nyp) {
            headPanel.setVisible(false);
            new FunctionalityPage(loginFrame, homePanel, nyp, user);
        } else if (e.getSource() == corporate) {
            headPanel.setVisible(false);
            new FunctionalityPage(loginFrame, homePanel, corporate, user);
        } else if (e.getSource() == setting) {
            homePanel.setVisible(false);
            new Setting(loginFrame, user);
        } else if (e.getSource() == book) {
            java.sql.Date date = new java.sql.Date(dc.getDate().getTime());
            if (venueBox.getSelectedIndex() == 7) {
                loc = otherTF.getText();
            } else {
                loc = venueBox.getSelectedItem().toString();
            }

            if (venueBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT VENUE", "Booking", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    getVenueLL l = new getVenueLL();
                    LL ll = l.getLL();
                    String venue_id = ll.getId(loc);

                    if (venue_id == null) {
                        String[] arr = loc.split("\\s+");
                        String id = "";
                        if (arr.length > 1) {
                            id = arr[0].charAt(0) + "" + arr[1].charAt(0);
                        } else {
                            id = arr[0].charAt(0) + "";
                        }
                        query = "insert into venue values(?,?)";
                        pst = con.prepareStatement(query);
                        pst.setString(1, id.toUpperCase());
                        pst.setString(2, loc);
                        r = pst.executeUpdate();
                        venue_id = id;
                    }

                    getEventLL l1 = new getEventLL();
                    LL ll1 = l1.getLL();
                    String event_id = ll.getId(event_type);
                    // System.out.println(event_id);

                    query = "select client_id from event_history where venue_id=? and event_date=?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, venue_id);
                    pst.setDate(2, date);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Sorry, We're Booked For " + loc + " At " + date, "Booking",
                                JOptionPane.PLAIN_MESSAGE);
                    } else {
                        int c = JOptionPane.showConfirmDialog(null,
                                "Do you want to confirm your booking for " + event_type + " at " + loc.toUpperCase()
                                        + " for " + date,
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (c == 0) {
                            query = "insert into event_history values(?,?,?,?)";
                            pst = con.prepareStatement(query);
                            pst.setString(1, user.getUser_id());
                            pst.setString(2, event_id);
                            pst.setString(3, venue_id);
                            pst.setDate(4, date);
                            r = pst.executeUpdate();
                            JOptionPane.showMessageDialog(null,
                                    "Event booked for " + event_type + " at " + loc.toUpperCase()
                                            + " for " + date
                                            + "\nWe'll contact you soon.",
                                    "Booking", JOptionPane.PLAIN_MESSAGE);
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
