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

}
