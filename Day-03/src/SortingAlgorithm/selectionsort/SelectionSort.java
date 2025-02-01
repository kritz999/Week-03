package SortingAlgorithm.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void selection(int[]arr,int n){
        for(int i=0;i<n-1;i++){
            int smallestIdx =i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[smallestIdx]){
                    smallestIdx=j;
                }
            }

            int temp =arr[i];
            arr[i]=arr[smallestIdx];
            arr[smallestIdx]=temp;

        }
    }


    public static void main(String[] args) {
        int n=5;
        int[]arr ={45,10,55,80,100};
        selection(arr,n);
        System.out.println(Arrays.toString(arr));
    }
}
