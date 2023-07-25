public class UserService {
    @DependecyInject
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        userRepository.start();
        return userRepository;
    }
}
