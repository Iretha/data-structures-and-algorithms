package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueFromStacksTest {

    @Test
    void testPush(){
        QueueFromStacks que = new QueueFromStacks();
        Assertions.assertTrue(que.size() == 0);

        que.push(1);
        Assertions.assertTrue(que.size() == 1);

        que.push(2);
        Assertions.assertTrue(que.size() == 2);

        que.push(3);
        Assertions.assertTrue(que.size() == 3);
    }

    @Test
    void testPeek(){
        QueueFromStacks que = new QueueFromStacks();
        Assertions.assertEquals(0, que.peek());

        que.push(1);
        que.push(2);
        que.push(3);
        Assertions.assertEquals(1, que.peek());
        Assertions.assertTrue(que.size() == 3);
    }

    @Test
    void testPop(){
        QueueFromStacks que = new QueueFromStacks();
        que.push(1);
        que.push(2);
        que.push(3);
        Assertions.assertTrue(que.size() == 3);

        int num = que.pop();
        Assertions.assertTrue(num == 1);
        Assertions.assertTrue(que.size() == 2);

        num = que.pop();
        Assertions.assertTrue(num == 2);
        Assertions.assertTrue(que.size() == 1);

        num = que.pop();
        Assertions.assertTrue(num == 3);
        Assertions.assertTrue(que.size() == 0);

        num = que.pop();
        Assertions.assertTrue(num == 0);
        Assertions.assertTrue(que.size() == 0);
    }
}
