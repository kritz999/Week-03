package LinkedList.doublylinkedlist.undoredofunctionality;

public class UndoRedoEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Maximum history size is 10

        // Simulate adding text states
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");

        // Display the current state
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();
        editor.undo();

        // Display the current state after undo
        editor.displayCurrentState();

        // Perform redo operation
        editor.redo();

        // Display the current state after redo
        editor.displayCurrentState();

        // Add more states to simulate history limit
        for (int i = 1; i <= 12; i++) {
            editor.addState("State " + i);
        }

        // Display the current state after adding many states
        editor.displayCurrentState();
    }
}
