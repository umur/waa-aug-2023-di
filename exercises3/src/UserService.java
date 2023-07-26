public class UserService {
    @Service
    private UserRepository userRepository;

    public void testClass(String message) {
        userRepository.test(message);
    }
}
