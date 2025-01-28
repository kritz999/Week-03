package LinkedList.doublylinkedlist.librarymanagementsystem;

public class LibraryMain {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Adding books
        library.addAtBeginning("Harry Potter", "J.K. Rowling", "Fantasy", 101, true);
        library.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 102, true);
        library.addAtPosition("1984", "George Orwell", "Dystopian", 103, true, 1);

        // Display books
        System.out.println("\nAll Books (Forward):");
        library.displayBooksForward();

        System.out.println("\nAll Books (Reverse):");
        library.displayBooksReverse();

        // Search for a book
        System.out.println("\nSearching for book by title '1984':");
        library.searchBook("1984");

        // Update availability
        System.out.println("\nUpdating availability of book ID 102:");
        library.updateAvailability(102, false);

        // Display books after update
        System.out.println("\nBooks after updating availability:");
        library.displayBooksForward();

        // Count total books
        System.out.println("\nTotal number of books in the library: " + library.countBooks());

        // Remove a book
        System.out.println("\nRemoving book with ID 103:");
        library.removeByBookId(103);

        // Display books after removal
        System.out.println("\nBooks after removal:");
        library.displayBooksForward();
    }
}
