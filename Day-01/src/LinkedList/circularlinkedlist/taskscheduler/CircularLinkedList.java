package LinkedList.circularlinkedlist.taskscheduler;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private Node currentTask;

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(new Task(taskId, taskName, priority, dueDate));
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular link
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(new Task(taskId, taskName, priority, dueDate));
        if (tail == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular link
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Node newNode = new Node(new Task(taskId, taskName, priority, dueDate));
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        while (temp != null && currentIndex < position - 1) {
            temp = temp.next;
            currentIndex++;
            if (temp == head) break; // Stop if we loop back to the start
        }

        if (temp == null || temp == tail) {
            addAtEnd(taskId, taskName, priority, dueDate);
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.task.taskId == taskId) {
                if (temp == head) { // Removing the head
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) { // Removing the tail
                    tail = prev;
                    tail.next = head;
                } else { // Removing a middle node
                    prev.next = temp.next;
                }

                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTaskAndMoveNext() {
        if (currentTask == null) {
            currentTask = head;
        }
        if (currentTask != null) {
            System.out.println("Current Task: ID: " + currentTask.task.taskId +
                    ", Name: " + currentTask.task.taskName +
                    ", Priority: " + currentTask.task.priority +
                    ", Due Date: " + currentTask.task.dueDate);
            currentTask = currentTask.next; // Move to the next task
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks in the list
    public void displayTasks() {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        Node temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("ID: " + temp.task.taskId +
                    ", Name: " + temp.task.taskName +
                    ", Priority: " + temp.task.priority +
                    ", Due Date: " + temp.task.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.task.priority == priority) {
                System.out.println("Found Task: ID: " + temp.task.taskId +
                        ", Name: " + temp.task.taskName +
                        ", Priority: " + temp.task.priority +
                        ", Due Date: " + temp.task.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }













}
