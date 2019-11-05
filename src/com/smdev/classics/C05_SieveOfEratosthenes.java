package com.smdev.classics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * The basic algorithm requires O(n) of memory.
 * Operations complexity is O(n log log n)
 */
public class C05_SieveOfEratosthenes {

    private static List<Integer> calcPrimes(int max) {
        if (max < 2) {
            return new ArrayList<>();
        }

        // create your list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            numbers.add(i);
        }

        // mark every N-th element as not prime
        Integer step;
        for (int idx = 2; idx < Math.sqrt(max); idx++) {
            step = numbers.get(idx);
            if (step == -1 || idx + step >= numbers.size()) {
                continue; // already marked as not-a-prime number or out of range
            }
            for (int y = idx + step; y <= max; y = y + step) {
                numbers.set(y, -1); // mark as not-a-prime number
            }
        }
        return numbers.stream().filter(n -> n > 1).collect(Collectors.toList()); // get primes
    }

    public static void main(String[] args) {
        System.out.println(calcPrimes(30));
    }
}
