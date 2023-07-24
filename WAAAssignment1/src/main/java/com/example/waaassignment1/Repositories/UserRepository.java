package com.example.waaassignment1.Repositories;

import com.example.waaassignment1.Entities.User;

public class UserRepository {
    public void saveUser(User user) {
        // Implementation to save user to a database or some other storage
        System.out.println("User saved: " + user.getName());
    }
}
