package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.T09_SubTreeChecker;
import com.smdev.datastructures.SimpleBinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class TreeTests {

    @Test
    public void test_T09_CheckSubtree(){
        SimpleBinarySearchTree t1 = new SimpleBinarySearchTree();
        t1.insert(5);
        t1.insert(3);
        t1.insert(2);
        t1.insert(4);
        t1.insert(7);
        t1.insert(6);
        t1.insert(8);

        SimpleBinarySearchTree t2 = new SimpleBinarySearchTree();
        t2.insert(7);
        t2.insert(6);
        t2.insert(8);

        Assert.assertTrue(T09_SubTreeChecker.isSubTreePreOrder(t1, t2));
        Assert.assertTrue(T09_SubTreeChecker.isSubTreeInOrder(t1, t2));
        Assert.assertTrue(T09_SubTreeChecker.isSubTreePostOrder(t1, t2));
    }
}
