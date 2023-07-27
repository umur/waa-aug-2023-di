package Assignment1;

public class UserService {
    @MyInject
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(String username) {
        userRepository.saveUser(username);
    }
}
