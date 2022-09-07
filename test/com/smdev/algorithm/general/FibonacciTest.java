package com.smdev.algorithm.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testFibonacci() {
        Assertions.assertEquals(0, Fibonacci.fib(-1));
        Assertions.assertEquals(0, Fibonacci.fib(0));
        Assertions.assertEquals(1, Fibonacci.fib(1));
        Assertions.assertEquals(1, Fibonacci.fib(2));
        Assertions.assertEquals(2, Fibonacci.fib(3));
        Assertions.assertEquals(3, Fibonacci.fib(4));
        Assertions.assertEquals(5, Fibonacci.fib(5));
        Assertions.assertEquals(8, Fibonacci.fib(6));
        Assertions.assertEquals(13, Fibonacci.fib(7));
    }

    @Test
    void testFibonacciPerformance() {
        int n = 50;

        long start = System.currentTimeMillis();
        int res = Fibonacci.fib(n);
        long duration1 = (System.currentTimeMillis() - start);
        System.out.println("No Memoization: Calculated in " + duration1 + " ms." + "; res=" + res);


        start = System.currentTimeMillis();
        res = Fibonacci.fibMemoization(n);
        long duration2 = (System.currentTimeMillis() - start);
        System.out.println("With Memoization: Calculated in " + duration2 + " ms." + "; res=" + res);

        Assertions.assertTrue(duration1 > duration2);
    }
}
