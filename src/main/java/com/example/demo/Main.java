package com.example.demo;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OtherService otherService = new OtherService();
        Container container = new Container();

        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        OtherRepository otherRepository = new OtherRepository();
        container.registerDependency(OtherRepository.class, otherRepository);

        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);
        injector.injectDependencies(otherService);

        System.out.println(userService.getUserRepository());
        System.out.println(otherService.getOtherRepository());
    }
}

