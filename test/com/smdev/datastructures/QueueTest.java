package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void insert_delete_peek() {
        Assertions.assertEquals(null, queue.peek());
        Assertions.assertEquals(null, queue.remove());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(2, queue.peek());
    }

    @Test
    void isEmpty(){
        Assertions.assertTrue(queue.isEmpty());

        queue.add(1);
        Assertions.assertFalse(queue.isEmpty());

        queue.peek();
        Assertions.assertFalse(queue.isEmpty());

        queue.remove();
        Assertions.assertTrue(queue.isEmpty());
    }

}
