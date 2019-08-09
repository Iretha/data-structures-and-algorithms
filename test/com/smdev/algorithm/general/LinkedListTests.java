package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.T06_LinkedListDuplicateRemover;
import com.smdev.algorithm.general.challenges.T07_SumLists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LinkedListTests {

    @Test
    public void test_T06_RemoveDuplicates() {
        // Challenge: Write a method that removes any duplicates from our Linked List.

        T06_LinkedListDuplicateRemover list1 = new T06_LinkedListDuplicateRemover(1, 2, 1, 2, 3, 1, 3, 3);
        list1.removeDuplicates();

        Assert.assertEquals(3, list1.size());
    }

    @Test
    public void test_T07_SumStacks() {
        // Example
        // Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
        // Output: (2 -> 2 -> 8). That is 822.

        // Create our two numbers
        Stack<Integer> q1 = new Stack<>(); // 0
        Stack<Integer> q2 = new Stack();  // 0

        Stack<Integer> res = T07_SumLists.sum(q1, q2); // 0
        Assert.assertEquals(Integer.valueOf(0), res.pop());

        q1.push(5); // 5
        res = T07_SumLists.sum(q1, q2); // 5
        Assert.assertEquals(Integer.valueOf(5), res.pop());

        q1.push(5); // 5
        q2.push(1); // 1
        res = T07_SumLists.sum(q1, q2); // 6
        Assert.assertEquals(Integer.valueOf(6), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q2.push(1); // 1
        q2.push(9); // 19
        res = T07_SumLists.sum(q1, q2); // 72
        Assert.assertEquals(Integer.valueOf(2), res.pop());
        Assert.assertEquals(Integer.valueOf(7), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q1.push(9); // 539
        q2.push(1); // 1
        q2.push(9); // 19
        res = T07_SumLists.sum(q1, q2); // 558
        Assert.assertEquals(Integer.valueOf(8), res.pop());
        Assert.assertEquals(Integer.valueOf(5), res.pop());
        Assert.assertEquals(Integer.valueOf(5), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q1.push(9); // 539
        q2.push(1); // 1
        q2.push(9); // 19
        q2.push(2); // 192
        q2.push(0); // 1920
        res = T07_SumLists.sum(q1, q2); // 2459
        Assert.assertEquals(Integer.valueOf(9), res.pop());
        Assert.assertEquals(Integer.valueOf(5), res.pop());
        Assert.assertEquals(Integer.valueOf(4), res.pop());
        Assert.assertEquals(Integer.valueOf(2), res.pop());
    }
}
