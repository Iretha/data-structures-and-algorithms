package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.T06_LinkedListDuplicateRemover;
import com.smdev.algorithm.general.challenges.T07_SumLists;
import com.smdev.algorithm.general.challenges.T08_LinkedListLoopDetector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class LinkedListTests {

    @Test
    void test_T06_RemoveDuplicates() {
        // Challenge: Write a method that removes any duplicates from our Linked List.

        T06_LinkedListDuplicateRemover list1 = new T06_LinkedListDuplicateRemover(1, 2, 1, 2, 3, 1, 3, 3);
        list1.removeDuplicates();

        Assertions.assertEquals(3, list1.size());
    }

    @Test
    void test_T07_SumStacks() {
        // Example
        // Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
        // Output: (2 -> 2 -> 8). That is 822.

        // Create our two numbers
        Stack<Integer> q1 = new Stack<>(); // 0
        Stack<Integer> q2 = new Stack();  // 0

        Stack<Integer> res = T07_SumLists.sum(q1, q2); // 0
        Assertions.assertEquals(Integer.valueOf(0), res.pop());

        q1.push(5); // 5
        res = T07_SumLists.sum(q1, q2); // 5
        Assertions.assertEquals(Integer.valueOf(5), res.pop());

        q1.push(5); // 5
        q2.push(1); // 1
        res = T07_SumLists.sum(q1, q2); // 6
        Assertions.assertEquals(Integer.valueOf(6), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q2.push(1); // 1
        q2.push(9); // 19
        res = T07_SumLists.sum(q1, q2); // 72
        Assertions.assertEquals(Integer.valueOf(2), res.pop());
        Assertions.assertEquals(Integer.valueOf(7), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q1.push(9); // 539
        q2.push(1); // 1
        q2.push(9); // 19
        res = T07_SumLists.sum(q1, q2); // 558
        Assertions.assertEquals(Integer.valueOf(8), res.pop());
        Assertions.assertEquals(Integer.valueOf(5), res.pop());
        Assertions.assertEquals(Integer.valueOf(5), res.pop());

        q1.push(5); // 5
        q1.push(3); // 53
        q1.push(9); // 539
        q2.push(1); // 1
        q2.push(9); // 19
        q2.push(2); // 192
        q2.push(0); // 1920
        res = T07_SumLists.sum(q1, q2); // 2459
        Assertions.assertEquals(Integer.valueOf(9), res.pop());
        Assertions.assertEquals(Integer.valueOf(5), res.pop());
        Assertions.assertEquals(Integer.valueOf(4), res.pop());
        Assertions.assertEquals(Integer.valueOf(2), res.pop());
    }

    @Test
    void test_T08_HasLoop() {
        T08_LinkedListLoopDetector.Node n0 = new T08_LinkedListLoopDetector.Node(0);
        T08_LinkedListLoopDetector.Node n1 = new T08_LinkedListLoopDetector.Node(1);
        T08_LinkedListLoopDetector.Node n2 = new T08_LinkedListLoopDetector.Node(2);
        T08_LinkedListLoopDetector.Node n3 = new T08_LinkedListLoopDetector.Node(3);
        T08_LinkedListLoopDetector.Node n4 = new T08_LinkedListLoopDetector.Node(4);
        T08_LinkedListLoopDetector.Node n5 = new T08_LinkedListLoopDetector.Node(5);

        T08_LinkedListLoopDetector l1 = new T08_LinkedListLoopDetector();
        Assertions.assertFalse(l1.detectLoop());

        T08_LinkedListLoopDetector l2 = new T08_LinkedListLoopDetector(n1);
        Assertions.assertFalse(l2.detectLoop());

        T08_LinkedListLoopDetector l3 = new T08_LinkedListLoopDetector(n1, n2);
        Assertions.assertFalse(l3.detectLoop());

        T08_LinkedListLoopDetector l4 = new T08_LinkedListLoopDetector(n1, n2, n2);
        Assertions.assertTrue(l4.detectLoop());

        T08_LinkedListLoopDetector l5 = new T08_LinkedListLoopDetector(n1, n0, n1);
        Assertions.assertTrue(l5.detectLoop());

        T08_LinkedListLoopDetector l7 = new T08_LinkedListLoopDetector(n0, n1, n1);
        Assertions.assertTrue(l7.detectLoop());

        T08_LinkedListLoopDetector l8 = new T08_LinkedListLoopDetector(n1, n2, n3, n4, n5, n3);
        Assertions.assertTrue(l8.detectLoop());

        T08_LinkedListLoopDetector l9 = new T08_LinkedListLoopDetector(n1, n5, n4, n3, n2, n1);
        Assertions.assertTrue(l9.detectLoop());

    }
}
