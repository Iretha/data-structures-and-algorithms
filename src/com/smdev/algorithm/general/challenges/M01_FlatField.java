package com.smdev.algorithm.general.challenges;

public class M01_FlatField {

    private static final int[][] FIELD1 = new int[][]{
            {1, 1, 0, 2},
            {1, 0, 2, 0},
            {2, 0, 0, 0},
    };

    public static int findMaxConnected(int[][] f) {
        if (f == null || f.length == 0) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConnected(FIELD1));
    }
}
