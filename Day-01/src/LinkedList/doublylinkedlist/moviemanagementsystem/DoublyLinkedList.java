package LinkedList.doublylinkedlist.moviemanagementsystem;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Add a movie record at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(new Movie(title, director, yearOfRelease, rating));
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie record at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(new Movie(title, director, yearOfRelease, rating));
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie record at a specific position
    public void addAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        Node newNode = new Node(new Movie(title, director, yearOfRelease, rating));
        if (position == 0) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Node temp = head;
        int currentPosition = 0;
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
        } else {
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            newNode.prev = temp;
            temp.next = newNode;

            if (newNode.next == null) { // Update tail if added at the end
                tail = newNode;
            }
        }
    }

    // Remove a movie record by Movie Title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.movie.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // Update head if the first node is removed
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev; // Update tail if the last node is removed
                }

                System.out.println("Movie titled \"" + title + "\" removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie titled \"" + title + "\" not found.");
    }

    // Search for a movie by Director or Rating
    public void searchMovie(String keyword) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.movie.director.equalsIgnoreCase(keyword) || String.valueOf(temp.movie.rating).equals(keyword)) {
                System.out.println("Found Movie - Title: " + temp.movie.title + ", Director: " + temp.movie.director +
                        ", Year: " + temp.movie.yearOfRelease + ", Rating: " + temp.movie.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found for the given keyword: " + keyword);
        }
    }

    // Display all movie records in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }

        Node temp = head;
        System.out.println("Movies in forward order:");
        while (temp != null) {
            System.out.println("Title: " + temp.movie.title + ", Director: " + temp.movie.director +
                    ", Year: " + temp.movie.yearOfRelease + ", Rating: " + temp.movie.rating);
            temp = temp.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No records to display.");
            return;
        }

        Node temp = tail;
        System.out.println("Movies in reverse order:");
        while (temp != null) {
            System.out.println("Title: " + temp.movie.title + ", Director: " + temp.movie.director +
                    ", Year: " + temp.movie.yearOfRelease + ", Rating: " + temp.movie.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating based on the title
    public void updateRating(String title, double newRating) {
        Node temp = head;

        while (temp != null) {
            if (temp.movie.title.equalsIgnoreCase(title)) {
                temp.movie.rating = newRating;
                System.out.println("Rating updated for movie \"" + title + "\" to " + newRating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie titled \"" + title + "\" not found.");
    }
}
