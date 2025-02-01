package SortingAlgorithm.insertionsort;
import java.util.*;
public class Insertion {
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Shift elements of the sorted part to find the correct position for key
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key; // Insert key at the correct position
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        int[] employeeIds = new int[n];

        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = scanner.nextInt();
        }

        // Sorting the employee IDs
        insertionSort(employeeIds);

        // Displaying the sorted IDs
        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }

        scanner.close();
    }



}
