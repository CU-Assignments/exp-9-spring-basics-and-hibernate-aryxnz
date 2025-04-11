// CRUDOperations.java
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class CRUDOperations {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Create
        Transaction tx = session.beginTransaction();
        Student s = new Student();
        s.setName("Aryan");
        s.setAge(22);
        session.save(s);
        tx.commit();

        session.close();
        factory.close();
    }
}
