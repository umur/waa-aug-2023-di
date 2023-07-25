public class Main {
    public static void main(String[] args) {

        Container container = new Container();
        UserService userService = new UserService();
        MyDependencyInjector injector = new MyDependencyInjector();

        injector.setContainer(container);
        injector.addDependency(UserRepository.class);

        injector.injectDependencies(userService);

        userService.saveUser("Firaol");



    }
}