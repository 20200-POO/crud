
/**
 * Crud
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import a.Conn;
import a.Person;
import a.PersonDAO;

public class Crud {
    public static void main(String[] args) {

        PersonDAO dao= new PersonDAO();
        Person p= new Person();
        p.setName("Miguel");
        p.setCellular("angel");
        dao.save(p);

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
        Connection conn = Conn.connectSQLite();
        try {
            if (conn != null) {
                System.out.println("Connected to the database");
                Statement statement = conn.createStatement();
                rs = statement.executeQuery("select * from Person");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            //Conn.closeSQLite(conn);
        }
        return rs;
    }

}