public class UserService {
    @InjectDependency
    private EmailService emailService;

    public void sendMessage(String message) {
        emailService.sendEmail(message);
    }
}
