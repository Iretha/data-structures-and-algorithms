package com.smdev.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDiff {

    public static void main(String[] args) {

        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 9));

        System.out.println(diagonalDifference(matrix));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int len = arr.size();
        int d1 = 0;
        int d2 = 0;
        for(int row = 0; row < len; row++){
            d1 += arr.get(row).get(row);
            d2 += arr.get(row).get(len - row - 1);
        }
        return Math.abs(d1-d2);
    }
}
