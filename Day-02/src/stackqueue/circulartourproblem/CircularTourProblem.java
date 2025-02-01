package stackqueue.circulartourproblem;
import java.util.*;

public class CircularTourProblem {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, currentPetrol = 0, totalPetrol = 0;

        for (int i = 0; i < petrol.length; i++) {
            int balance = petrol[i] - distance[i];
            totalPetrol += balance;
            currentPetrol += balance;
            queue.offer(i);

            while (currentPetrol < 0 && !queue.isEmpty()) {
                start = queue.poll() + 1;
                currentPetrol -= petrol[start] - distance[start];
            }
        }

        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        System.out.println("Starting petrol pump index: " + start);
    }

}
