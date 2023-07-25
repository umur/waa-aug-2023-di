public class UserService {
    @MyAutowire
    private UserRepository userRepository;

    public void saveUser(String name){
        userRepository.save(name);
    }
}
