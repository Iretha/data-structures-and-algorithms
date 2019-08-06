package com.smdev.algorithm.general;

public class Fibonacci {

    private static final int[] CACHE = new int[1001];

    public static int fibMemoization(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (CACHE[n] == 0) {
                CACHE[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
            }
            return CACHE[n];
        }
    }

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
