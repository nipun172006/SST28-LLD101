import java.util.List;

public class PriceCalculator {
    public double calculateSubtotal(List<OrderLine> lines, java.util.Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }

    public double calculateTax(double subtotal, double taxPct) {
        return subtotal * (taxPct / 100.0);
    }
}
