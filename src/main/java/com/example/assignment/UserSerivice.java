package com.example.assignment;

import com.example.assignment.Myframework.TsiDai;

public class UserSerivice {
    @TsiDai
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
