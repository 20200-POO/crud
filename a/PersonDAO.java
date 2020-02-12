package a;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import a.Conn;
import a.Person;

public class PersonDAO {
    public void save(Person p) {// Create and update
        Connection conn = Conn.connectSQLite();
        try {
            if (conn != null) {
                Statement statement = conn.createStatement();
                statement.executeUpdate(
                        "insert into Person(name,cellular) values('" + p.getName() + "','" + p.getCellular() + "')");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}