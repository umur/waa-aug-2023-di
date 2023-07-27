class UserService {

    @Inject
    private UserRepository userRepository;

    public void doSomething() {
        userRepository.saveUser("John");
    }
}