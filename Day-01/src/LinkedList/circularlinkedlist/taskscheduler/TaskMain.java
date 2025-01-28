package LinkedList.circularlinkedlist.taskscheduler;

public class TaskMain {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();
        taskList.addAtBeginning(1, "Design UI", 2, "2025-02-01");
        taskList.addAtEnd(2, "Develop Backend", 1, "2025-03-01");
        taskList.addAtPosition(3, "Test Application", 3, "2025-04-01", 1);

        // Display all tasks
        System.out.println("\nAll Tasks:");
        taskList.displayTasks();

        // View the current task and move to the next task
        System.out.println("\nViewing tasks in a circular manner:");
        taskList.viewCurrentTaskAndMoveNext();
        taskList.viewCurrentTaskAndMoveNext();
        taskList.viewCurrentTaskAndMoveNext();
        taskList.viewCurrentTaskAndMoveNext();

        // Search for a task by Priority
        System.out.println("\nSearching for tasks with priority 1:");
        taskList.searchByPriority(1);

        // Remove a task by Task ID
        System.out.println("\nRemoving task with ID 2:");
        taskList.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        taskList.displayTasks();
    }
    }

