package com.smdev.algorithm.general;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testFibonacci() {
        Assert.assertEquals(0, Fibonacci.fib(-1));
        Assert.assertEquals(0, Fibonacci.fib(0));
        Assert.assertEquals(1, Fibonacci.fib(1));
        Assert.assertEquals(1, Fibonacci.fib(2));
        Assert.assertEquals(2, Fibonacci.fib(3));
        Assert.assertEquals(3, Fibonacci.fib(4));
        Assert.assertEquals(5, Fibonacci.fib(5));
        Assert.assertEquals(8, Fibonacci.fib(6));
        Assert.assertEquals(13, Fibonacci.fib(7));
    }

    @Test
    public void testFibonacciPerformance() {
        int n = 50;

        long start = System.currentTimeMillis();
        int res = Fibonacci.fib(n);
        System.out.println("No Memoization: Calculated in " + (System.currentTimeMillis() - start) + " ms." + "; res=" + res);

        start = System.currentTimeMillis();
        res = Fibonacci.fibMemoization(n);
        System.out.println("With Memoization: Calculated in " + (System.currentTimeMillis() - start) + " ms." + "; res=" + res);
    }
}
