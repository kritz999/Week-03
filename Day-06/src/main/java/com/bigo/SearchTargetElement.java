package com.bigo;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class SearchTargetElement {

    //O(n)
    public static int LinearSearch(int[]DataSet,int target){
        for(int i=0;i<DataSet.length;i++){
            if(DataSet[i]==target){
                return i;
            }

        }
            return -1;
    }

    //O(log n)
    public static int BinarySearch(int []DataSet,int target){

        int start =0;
        int end = DataSet.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(DataSet[mid] ==target){
                return mid;
            }else if(DataSet[mid]<target){
                start=mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] DataSet ={1000,10000,1000000};

        Random red = new Random();
        for(int size : DataSet){
            int [] arr = new int[size];

            for(int i=0;i<size;i++){
                arr[i]= red.nextInt(size*10);
            }
            int target = arr[red.nextInt(size)];

            long startTime = System.nanoTime();
            LinearSearch(arr, target);
            long linearTime = System.nanoTime() - startTime;


            Arrays.sort(arr);

            startTime = System.nanoTime();
            BinarySearch(arr, target);
            long binaryTime = System.nanoTime() - startTime;

              // Convert time to milliseconds
             System.out.println("Dataset Size: " + size);
             System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
             System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
             System.out.println("--------------------------------------");


        }

    }


}
