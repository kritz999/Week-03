package LinkedList.circularlinkedlist.ticketreservationsystem;

public class TicketReservationSystem {
    private Ticket head; // The head of the circular linked list
    private Ticket tail; // The tail of the circular linked list
    private int totalTickets; // Counter to track the total number of tickets

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) { // If the list is empty
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket; // Update the tail
        }
        totalTickets++;
        System.out.println("Ticket added: " + customerName + " booked " + movieName + " at " + bookingTime);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        // Loop through the circular list
        do {
            if (current.ticketId == ticketId) {
                // If it's the only ticket in the list
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) { // Removing the head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing the tail
                    tail = previous;
                    tail.next = head;
                } else { // Removing a middle node
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketId + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("Current Ticket Reservations:");
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        boolean found = false;
        Ticket current = head;

        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket -> Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public void displayTotalTickets() {
        System.out.println("Total tickets booked: " + totalTickets);
    }
}