package com.bigo.comparesort;
import java.util.Arrays;
import java.util.Random;
import static com.bigo.comparesort.BubbleSort.Bubble;

public class CompareSortMain {
    public static void main(String[] args) {

        int size = 10000; // Change dataset size
        int[] arr1 = generateRandomArray(size);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);


        // Bubble Sort
        long startTime = System.nanoTime();
        BubbleSort.Bubble(arr1);
        long bubbleTime = System.nanoTime() - startTime;
        System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");


        // Merge Sort
        startTime = System.nanoTime();
        MergeSort.mergeSort(arr2, 0, arr2.length - 1);
        long mergeTime = System.nanoTime() - startTime;
        System.out.println("Merge Sort Time: " + mergeTime / 1_000_000.0 + " ms");


        // Quick Sort
        startTime = System.nanoTime();
        QuickSort.quickSort(arr3, 0, arr3.length - 1);
        long quickTime = System.nanoTime() - startTime;
        System.out.println("Quick Sort Time: " + quickTime / 1_000_000.0 + " ms");
    }


    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;

    }
}
