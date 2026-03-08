public class EmailMessage implements Message {
    public final String email;
    public final String subject;
    public final String body;

    public EmailMessage(String email, String subject, String body) {
        if (email == null) throw new IllegalArgumentException("email cannot be null");
        this.email = email;
        this.subject = subject;
        this.body = (body != null && body.length() > 40) ? body.substring(0, 40) : body;
    }
}
