public class Main {
    public static void main(String[] args) {
        Container container = new Container();

        UserRepository userRepository = new UserRepository();
        container.registerDependecy(userRepository.getClass(),userRepository);

        DependencyInjector dependencyInjector = new MyDependencyInjector(container);

        UserService userService = new UserService();

        dependencyInjector.injectDependencies(userService,container);

        userService.testClass("longltt");
    }
}