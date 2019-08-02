package com.smdev.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before
    public void SetUp() {
        stack = new Stack();
    }

    @Test
    public void push_peek_pop() {
        Assert.assertEquals(null, stack.peek());
        Assert.assertEquals(null, stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(3, stack.peek());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.peek());
    }

    @Test
    public void isEmpty(){
        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        Assert.assertFalse(stack.isEmpty());

        stack.peek();
        Assert.assertFalse(stack.isEmpty());

        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }

}
