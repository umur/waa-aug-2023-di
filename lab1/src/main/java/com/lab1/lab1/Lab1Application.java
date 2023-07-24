package com.lab1.lab1;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;




@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);

		UserService userService = new UserService();
		Container container = new Container();
		container.registerDependency(UserRepository.class);
		MyDependencyInjector injector = new MyDependencyInjector(container);
		injector.injectDependencies(userService);

		// Checking if userRepository was injected
		System.out.println(userService.getUserRepository() != null);
	}


}
