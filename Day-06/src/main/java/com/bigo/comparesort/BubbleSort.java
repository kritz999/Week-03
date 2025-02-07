package com.bigo.comparesort;

public class BubbleSort {


   public static void Bubble(int[]arr){
       int n = arr.length;
       boolean swapped;

       for(int i=0;i<n-1;i++){
           swapped = false;
           for(int j=i;j<n-i-1;j++){
               if(arr[j]>arr[j+1]){
                   //swap
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;

                   swapped = true;
               }
           }
            if(!swapped) break;
       }

    }

}
