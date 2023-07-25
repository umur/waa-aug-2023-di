package lab1;


public class UserService {
    @Inject
    private UserRepository userRepository;

    public void greeting(){
        System.out.println("hello there");
    }
}
