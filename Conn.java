/**
 * Conn
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static void main(String[] args) {
        System.out.println("Hola Java\n");
        try { 
			Connection conn = connect();
			if (conn != null) {
				System.out.println("Connected to the database");
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
        }
    }
    public static Connection connect() {
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