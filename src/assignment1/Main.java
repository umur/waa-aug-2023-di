package assignment1;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.registerDependency(UserRepository.class);

        MyDependencyInjector depInjector = new MyDependencyInjector(container);
        UserService userService = new UserService();
        userService = (UserService) depInjector.injectDependencies(userService);
        System.out.println(userService.getUserRepository().myString);

    }
}
