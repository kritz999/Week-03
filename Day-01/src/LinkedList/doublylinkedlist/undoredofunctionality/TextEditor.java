package LinkedList.doublylinkedlist.undoredofunctionality;

public class TextEditor {
    private Node head; // Head of the doubly linked list
    private Node current; // Pointer to the current state
    private int maxHistory; // Maximum size of history

    public TextEditor(int maxHistory) {
        this.head = null;
        this.current = null;
        this.maxHistory = maxHistory;
    }

    // Add a new text state
    public void addState(String text) {
        Node newNode = new Node(text);

        // If the list is empty
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            // Remove all redo states
            current.next = null;

            // Add the new state at the end
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        // Maintain the history size limit
        maintainHistorySize();
        System.out.println("State added: \"" + text + "\"");
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible. No previous state.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: Current state is \"" + current.textState + "\"");
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible. No next state.");
            return;
        }
        current = current.next;
        System.out.println("Redo: Current state is \"" + current.textState + "\"");
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current state: \"" + current.textState + "\"");
        }
    }

    // Maintain the history size to the max limit
    private void maintainHistorySize() {
        Node temp = current;
        int count = 0;

        // Traverse backward to count nodes
        while (temp != null) {
            count++;
            temp = temp.prev;
        }

        // If the count exceeds the max history size, remove the oldest state
        if (count > maxHistory) {
            head = head.next;
            head.prev = null;
            System.out.println("Oldest state removed to maintain history size.");
        }
    }
}
