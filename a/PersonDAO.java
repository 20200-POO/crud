package a;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import a.Conn;
import a.Person;

public class PersonDAO {
    public List<Person> list() {
        List<Person> ls = new ArrayList<Person>();
        Connection conn = Conn.connectSQLite();
        try {
            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("select * from Person");
                while (rs.next()) {
                    Person p= new Person();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setCellular(rs.getString("cellular"));
                    ls.add(p);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ls;
    }

    public void save(Person p) {// Create and update
        Connection conn = Conn.connectSQLite();
        String query="";
        if (p.getId() > 0) {
            System.out.println("Update");
            try {
                if (conn != null) {
                    Statement statement = conn.createStatement();
                    query="update Person set "+
                        " name ='" + p.getName() + "',"+
                        " cellular ='" + p.getCellular() + "'"+
                        " where id= "+p.getId();
                    statement.executeUpdate(query);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Insert");
            try {
                if (conn != null) {
                    Statement statement = conn.createStatement();
                    statement.executeUpdate("insert into Person(name,cellular) values('" + p.getName() + "','"
                            + p.getCellular() + "')");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {// Create and update
        Connection conn = Conn.connectSQLite();
        try {
            if (conn != null) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("delete from Person where id=" + id + "");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}