package LinkedList.circularlinkedlist.roundrobinscheduling;

public class RoundRobinScheduler {
    private Node head;
    private Node tail;

    // Add a new process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Node newNode = new Node(new Process(processId, burstTime, priority));
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular linkage
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Circular linkage
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Node current = head;
        Node prev = null;

        // Searching for the process to remove
        do {
            if (current.process.processId == processId) {
                if (current == head && current == tail) { // Single process in the list
                    head = tail = null;
                } else {
                    if (current == head) { // Removing the head
                        head = head.next;
                        tail.next = head;
                    } else if (current == tail) { // Removing the tail
                        prev.next = head;
                        tail = prev;
                    } else { // Removing a middle node
                        prev.next = current.next;
                    }
                }
                System.out.println("Process with ID " + processId + " has been removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate Round-Robin Scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Node current = head;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        System.out.println("Starting Round-Robin Scheduling...");
        while (head != null) {
            System.out.println("\nCurrent Process Queue:");
            displayProcesses();

            if (current.process.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, current.process.burstTime);
                current.process.burstTime -= executionTime;

                System.out.println("Executing Process ID: " + current.process.processId +
                        " | Time Executed: " + executionTime +
                        " | Remaining Burst Time: " + current.process.burstTime);

                if (current.process.burstTime == 0) {
                    // Process completed
                    System.out.println("Process ID " + current.process.processId + " has completed execution.");
                    removeProcess(current.process.processId);
                } else {
                    current = current.next; // Move to the next process
                }
            }

            processCount++;
        }

        // Calculate average waiting time and turnaround time
        if (processCount > 0) {
            System.out.println("\nAverage Waiting Time: " + (totalWaitingTime / processCount));
            System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / processCount));
        } else {
            System.out.println("\nNo processes executed.");
        }
    }

    // Display all processes in the circular list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Node current = head;
        do {
            System.out.println("Process ID: " + current.process.processId +
                    " | Burst Time: " + current.process.burstTime +
                    " | Priority: " + current.process.priority);
            current = current.next;
        } while (current != head);
    }
}
