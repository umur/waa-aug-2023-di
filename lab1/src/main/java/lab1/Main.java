package lab1;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        EmailService emailService = new EmailService();
        Container container = new Container();
        container.registerDependency(UserRepository.class, new UserRepository());
        container.registerDependency(Logger.class, new Logger());

        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);
        injector.injectDependencies(emailService);

        userService.greeting();
        emailService.emailData();
    }
}
