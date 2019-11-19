package com.smdev.hackerrank;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class ProportionsOfOccurrence {

    public static void main(String[] args) {
        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }

    static void plusMinus(int[] arr) {
        int pos = 0;
        int neg = 0;
        int zeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neg++;
            } else if (arr[i] == 0) {
                zeros++;
            } else {
                pos++;
            }
        }

        System.out.printf("%.6f\n", pos > 0 ? ((double)pos / arr.length) : 0.0);
        System.out.printf("%.6f\n", neg > 0 ? ((double)neg / arr.length) : 0.0);
        System.out.printf("%.6f\n", zeros > 0 ? ((double)zeros / arr.length) : 0.0);
    }
}
