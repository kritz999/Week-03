package com.bigo.recursiveiterativecomputation;

import static com.bigo.recursiveiterativecomputation.Iterative.fibonacciIterative;
import static com.bigo.recursiveiterativecomputation.Recurssive.fibonacciRecursive;

public class Main {
    public static void main(String[] args) {
          int [] arr ={10,30,50};


          for(int n : arr) {
              System.out.println("\n fibonacci for N =" + n);

              long startTime = System.currentTimeMillis();
              int iterativeResult = fibonacciIterative(n);
              long endTime = System.currentTimeMillis();
              System.out.println("fibonacci using iteration "+(endTime-startTime)+"ms"+"\nIterative result "+iterativeResult);


              startTime = System.currentTimeMillis();
              int recursiveResult =  fibonacciRecursive(n);
              endTime = System.currentTimeMillis();
              System.out.println("fibonacci using recursion"+(endTime-startTime)+"ms"+"\nIterative result "+recursiveResult);

          }
    }
}
