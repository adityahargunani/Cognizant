import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaExample {
    public static void main(String[] args) {
        // 1. Create Factory and Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-jpa-unit");
        EntityManager em = emf.createEntityManager();

        // 2. Transaction Management (Manual)
        em.getTransaction().begin();
        
        User user = new User("John Doe");
        em.persist(user); // Standard JPA method
        
        em.getTransaction().commit();

        // 3. Cleanup
        em.close();
        emf.close();
    }
}