package com.smdev.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryHeapMinTest {

    private BinaryHeapMin minHeap;

    @Before
    public void setUp() {
        minHeap = new BinaryHeapMin();
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
    }

    @Test
    public void testInsert() {
        int idx = 0;
        Assert.assertEquals(1, minHeap.getByIndex(idx++));
        Assert.assertEquals(3, minHeap.getByIndex(idx++));
        Assert.assertEquals(2, minHeap.getByIndex(idx++));
        Assert.assertEquals(6, minHeap.getByIndex(idx++));
        Assert.assertEquals(4, minHeap.getByIndex(idx++));
        Assert.assertEquals(5, minHeap.getByIndex(idx++));
    }

    @Test
    public void testExtractMin() {
        Assert.assertEquals(1, minHeap.extractMin());
        Assert.assertEquals(2, minHeap.extractMin());
        Assert.assertEquals(3, minHeap.extractMin());
        Assert.assertEquals(4, minHeap.extractMin());
        Assert.assertEquals(5, minHeap.extractMin());
        Assert.assertEquals(6, minHeap.extractMin());
    }
}
