/**
 * Conn
 */
package a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	public static Connection connectSQLite() {
		Connection conn=null;
		try { 
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:db2.db";
			conn = DriverManager.getConnection(dbURL);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
        return conn;
    }

}