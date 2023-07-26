package org.example;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {


        Container container = new Container();
        container.registerDependency(UserRepository.class);

      //  System.out.println("register " + Container.classObjectMap.get(UserRepository.class));

        UserService userService = new UserService();
        MyDependencyInjector injector = new MyDependencyInjector();
        injector.injectDependencies(userService);

        userService.getUserRepository().printOut();

    }

}