package SortingAlgorithm.quicksort;
import java.util.*;
public class Quick {
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with the element at i+1
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }

    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high); // Find pivot index

            quickSort(prices, low, pi - 1);  // Sort left half
            quickSort(prices, pi + 1, high); // Sort right half
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        double[] productPrices = new double[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = scanner.nextDouble();
        }

        // Sorting the product prices
        quickSort(productPrices, 0, n - 1);

        // Displaying the sorted prices
        System.out.println("Sorted Product Prices:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }

}
