public class Demo06 {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender<EmailMessage> email = new EmailSender(audit);
        NotificationSender<SmsMessage> sms = new SmsSender(audit);
        NotificationSender<WhatsAppMessage> wa = new WhatsAppSender(audit);

        // Convert the unified Notification object into strongly validated Messages before sending.
        // The truncation/validation rules now safely reside in the Message constructors!
        email.send(new EmailMessage(n.email, n.subject, n.body));
        
        sms.send(new SmsMessage(n.phone, n.body));
        
        try {
            WhatsAppMessage wam = new WhatsAppMessage(n.phone, n.body);
            wa.send(wam);
        } catch (RuntimeException ex) {
            System.out.println("WA ERROR: " + ex.getMessage());
            audit.add("WA failed");
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}
