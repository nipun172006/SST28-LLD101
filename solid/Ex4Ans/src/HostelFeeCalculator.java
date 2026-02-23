import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomPriceCalculator roomCalc;
    private final AddOnPriceCalculator addOnCalc;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomCalc = new StandardRoomPricing();
        this.addOnCalc = new StandardAddOnPricing();
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = roomCalc.getPrice(req.roomType);
        double add = 0.0;
        for (AddOn a : req.addOns) {
            add += addOnCalc.getPrice(a);
        }
        return new Money(base + add);
    }
}
