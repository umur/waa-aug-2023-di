package org.example;

public class UserService {
    @InjectDependency
    private UserRepository userRepository;

    public void performAction() {
        if (userRepository != null) {
            userRepository.saveUser();
        } else {
            System.out.println("Injection Failed");
        }
    }
}
