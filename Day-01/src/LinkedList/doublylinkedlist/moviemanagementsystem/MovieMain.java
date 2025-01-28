package LinkedList.doublylinkedlist.moviemanagementsystem;

public class MovieMain {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();

        // Add movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        movieList.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.1);
        movieList.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 1);

        // Display movies
        System.out.println("\nDisplaying movies in forward order:");
        movieList.displayForward();

        // Display movies in reverse order
        System.out.println("\nDisplaying movies in reverse order:");
        movieList.displayReverse();

        // Search for movies
        System.out.println("\nSearch for movies by Director 'Christopher Nolan':");
        movieList.searchMovie("Christopher Nolan");

        // Update rating
        System.out.println("\nUpdating rating for 'Inception':");
        movieList.updateRating("Inception", 9.5);

        // Remove a movie
        System.out.println("\nRemoving 'Interstellar':");
        movieList.removeByTitle("Interstellar");

        // Display movies after updates
        System.out.println("\nDisplaying movies after updates:");
        movieList.displayForward();
    }
    }

