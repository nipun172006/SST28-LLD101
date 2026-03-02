import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        // Update creates new objects and does not mutate the original
        IncidentTicket assigned = service.assign(t, "agent@example.com");
        IncidentTicket escalated = service.escalateToCritical(assigned);
        
        System.out.println("\nOriginal ticket remains unchanged: " + t);
        System.out.println("\nFinal escalated ticket: " + escalated);

        // Demonstrate external mutation fails
        try {
            List<String> tags = escalated.getTags();
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nAttempted to hack tags, caught exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\nAfter external tag mutation attempt: " + escalated);
    }
}
