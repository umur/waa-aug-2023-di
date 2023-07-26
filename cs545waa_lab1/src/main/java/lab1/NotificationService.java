package lab1;

public class NotificationService {
    @Inject
    private EmailService emailService;

    @Inject
    private SMSService smsService;


    public EmailService getEmailService() {
        return emailService;
    }

    public SMSService getSmsService() {
        return smsService;
    }
}
