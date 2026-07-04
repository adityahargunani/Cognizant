import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional // Automatically handles begin, commit, and rollback
    public void createUser() {
        User user = new User("Spring User");
        
        // No EntityManager or Session visible
        userRepository.save(user); 
    }
}