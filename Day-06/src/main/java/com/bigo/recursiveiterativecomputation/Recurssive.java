package com.bigo.recursiveiterativecomputation;

public class Recurssive {


    public static int fibonacciRecursive(int  n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 1);

    }




}
