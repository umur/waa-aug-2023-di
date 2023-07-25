package com.example.waaassignment1.Services;

import com.example.waaassignment1.Entities.User;
import com.example.waaassignment1.Reflection.Inject;
import com.example.waaassignment1.Repositories.UserRepository;

public class UserService {
    @Inject
    private UserRepository userRepository;

    public void performAction() {
        User user = new User("John Doe");
        userRepository.saveUser(user);
    }
}
