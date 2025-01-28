package LinkedList.doublylinkedlist.librarymanagementsystem;

public class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;

    public Book(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}
