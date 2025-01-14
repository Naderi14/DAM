package ticket;

public class TicketMain {
    public static void main(String[] args) {
        float[][] factura = {
                        {1f, 1f, 3.80f},
                        {2f, 1f, 2.00f},
                        {3f, 1f, 2.20f},
                        {4f, 5f, 2.90f},
                        {5f, 10f, 3.20f},
                        {6f, 12f, 3.70f},
                        {7f, 5f, 3.10f},
                        {8f, 7f, 3.60f},
                        {9f, 12f, 2.70f}
                };

        Ticket ticket = new Ticket();
        System.out.println(ticket.generateTicket(factura));
    }
}