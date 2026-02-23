/**
 * Base for sending notifications.
 * Contract: send(n) will attempt to deliver the notification.
 * Senders may have format-specific requirements (e.g. phone number format).
 */
public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    public abstract void send(Notification n);

    protected void validateDestination(Notification n) {
        // Base implementation allows any non-null notification
        if (n == null)
            throw new IllegalArgumentException("Notification cannot be null");
    }
}
