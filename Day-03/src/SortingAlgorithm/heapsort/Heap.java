package SortingAlgorithm.heapsort;
import java.util.*;
public class Heap {
    public static void heapify(double[] salaries, int n, int i) {
        int largest = i;  // Root (largest element)
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }

    // Heap Sort function
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on reduced heap
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the number of job applicants: ");
        int n = scanner.nextInt();
        double[] salaries = new double[n];

        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextDouble();
        }

        // Sorting salaries using Heap Sort
        heapSort(salaries);

        // Displaying the sorted salaries
        System.out.println("Sorted Salary Demands:");
        for (double salary : salaries) {
            System.out.print(salary + " ");
        }

        scanner.close();

    }
}
