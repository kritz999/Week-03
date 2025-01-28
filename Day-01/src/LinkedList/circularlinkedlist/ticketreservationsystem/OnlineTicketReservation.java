package LinkedList.circularlinkedlist.ticketreservationsystem;

public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some tickets
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "1:00 PM");
        system.addTicket(3, "Charlie", "Inception", "A2", "10:00 AM");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket by Customer Name
        system.searchTicket("Alice");

        // Search for a ticket by Movie Name
        system.searchTicket("Inception");

        // Display total tickets
        system.displayTotalTickets();

        // Remove a ticket by Ticket ID
        system.removeTicket(2);

        // Display tickets after removal
        system.displayTickets();

        // Display total tickets after removal
        system.displayTotalTickets();
    }
}
