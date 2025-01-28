package LinkedList.doublylinkedlist.librarymanagementsystem;

public class Node {
    Book book;
    Node next;
    Node prev;

    public Node(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }
}
