package LinkedList.doublylinkedlist.moviemanagementsystem;

public class Node {
    Movie movie;
    Node next;
    Node prev;

    public Node(Movie movie) {
        this.movie = movie;
        this.next = null;
        this.prev = null;
    }
}
