package com.smdev.hackerrank;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 */
public class Staircase {
    public static void main(String[] args) {
        staircase(4);
    }

    // Complete the staircase function below.
    static void staircase(int n) {
        int width = 1;
        StringBuilder b = new StringBuilder();
        while (width <= n) {
            for (int s = 0; s < n - width; s++) {
                b.append(" ");
            }
            for (int w = 0; w < width; w++) {
                b.append("#");
            }
            b.append("\n");
            width++;
        }
        System.out.println(b.toString());
    }
}
