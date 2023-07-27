public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        UserService userService = new UserService();

        MyDependencyInjector dependencyInjector = new MyDependencyInjector();
        dependencyInjector.setContainer(container);
        dependencyInjector.injectDependencies(userService);

        userService.doSomething();
    }
}