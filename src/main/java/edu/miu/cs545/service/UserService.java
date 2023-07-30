package edu.miu.cs545.service;

import edu.miu.cs545.entities.MyInjector;
import edu.miu.cs545.repository.UserRepository;

public class UserService {

    @MyInjector
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
