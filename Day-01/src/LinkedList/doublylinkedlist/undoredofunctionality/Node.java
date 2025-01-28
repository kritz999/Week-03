package LinkedList.doublylinkedlist.undoredofunctionality;

public class Node {
    String textState; // Represents a state of the text
    Node prev;
    Node next;

    public Node(String textState) {
        this.textState = textState;
        this.prev = null;
        this.next = null;
    }
}
