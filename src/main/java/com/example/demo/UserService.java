package com.example.demo;

public class UserService {
    @MyInject
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

}
