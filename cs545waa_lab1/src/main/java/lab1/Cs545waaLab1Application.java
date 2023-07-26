package lab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cs545waaLab1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Cs545waaLab1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create an instance of the "UserService" class.
        UserService userService = new UserService();

        // Create an instance of the "Container" class and register the "UserRepository" as a dependency.
        Container container = new Container();
        container.registerDependency(UserRepository.class);

        // Create an instance of the "MyDependencyInjector" class and call the "injectDependencies" method,
        // passing the "UserService" instance.
        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        // Verify that the "UserService" object has the "UserRepository" dependency properly injected.
        UserRepository userRepository = userService.getUserRepository();
        if (userRepository != null) {
            System.out.println("Dependency Injection successful for UserService!");
        } else {
            System.out.println("Dependency Injection failed for UserService!");
        }

        // Test the new class "NotificationService".
        NotificationService notificationService = new NotificationService();

        // Register the additional dependencies in the container.
        container.registerDependency(EmailService.class);
        container.registerDependency(SMSService.class);

        // Inject dependencies into the "NotificationService" instance.
        injector.injectDependencies(notificationService);

        // Verify that the dependencies are correctly injected into the "NotificationService".
        EmailService emailService = notificationService.getEmailService();
        SMSService smsService = notificationService.getSmsService();
        if (emailService != null && smsService != null) {
            System.out.println("Dependency Injection successful for NotificationService!");
        } else {
            System.out.println("Dependency Injection failed for NotificationService!");
        }
    }
}
