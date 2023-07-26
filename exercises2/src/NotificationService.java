public class NotificationService {
    @InjectDependency
    private EmailService emailService;

    public void sendNotification(String notification) {
        emailService.sendEmail("Notification: " + notification);
    }
}