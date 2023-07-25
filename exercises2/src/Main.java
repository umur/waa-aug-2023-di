public class Main {
    public static void main(String[] args) {
        // Create the container
        Container container = new Container();

        // Register dependencies in the container
        EmailService emailService = new EmailService();
        container.registerDependency(EmailService.class, emailService);

        // Create the target objects where dependencies will be injected
        UserService userService = new UserService();
        NotificationService notificationService = new NotificationService();
        SMSService smsService = new SMSService();

        // Create the MyDependencyInjector instance and perform injection
        MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
        dependencyInjector.injectDependencies(userService,container);
        dependencyInjector.injectDependencies(notificationService,container);
        dependencyInjector.injectDependencies(smsService,container);

        // Now the dependencies should be injected into the userService, notificationService, and smsService objects
        userService.sendMessage("Hello, this is a test email!");
        notificationService.sendNotification("This is a notification");
        smsService.sendSMS("This is an SMS message");
    }
}
