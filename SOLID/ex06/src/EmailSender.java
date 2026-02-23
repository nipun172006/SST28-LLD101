public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void send(Notification n) {
        validateDestination(n);

        // Formally documented truncation for this implementation
        String body = n.body;
        if (body != null && body.length() > 40)
            body = body.substring(0, 40);

        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}
