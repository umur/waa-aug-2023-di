public class UserService {
    @CustomAnnotation
    private UserRepository userRepository;
    @CustomAnnotation
    private CustomerRepository customerRepository ;
    public void printIfRepositoriesAreInjected() {
        userRepository.printClassName();
        customerRepository.printClassName();
    }
}
