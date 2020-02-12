/**
 * Crud
 */
import java.sql.Connection;
import java.sql.SQLException;
import a.Conn;

public class Crud {

    public static void main(String[] args) {
        System.out.println("Hola Java\n");
        try { 
			Connection conn = Conn.connectSQLite();
			if (conn != null) {
				System.out.println("Connected to the database");
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
        }
    }
    
}