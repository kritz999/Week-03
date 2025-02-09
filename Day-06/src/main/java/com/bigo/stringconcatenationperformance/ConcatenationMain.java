package com.bigo.stringconcatenationperformance;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.lang.StringBuffer;

public class ConcatenationMain {

    public static String string(String [] arr) {
        String str ="";
        for(int i=0;i< arr.length;i++){
            str+= arr[i]; //creates a new object every time

        }

            return str;
    }


    public static String StringBuilder(String [] arr) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i< arr.length;i++) {
                sb.append(arr[i]);
            }
        return sb.toString();
    }


    public static String StringBuffer(String[]arr) {
            StringBuffer sub = new StringBuffer();
            for(int i=0;i<arr.length;i++){
                sub.append(arr[i]);
            }
            return sub.toString();

    }
    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};

        for (int s : sizes) {
            String[] arr = new String[s];
            for (int i = 0; i < s; i++) {
                arr[i] = Integer.toString(i);
            }


            //returns the current time in milliseconds
            long startTime = System.currentTimeMillis();
            string(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken by string " + (endTime - startTime) + "ms");

            //start time without executing the code of string builder
            startTime = System.currentTimeMillis();
            StringBuilder(arr);
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by string builder " + (endTime - startTime) + "ms");

            //start time of string buffer without execution of code
            startTime = System.currentTimeMillis();
            StringBuffer(arr);
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by string buffer " + (endTime - startTime) + "ms");

        }
    }

}
