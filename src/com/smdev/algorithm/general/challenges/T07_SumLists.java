package com.smdev.algorithm.general.challenges;

import java.util.Stack;

public class T07_SumLists {

    /**
     * Challenge: You have two numbers represented by a linked list.
     * Each node represents a single digit, in reverse order, such that the
     * 1's digit is at the head. Write a function that adds the two numbers
     * and returns the sum as a linked list.
     * <p>
     * Example
     * Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
     * Output: (2 -> 2 -> 8). That is 822.
     */
    public static Stack<Integer> sum(Stack<Integer> q1, Stack<Integer> q2) {
        int n1 = getNum(q1);
        int n2 = getNum(q2);
        int sum = n1 + n2;
        return getAsStack(sum);
    }

    private static Stack<Integer> getAsStack(int num) {
        Stack<Integer> q = new Stack<>();
        if (num == 0) {
            q.push(0);
            return q;
        }

        String numAsStr = String.valueOf(num);
        for (int i = 0; i < numAsStr.length(); i++) {
            q.push(Integer.valueOf(String.valueOf(numAsStr.charAt(i))));
        }

        return q;
    }

    private static int getNum(Stack<Integer> q) {
        int num = 0;
        int multiplier = 1;
        while (q.size() > 0) {
            num = num + (q.pop() * multiplier);
            multiplier *= 10;
        }
        return num;
    }
}
