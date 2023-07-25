public class Main {
    public static void main(String[] args) {
        // Create an instance of the UserService
        UserService userService = new UserService();

        // Create an instance of the Container and register UserRepository as a dependency
        Container container = new Container();
        container.registerDependency(UserRepository.class);

        // Create an instance of the MyDependencyInjector and call the injectDependencies method
        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        // Verify that the UserService object has the UserRepository dependency properly injected
        if (userService.getUserRepository() != null) {
            System.out.println("UserRepository dependency has been properly injected.");
        } else {
            System.out.println("UserRepository dependency has not been injected.");
        }
    }
}
