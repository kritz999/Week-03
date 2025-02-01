package SortingAlgorithm.countingsort;
import java.util.*;
public class counting {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;

        int n = ages.length;
        int[] count = new int[range];  // Count array
        int[] output = new int[n];     // Output array

        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in their correct positions
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted values back to original array
        System.arraycopy(output, 0, ages, 0, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] studentAges = new int[n];

        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = scanner.nextInt();
        }

        // Sorting ages using Counting Sort
        countingSort(studentAges);

        // Displaying the sorted ages
        System.out.println("Sorted Student Ages:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }

        scanner.close();

    }
}
