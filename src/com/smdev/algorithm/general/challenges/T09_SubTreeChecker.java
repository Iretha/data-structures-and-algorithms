package com.smdev.algorithm.general.challenges;

import com.smdev.datastructures.SimpleBinarySearchTree;

public class T09_SubTreeChecker {

    public static boolean isSubTreePreOrder(SimpleBinarySearchTree t1, SimpleBinarySearchTree t2) {
        String preOrder1 = t1.getPreOrder();
        String preOrder2 = t2.getPreOrder();

        return preOrder1.contains(preOrder2);
    }

    public static boolean isSubTreePostOrder(SimpleBinarySearchTree t1, SimpleBinarySearchTree t2) {
        String order1 = t1.getPostOrder();
        String order2 = t2.getPostOrder();

        return order1.contains(order2);
    }

    public static boolean isSubTreeInOrder(SimpleBinarySearchTree t1, SimpleBinarySearchTree t2) {
        String order1 = t1.getInOrder();
        String order2 = t2.getInOrder();

        return order1.contains(order2);
    }
}
