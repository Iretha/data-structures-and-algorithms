package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void push_peek_pop() {
        Assertions.assertEquals(null, stack.peek());
        Assertions.assertEquals(null, stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.peek());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.peek());
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(stack.isEmpty());

        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());

        stack.peek();
        Assertions.assertFalse(stack.isEmpty());

        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
    }

}
