package com.bigo.comparesort;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int num1 = mid - left + 1;
        int num2 = right - mid;
        int[] leftArr = new int[num1];
        int[] rightArr = new int[num2];

        System.arraycopy(arr, left, leftArr, 0, num1);
        System.arraycopy(arr, mid + 1, rightArr, 0, num2);

        int i = 0, j = 0, k = left;
        while (i < num1 && j < num2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < num1) arr[k++] = leftArr[i++];
        while (j < num2) arr[k++] = rightArr[j++];
    }


}
