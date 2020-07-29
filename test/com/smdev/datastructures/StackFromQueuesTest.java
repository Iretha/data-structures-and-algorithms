package com.smdev.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class StackFromQueuesTest {

    @Test
    public void testPush() {
        StackFromQueues stack = new StackFromQueues();
        Assert.assertTrue(stack.size() == 0);

        stack.push(1);
        Assert.assertTrue(stack.size() == 1);

        stack.push(2);
        Assert.assertTrue(stack.size() == 2);

        stack.push(3);
        Assert.assertTrue(stack.size() == 3);

        Assert.assertTrue(stack.top() == 3);
    }

    @Test
    public void testTop() {
        StackFromQueues stack = new StackFromQueues();
        Assert.assertEquals(0, stack.top());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertTrue(stack.size() == 3);
    }

    @Test
    public void testPop() {
        StackFromQueues stack = new StackFromQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertTrue(stack.size() == 3);

        int num = stack.pop();
        Assert.assertTrue(num == 3);
        Assert.assertTrue(stack.size() == 2);

        num = stack.pop();
        Assert.assertTrue(num == 2);
        Assert.assertTrue(stack.size() == 1);

        num = stack.pop();
        Assert.assertTrue(num == 1);
        Assert.assertTrue(stack.size() == 0);

        num = stack.pop();
        Assert.assertTrue(num == 0);
        Assert.assertTrue(stack.size() == 0);
    }

    @Test
    public void test() {
        StackFromQueues stack = new StackFromQueues();
        stack.push(1);
        stack.push(2);
        Assert.assertTrue(stack.size() == 2);
        Assert.assertEquals(2, stack.pop());
        Assert.assertTrue(stack.size() == 1);
        Assert.assertEquals(1, stack.top());
        Assert.assertTrue(stack.size() == 1);
    }
}
