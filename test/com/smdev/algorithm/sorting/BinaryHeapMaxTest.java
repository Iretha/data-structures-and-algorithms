package com.smdev.algorithm.sorting;

import com.smdev.algorithm.sorting.BinaryHeapMax;
import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapMaxTest {

    private BinaryHeapMax maxHeap;

    @Test
    public void testInsert() {
        maxHeap = new BinaryHeapMax();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(35);

        // Test insert
        Assert.assertEquals(42, maxHeap.getByIndex(0));
        Assert.assertEquals(35, maxHeap.getByIndex(1));
        Assert.assertEquals(18, maxHeap.getByIndex(2));
        Assert.assertEquals(29, maxHeap.getByIndex(3));
    }

    @Test
    public void testExtractMax() {
        maxHeap = new BinaryHeapMax();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);

        // Insert(35)
        maxHeap.insert(35);

        // Test insert
        Assert.assertEquals(42, maxHeap.getByIndex(0));
        Assert.assertEquals(35, maxHeap.getByIndex(1));
        Assert.assertEquals(18, maxHeap.getByIndex(2));
        Assert.assertEquals(29, maxHeap.getByIndex(3));

        // Text extract max
        Assert.assertEquals(42, maxHeap.extractMax());
        Assert.assertEquals(35, maxHeap.extractMax());
        Assert.assertEquals(29, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());

//        maxHeap.print();
    }

    @Test
    public void testExtractMaxBigger() {
        maxHeap = new BinaryHeapMax();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(14);
        maxHeap.insert(7);
        maxHeap.insert(18);
        maxHeap.insert(12);
        maxHeap.insert(11);
        maxHeap.insert(13);

        Assert.assertEquals(42, maxHeap.extractMax());
        Assert.assertEquals(29, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());
        Assert.assertEquals(18, maxHeap.extractMax());
        Assert.assertEquals(14, maxHeap.extractMax());
        Assert.assertEquals(13, maxHeap.extractMax());
        Assert.assertEquals(12, maxHeap.extractMax());
        Assert.assertEquals(11, maxHeap.extractMax());
        Assert.assertEquals(7, maxHeap.extractMax());
    }
}
