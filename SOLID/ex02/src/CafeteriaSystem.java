import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final PriceCalculator priceCalculator;
    private final InvoicePrinter printer;
    private int invoiceSeq = 1000;

    public CafeteriaSystem() {
        this.store = new FileStore();
        this.priceCalculator = new PriceCalculator();
        this.printer = new InvoicePrinter();
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = priceCalculator.calculateSubtotal(lines, menu);
        double taxPct = TaxRules.taxPercent(customerType);
        double tax = priceCalculator.calculateTax(subtotal, taxPct);
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        String printable = printer.format(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
