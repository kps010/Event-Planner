package DS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Main.ConnectionClass;

public class getEventLL {
    String query;
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    int r;
    static LL venue = new LL();

    public getEventLL() {
        con = ConnectionClass.getConnection();

        try {
            query = "select * from event";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                venue.insert(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            e.getStackTrace();
        }
    }

    public static LL getLL() {
        return venue;
    }
}
