package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BSTTest {

    @Test
    void testInsert() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        List<Integer> inorder = tree.inorder();
        Assertions.assertArrayEquals(new Integer[]{2, 3, 4, 5, 6, 7, 8}, inorder.toArray());

        List<Integer> preorder = tree.preorder();
        Assertions.assertArrayEquals(new Integer[]{5, 3, 2, 4, 7, 6, 8}, preorder.toArray());

        List<Integer> postorder = tree.postorder();
        Assertions.assertArrayEquals(new Integer[]{2, 4, 3, 6, 8, 7, 5}, postorder.toArray());
    }

    @Test
    void testInOrder() {
        BST tree = new BST();
        tree.insert(9);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        List<Integer> inorder = tree.inorder();
        System.out.println(Arrays.toString(inorder.toArray()));
    }

    @Test
    void testPostOrder() {
        BST tree = new BST();
        tree.insert(9);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        List<Integer> order = tree.postorder();
        System.out.println(Arrays.toString(order.toArray()));
    }

    @Test
    void testInOrderLinear() {
        BST tree = new BST();
        tree.insert(9);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        List<Integer> inorder = tree.inorder();
        List<Integer> integerLinear = tree.inorderLinear();

        Assertions.assertArrayEquals(inorder.toArray(), integerLinear.toArray());
        System.out.println(Arrays.toString(inorder.toArray()));
    }

    @Test
    void testLookup() {
        BST tree = new BST();
        assertFalse(tree.lookup(5));

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertTrue(tree.lookup(5));
        assertTrue(tree.lookup(3));
        assertTrue(tree.lookup(7));

        assertFalse(tree.lookup(0));
        assertFalse(tree.lookup(2));
        assertFalse(tree.lookup(10));
    }

    @Test
    void testDelete() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertTrue(tree.lookup(5));
        assertTrue(tree.lookup(3));
        assertTrue(tree.lookup(7));

        tree.delete(0);

        tree.delete(3);
        assertFalse(tree.lookup(3));

        tree.delete(7);
        assertFalse(tree.lookup(7));

        tree.delete(5);
        assertFalse(tree.lookup(5));
    }
}
