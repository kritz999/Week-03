package LinkedList.singlylinkedlist.studentrecordmanagement;

public class StudentMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Add students
        list.addAtBeginning(1, "Alice", 20, 'A');
        list.addAtEnd(2, "Bob", 22, 'B');
        list.addAtPosition(3, "Charlie", 21, 'A', 1);

        // Display all records
        System.out.println("All Student Records:");
        list.displayAllRecords();

        // Search for a student
        list.searchByRollNumber(2);

        // Update grade
        list.updateGrade(2, 'A');

        // Delete a student
        list.deleteByRollNumber(1);

        // Display all records after deletion
        System.out.println("\nAll Student Records after deletion:");
        list.displayAllRecords();
    }
}
