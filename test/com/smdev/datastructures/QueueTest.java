package com.smdev.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private Queue queue;

    @Before
    public void SetUp() {
        queue = new Queue();
    }

    @Test
    public void insert_delete_peek() {
        Assert.assertEquals(null, queue.peek());
        Assert.assertEquals(null, queue.remove());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assert.assertEquals(1, queue.peek());
        Assert.assertEquals(1, queue.remove());
        Assert.assertEquals(2, queue.peek());
    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(queue.isEmpty());

        queue.add(1);
        Assert.assertFalse(queue.isEmpty());

        queue.peek();
        Assert.assertFalse(queue.isEmpty());

        queue.remove();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testPathWithSum(){
        //        10
        //       /  \
        //      5   -3
        //     / \    \
        //    3   2   11
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
        RandomBinaryTree.Node lvl3_1 = tree.add(lvl1_5, 1, false);

        // 10 -> -3
        RandomBinaryTree.Node lvl1_3 = tree.add(lvl0_10, -3, false);
        // 10 -> -3 -> 11
        RandomBinaryTree.Node lvl2_11 = tree.add(lvl1_3, 11, false);
    }

}
