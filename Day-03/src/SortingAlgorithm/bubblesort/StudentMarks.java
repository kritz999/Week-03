package SortingAlgorithm.bubblesort;

import java.util.Arrays;

public class StudentMarks {
    public static void bubblesort(int[]arr){
        boolean swapped;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            swapped =false;
            for(int j=0;j<n-i-1;j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped =true;
                }
            }
            if(!swapped)break;  //stop if no swap occurs
        }
    }
    public static void main(String[] args) {
        int [] arr ={90,80,100,60,20,70};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
