package com.example.waaassignment1;

import com.example.waaassignment1.Reflection.Container;
import com.example.waaassignment1.Reflection.MyDependencyInjector;
import com.example.waaassignment1.Repositories.UserRepository;
import com.example.waaassignment1.Services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaaAssignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(WaaAssignment1Application.class, args);

        //Creating an instance of the Container
        Container container = new Container();

        // Registering UserRepository as a dependency in the Container
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        // Creating an instance of MyDependencyInjector and inject dependencies into UserService
        UserService userService = new UserService();
        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        // Verifying the injection by using the UserService
        userService.performAction();

    }

}
