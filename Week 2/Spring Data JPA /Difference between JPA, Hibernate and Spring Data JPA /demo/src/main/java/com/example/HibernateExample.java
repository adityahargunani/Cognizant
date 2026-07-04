import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // 1. Create SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        // 2. Open Session
        Session session = factory.openSession();
        
        try {
            session.beginTransaction();
            
            User user = new User("Jane Doe");
            session.save(user); // Hibernate-specific method (save)
            
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}