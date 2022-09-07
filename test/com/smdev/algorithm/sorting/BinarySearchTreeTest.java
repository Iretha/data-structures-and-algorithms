package com.smdev.algorithm.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsertAndFind() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        Assertions.assertEquals("e", bst.find(5));
        Assertions.assertEquals("c", bst.find(3));
        Assertions.assertEquals("b", bst.find(2));
        Assertions.assertEquals("d", bst.find(4));
        Assertions.assertEquals("g", bst.find(7));
        Assertions.assertEquals("f", bst.find(6));
        Assertions.assertEquals("h", bst.find(8));
        Assertions.assertNull(bst.find(99));

//        bst.prettyPrint();

//        bst.traverseInOrder();
//        bst.traversePreOrder();
//        bst.traversePostOrder();
    }

    @Test
    void testTraversalOrder() {
        bst.insert(5, "a");
        bst.insert(2, "b");
        bst.insert(7, "c");

        System.out.println("\nIn Order: ");
        bst.traverseInOrder();

        System.out.println("\nPre Order: ");
        bst.traversePreOrder();

        System.out.println("\nPost Order: ");
        bst.traversePostOrder();
    }

    @Test
    void testMinKey() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");

        Assertions.assertEquals(2, bst.findMinKey());
    }

    @Test
    void testDeleteNoChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(2);

        Assertions.assertNull(bst.find(2));

        //       bst.prettyPrint();
    }

    @Test
    void testDeleteOneChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");

        bst.delete(7);

        Assertions.assertNull(bst.find(7));
        Assertions.assertNotNull(bst.find(6));

//        bst.prettyPrint();
    }

    @Test
    void testDeleteTwoChildren() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(7);

        Assertions.assertNull(bst.find(7));
        Assertions.assertNotNull(bst.find(6));
        Assertions.assertNotNull(bst.find(8));

        //       bst.prettyPrint();
    }
}
