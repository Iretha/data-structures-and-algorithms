---
layout: default
title: Fibonacci Series
parent: Algorithms (General)
nav_order: 101
description: "Fibonacci Series & Memoization"
permalink: /fibonacci
---
# Fibonacci Series & Memoization
{: .fs-9 }

Series of numbers where every number, after the first two, is the sum of the previous two numbers.
{: .fs-6 .fw-300 }
---

## Summary
Series of numbers where every number, after the first two, is the sum of the previous two numbers.
1, 1, 2, 3, 5, 8, 13, 21...

* F(n) = F(n-1) + F(n-2), where F(0) = 0 and F(1) = 1
* The Time Complexity is O(N^2), which is a lot, but with memoization it can be reduced to O(N)!!!

### Recursive Implementation with no Memoization (Naive Implementation)
The recursive implementation has a time complexity of O(N^2) and is very slow, because we need to recalculated 
same members again and again.
```java
    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
```

### Recursive Implementation with Memoization
Once calculated, we can store the value in an array and return the value if it's already present.
This is an optimization technique called "Memoization".
With memoization we the time complexity will be reduced to O(N).
```java
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
```