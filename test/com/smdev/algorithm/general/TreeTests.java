package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.T09_SubTreeChecker;
import com.smdev.datastructures.RandomBinaryTree;
import com.smdev.datastructures.SimpleBinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeTests {

    @Test
    void test_T09_CheckSubtree(){
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

        Assertions.assertTrue(T09_SubTreeChecker.isSubTreePreOrder(t1, t2));
        Assertions.assertTrue(T09_SubTreeChecker.isSubTreeInOrder(t1, t2));
        Assertions.assertTrue(T09_SubTreeChecker.isSubTreePostOrder(t1, t2));
    }

    @Test
    void testPathWithSum(){
        //        10
        //       /  \
        //      5   -3
        //     / \    \
        //    3   2   12
        //   / \   \
        //  3 -2   1
        RandomBinaryTree tree = new RandomBinaryTree();

        // 10
        RandomBinaryTree.Node lvl0_10 = tree.add(null, 10, true);
        // 10 -> 5
        RandomBinaryTree.Node lvl1_5 = tree.add(lvl0_10, 5, true);
        // 10 -> 5 -> 3
        RandomBinaryTree.Node lvl2_3 = tree.add(lvl1_5, 3, true);
        // 10 -> 5 -> 3 -> 3
        RandomBinaryTree.Node lvl3_3 = tree.add(lvl2_3, 3, true);
        // 10 -> 5 -> 3 -> -2
        RandomBinaryTree.Node lvl3_2 = tree.add(lvl2_3, -2, false);
        // 10 -> 5 -> 2
        RandomBinaryTree.Node lvl2_2 = tree.add(lvl1_5, 2, false);
        // 10 -> 5 -> 2 -> 1
        RandomBinaryTree.Node lvl3_1 = tree.add(lvl2_2, 1, false);
        // 10 -> -3
        RandomBinaryTree.Node lvl1_3 = tree.add(lvl0_10, -3, false);
        // 10 -> -3 -> 11
        RandomBinaryTree.Node lvl2_12 = tree.add(lvl1_3, 12, false);

        // Challenge 1: Given a binary tree that can contain positive or negative keys,
        // design an algorithm to check if there is a path with the given sum.
        // The path should start from root to leaf and must go downwards from parent to child.
        // 10 -> -3 -> 12
        Assertions.assertTrue(tree.hasPathSum(19));
        // 10 -> 5 -> 2 -> 1
        Assertions.assertTrue(tree.hasPathSum(18));
        // 10 -> 5 -> 3 -> -2
        Assertions.assertTrue(tree.hasPathSum(16));
        // 10 -> 5 -> 3 -> 3
        Assertions.assertTrue(tree.hasPathSum(21));

        // Challenge 2: Given a binary tree that can contain positive or negative keys,
        // design an algorithm to check if there is a sub path with the given sum.
        // The path does not necessary start from root or end to leaf, but must go downwards from parent to child.
        // 10 -> -3 -> 12
        Assertions.assertTrue(tree.hasSubPathSum(19));
        // 10 -> -3
        Assertions.assertTrue(tree.hasSubPathSum(7));
        // -3 -> 12
        Assertions.assertTrue(tree.hasSubPathSum(9));
        // 5 -> 3 / 5 -> 2 -> 1
        Assertions.assertTrue(tree.hasSubPathSum(8));
        // 3 -> 3
        Assertions.assertTrue(tree.hasSubPathSum(6));

        Assertions.assertFalse(tree.hasSubPathSum(0));
        Assertions.assertFalse(tree.hasSubPathSum(-10));

        // Challenge 3: Given a binary tree that can contain positive or negative keys,
        // design an algorithm to count the number of paths that sum to a given value.
        // The path does not need to start or end at the root or a leaf, but it must
        // go downwards from parent to child.
        // Now we are in a position to count paths
        Assertions.assertEquals(2, tree.countPathsWithSum(8));
        Assertions.assertEquals(2, tree.countPathsWithSum(7));
    }

}
