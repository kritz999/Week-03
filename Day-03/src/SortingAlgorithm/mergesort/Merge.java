package SortingAlgorithm.mergesort;
import java.util.*;
public class Merge {
    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];

        // Merging process
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray (if any)
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray (if any)
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Merge Sort function
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle index

            mergeSort(prices, left, mid);      // Sort first half
            mergeSort(prices, mid + 1, right); // Sort second half
            merge(prices, left, mid, right);   // Merge the sorted halves
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        double[] bookPrices = new double[n];

        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextDouble();
        }

        // Sorting the book prices
        mergeSort(bookPrices, 0, n - 1);

        // Displaying the sorted prices
        System.out.println("Sorted Book Prices:");
        for (double price : bookPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }
    }
