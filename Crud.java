
/**
 * Crud
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import a.Conn;

public class Crud {
    public static void main(String[] args) {
        ResultSet rs = list();
        try {
            System.out.println("ID \tName");
            while (rs.next()) {
                System.out.println("" + rs.getInt("id") + " \t " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ResultSet list() {
        ResultSet rs = null;
        try {
            Connection conn = Conn.connectSQLite();
            if (conn != null) {
                System.out.println("Connected to the database");
                Statement statement = conn.createStatement();
                rs = statement.executeQuery("select * from Person");
                //conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

}