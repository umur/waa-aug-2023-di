package com.example.waaassignment1.Repositories;

import com.example.waaassignment1.Entities.User;

public class UserRepository {
    public void saveUser(User user) {
        System.out.println("User saved: " + user.getName());
    }
}
