public class UserService {
    @InjectDependency
    private UserRepository userRepository;

    public void testClass(String message) {
        userRepository.test(message);
    }
}
