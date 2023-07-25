// SMSService class
public class SMSService {
    @InjectDependency
    private EmailService emailService;

    public void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
        // Simulate SMS delivery failure
        boolean deliverySuccess = false;

        if (!deliverySuccess) {
            emailService.sendEmail("SMS delivery failed for message: " + message);
        }
    }
}
