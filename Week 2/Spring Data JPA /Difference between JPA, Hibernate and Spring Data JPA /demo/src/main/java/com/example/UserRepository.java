import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// No implementation code needed! Spring creates it automatically.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can even define custom queries by method name:
    User findByName(String name); 
}