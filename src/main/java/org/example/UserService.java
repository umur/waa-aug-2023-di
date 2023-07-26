package org.example;

public class UserService {
    @CustomInjector
    private UserRepository userRepository;


    public UserRepository getUserRepository() {
        return userRepository;
    }
}
