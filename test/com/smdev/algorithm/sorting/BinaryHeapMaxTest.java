package com.smdev.algorithm.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryHeapMaxTest {

    private BinaryHeapMax maxHeap;

    @Test
    void testInsert() {
        maxHeap = new BinaryHeapMax();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);
        maxHeap.insert(35);

        // Test insert
        Assertions.assertEquals(42, maxHeap.getByIndex(0));
        Assertions.assertEquals(35, maxHeap.getByIndex(1));
        Assertions.assertEquals(18, maxHeap.getByIndex(2));
        Assertions.assertEquals(29, maxHeap.getByIndex(3));
    }

    @Test
    void testExtractMax() {
        maxHeap = new BinaryHeapMax();
        maxHeap.insert(42);
        maxHeap.insert(29);
        maxHeap.insert(18);

        // Insert(35)
        maxHeap.insert(35);

        // Test insert
        Assertions.assertEquals(42, maxHeap.getByIndex(0));
        Assertions.assertEquals(35, maxHeap.getByIndex(1));
        Assertions.assertEquals(18, maxHeap.getByIndex(2));
        Assertions.assertEquals(29, maxHeap.getByIndex(3));

        // Text extract max
        Assertions.assertEquals(42, maxHeap.extractMax());
        Assertions.assertEquals(35, maxHeap.extractMax());
        Assertions.assertEquals(29, maxHeap.extractMax());
        Assertions.assertEquals(18, maxHeap.extractMax());

//        maxHeap.print();
    }

    @Test
    void testExtractMaxBigger() {
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

        Assertions.assertEquals(42, maxHeap.extractMax());
        Assertions.assertEquals(29, maxHeap.extractMax());
        Assertions.assertEquals(18, maxHeap.extractMax());
        Assertions.assertEquals(18, maxHeap.extractMax());
        Assertions.assertEquals(14, maxHeap.extractMax());
        Assertions.assertEquals(13, maxHeap.extractMax());
        Assertions.assertEquals(12, maxHeap.extractMax());
        Assertions.assertEquals(11, maxHeap.extractMax());
        Assertions.assertEquals(7, maxHeap.extractMax());
    }
}
