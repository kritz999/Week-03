package LinkedList.circularlinkedlist.roundrobinscheduling;

public class RoundMain {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        // Simulating Round-Robin Scheduling with time quantum = 3
        scheduler.simulateRoundRobin(3);
    }
}
