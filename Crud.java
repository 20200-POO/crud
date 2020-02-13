
/**
 * Crud
 */
import java.util.List;
import a.Person;
import a.PersonDAO;

public class Crud {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO();
        Person p = new Person();
        p.setId(7);
        p.setName("Miguel ANgel");
        p.setCellular("98552333");
        dao.save(p);
        // dao.delete(5);
        List<Person> list = dao.list();
        System.out.println("ID \tName");
        for(Person d:list){
            System.out.println(d.getId() + "\t"+d.getName()); 
        }
    }    
}