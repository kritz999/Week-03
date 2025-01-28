package LinkedList.doublylinkedlist.librarymanagementsystem;

public class LibraryManagement {
    private Node head;
    private Node tail;

    // Add a new book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(new Book(bookTitle, author, genre, bookId, isAvailable));
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a new book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(new Book(bookTitle, author, genre, bookId, isAvailable));
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a new book at a specific position
    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position == 0) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }
        Node newNode = new Node(new Book(bookTitle, author, genre, bookId, isAvailable));
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < position - 1) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds, adding at the end.");
            addAtEnd(bookTitle, author, genre, bookId, isAvailable);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }
            temp.next = newNode;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Node temp = head;
        while (temp != null && temp.book.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    // Search for a book by Book Title or Author
    public void searchBook(String searchKey) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.book.bookTitle.equalsIgnoreCase(searchKey) || temp.book.author.equalsIgnoreCase(searchKey)) {
                System.out.println("Book Found: Title: " + temp.book.bookTitle + " | Author: " + temp.book.author +
                        " | Genre: " + temp.book.genre + " | ID: " + temp.book.bookId +
                        " | Available: " + temp.book.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found with key: " + searchKey);
        }
    }

    // Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Node temp = head;
        while (temp != null) {
            if (temp.book.bookId == bookId) {
                temp.book.isAvailable = isAvailable;
                System.out.println("Updated availability of Book ID " + bookId + " to " + isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Node temp = head;
        System.out.println("Books in Library (Forward Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.book.bookTitle + " | Author: " + temp.book.author +
                    " | Genre: " + temp.book.genre + " | ID: " + temp.book.bookId +
                    " | Available: " + temp.book.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Node temp = tail;
        System.out.println("Books in Library (Reverse Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.book.bookTitle + " | Author: " + temp.book.author +
                    " | Genre: " + temp.book.genre + " | ID: " + temp.book.bookId +
                    " | Available: " + temp.book.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
