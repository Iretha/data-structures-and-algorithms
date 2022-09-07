package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackFromQueuesTest {

    @Test
    void testPush() {
        StackFromQueues stack = new StackFromQueues();
        Assertions.assertTrue(stack.size() == 0);

        stack.push(1);
        Assertions.assertTrue(stack.size() == 1);

        stack.push(2);
        Assertions.assertTrue(stack.size() == 2);

        stack.push(3);
        Assertions.assertTrue(stack.size() == 3);

        Assertions.assertTrue(stack.top() == 3);
    }

    @Test
    void testTop() {
        StackFromQueues stack = new StackFromQueues();
        Assertions.assertEquals(0, stack.top());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.top());
        Assertions.assertTrue(stack.size() == 3);
    }

    @Test
    void testPop() {
        StackFromQueues stack = new StackFromQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertTrue(stack.size() == 3);

        int num = stack.pop();
        Assertions.assertTrue(num == 3);
        Assertions.assertTrue(stack.size() == 2);

        num = stack.pop();
        Assertions.assertTrue(num == 2);
        Assertions.assertTrue(stack.size() == 1);

        num = stack.pop();
        Assertions.assertTrue(num == 1);
        Assertions.assertTrue(stack.size() == 0);

        num = stack.pop();
        Assertions.assertTrue(num == 0);
        Assertions.assertTrue(stack.size() == 0);
    }

    @Test
    void test() {
        StackFromQueues stack = new StackFromQueues();
        stack.push(1);
        stack.push(2);
        Assertions.assertTrue(stack.size() == 2);
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertTrue(stack.size() == 1);
        Assertions.assertEquals(1, stack.top());
        Assertions.assertTrue(stack.size() == 1);
    }
}
