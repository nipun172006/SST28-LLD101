/**
 * Base for sending notifications.
 * Contract: send(m) will attempt to deliver the notification message.
 * The message itself guarantees format validity to prevent runtime preconditions.
 */
public abstract class NotificationSender<T extends Message> {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    public abstract void send(T message);

    protected void validateMessage(T message) {
        if (message == null)
            throw new IllegalArgumentException("Message cannot be null");
    }
}
