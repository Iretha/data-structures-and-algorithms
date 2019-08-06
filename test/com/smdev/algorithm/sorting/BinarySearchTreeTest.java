package com.smdev.algorithm.sorting;

import com.smdev.algorithm.sorting.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @Before
    public void SetUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void testInsertAndFind() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        Assert.assertEquals("e", bst.find(5));
        Assert.assertEquals("c", bst.find(3));
        Assert.assertEquals("b", bst.find(2));
        Assert.assertEquals("d", bst.find(4));
        Assert.assertEquals("g", bst.find(7));
        Assert.assertEquals("f", bst.find(6));
        Assert.assertEquals("h", bst.find(8));
        Assert.assertEquals(null, bst.find(99));

//        bst.prettyPrint();

//        bst.traverseInOrder();
//        bst.traversePreOrder();
//        bst.traversePostOrder();
    }

    @Test
    public void testTraversalOrder(){
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
    public void testMinKey() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");

        Assert.assertEquals(2, bst.findMinKey());
    }

    @Test
    public void testDeleteNoChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(2);

        Assert.assertNull(bst.find(2));

        //       bst.prettyPrint();
    }

    @Test
    public void testDeleteOneChild() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");

        bst.delete(7);

        Assert.assertNull(bst.find(7));
        Assert.assertNotNull(bst.find(6));

//        bst.prettyPrint();
    }

    @Test
    public void testDeleteTwoChildren() {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(7);

        Assert.assertNull(bst.find(7));
        Assert.assertNotNull(bst.find(6));
        Assert.assertNotNull(bst.find(8));

        //       bst.prettyPrint();
    }
}
