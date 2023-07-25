package org.example;

public class Main {
    public static void main(String[] args) {

        Container container = new Container();
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        UserService userService = new UserService();


        MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
        dependencyInjector.injectDependencies(userService);


        userService.performAction();
    }
}