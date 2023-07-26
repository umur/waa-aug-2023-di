package lab1;

public class UserService {
    @Inject
    private UserRepository userRepository;

//    public void doSomething() {
//        userRepository.doSomething();
//    }
public UserRepository getUserRepository() {
    return userRepository;
}
}
