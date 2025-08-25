package Main;
// import java.awt.Color;

// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.Connection;
// import java.util.Date;

// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JComboBox;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// import com.toedter.calendar.JDateChooser;

// public class check extends JFrame {

//     Connection con;
//     static JFrame headFrame;
//     static JFrame loginFrame;
//     static JPanel headPanel;
//     static String buttonName;
//     static JLabel venueLabel;
//     static JComboBox venueBox;
//     static JLabel otherLabel;
//     static JTextField otherField;
//     static JDateChooser dc;
//     static JButton done;

//     public static void main(String[] args) {
//         // con = ConnectionClass.getConnection();
//         // loginFrame = of;
//         // buttonName = funButton.getText();

//         headFrame = new JFrame();

//         headPanel = new JPanel(null);
//         headPanel.setBounds(250, 0, 1116, 768);
//         headPanel.setVisible(true);

//         // JLabel mainLabel = new JLabel();
//         // mainLabel.setForeground(Color.WHITE);
//         // ImageIcon mainIcon = new ImageIcon("home.png");
//         // mainLabel.setIcon(mainIcon);
//         // mainLabel.setBounds(0, 0, 1116, 768);

//         // venueLabel = new JLabel("Select Venue");
//         // venueLabel.setBounds(300, 200, 100, 50);
//         // String[] venue = { "Select Venue", "Malhar Resorts, Gandhinagar", "Hyatt
//         // Regency, Ashram Road-Ahmedabad",
//         // "Dayavan Resort, Kathwada-Ahmedabad", "Radhe Upavan, Hathijan-Ahmedabad",
//         // "Taj Skyline, SBR-Shilaj",
//         // "The Hillock, Vaishnodevi Circle-Ahmedabad", "other" };
//         // venueBox = new JComboBox(venue);
//         // venueBox.setSelectedIndex(0);
//         // venueBox.setBounds(420, 200, 250, 50);
//         // venueBox.setBackground(Color.WHITE);
//         // venueBox.setOpaque(false);
//         // venueBox.setBorder(null);
//         // // venueBox.addActionListener(this);

//         // Date d = new Date();
//         // dc = new JDateChooser(d);
//         // dc.setBounds(420, 300, 250, 50);
//         // dc.getJCalendar().setPreferredSize(new Dimension(250, 200));
//         // dc.getJCalendar().setOpaque(false);

//         // done = new JButton("Check");
//         // done.setBounds(420, 400, 150, 50);
//         // ActionListener i = new ActionListener() {
//         // public void actionPerformed(ActionEvent e) {
//         // if (e.getSource() == done) {
//         // Date s = dc.getDate();
//         // java.sql.Date sqlD = new java.sql.Date(dc.getDate().getTime());
//         // System.out.println(sqlD);

//         // }
//         // }
//         // };
//         // done.addActionListener(i);

//         // // char[] i = dc.getDate().;
//         // // System.out.println(i.getYear() + "-" + i.getMonth() + "-" + i.getDay());
//         // // System.out.println(dc.getDate());

//         // headFrame.add(venueLabel);
//         // headFrame.add(venueBox);
//         // headFrame.add(dc);
//         // headFrame.add(done);
//         // headFrame.add(mainLabel);
//         int s = JOptionPane.showConfirmDialog(null, "args", "`", JOptionPane.YES_NO_OPTION);
//         System.out.println(s);

//         headFrame.setVisible(true);
//         headFrame.setLayout(null);
//         // headFrame.setPreferredSize(new Dimension(1116, 768));
//         headFrame.setSize(1116, 768);
//         // headFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//         headFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
// }

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class check {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        ImageIcon im = new ImageIcon("profile.png");
        JTextField tf = new JTextField();
        tf.setBackground(Color.BLACK);
        JLabel l = new JLabel(im);
        JButton btn = new JButton();
        btn.add(l);
        btn.setBounds(175, 150, 25, 25);
        l.setBounds(0, 0, 25, 25);
        tf.setBounds(150, 150, 100, 50);
        tf.add(btn);

        frame.add(tf);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}