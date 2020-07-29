package com.smdev.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class QueueFromStacksTest {

    @Test
    public void testPush(){
        QueueFromStacks que = new QueueFromStacks();
        Assert.assertTrue(que.size() == 0);

        que.push(1);
        Assert.assertTrue(que.size() == 1);

        que.push(2);
        Assert.assertTrue(que.size() == 2);

        que.push(3);
        Assert.assertTrue(que.size() == 3);
    }

    @Test
    public void testPeek(){
        QueueFromStacks que = new QueueFromStacks();
        Assert.assertEquals(0, que.peek());

        que.push(1);
        que.push(2);
        que.push(3);
        Assert.assertEquals(1, que.peek());
        Assert.assertTrue(que.size() == 3);
    }

    @Test
    public void testPop(){
        QueueFromStacks que = new QueueFromStacks();
        que.push(1);
        que.push(2);
        que.push(3);
        Assert.assertTrue(que.size() == 3);

        int num = que.pop();
        Assert.assertTrue(num == 1);
        Assert.assertTrue(que.size() == 2);

        num = que.pop();
        Assert.assertTrue(num == 2);
        Assert.assertTrue(que.size() == 1);

        num = que.pop();
        Assert.assertTrue(num == 3);
        Assert.assertTrue(que.size() == 0);

        num = que.pop();
        Assert.assertTrue(num == 0);
        Assert.assertTrue(que.size() == 0);
    }
}
