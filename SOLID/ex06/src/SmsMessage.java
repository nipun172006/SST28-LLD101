public class SmsMessage implements Message {
    public final String phone;
    public final String body;

    public SmsMessage(String phone, String body) {
        if (phone == null) throw new IllegalArgumentException("phone cannot be null");
        this.phone = phone;
        this.body = body;
    }
}
