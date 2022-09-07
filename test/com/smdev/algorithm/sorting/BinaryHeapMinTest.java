package com.smdev.algorithm.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryHeapMinTest {

    private BinaryHeapMin minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new BinaryHeapMin();
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
    }

    @Test
    void testInsert() {
        int idx = 0;
        Assertions.assertEquals(1, minHeap.getByIndex(idx++));
        Assertions.assertEquals(3, minHeap.getByIndex(idx++));
        Assertions.assertEquals(2, minHeap.getByIndex(idx++));
        Assertions.assertEquals(6, minHeap.getByIndex(idx++));
        Assertions.assertEquals(4, minHeap.getByIndex(idx++));
        Assertions.assertEquals(5, minHeap.getByIndex(idx++));
    }

    @Test
    void testExtractMin() {
        Assertions.assertEquals(1, minHeap.extractMin());
        Assertions.assertEquals(2, minHeap.extractMin());
        Assertions.assertEquals(3, minHeap.extractMin());
        Assertions.assertEquals(4, minHeap.extractMin());
        Assertions.assertEquals(5, minHeap.extractMin());
        Assertions.assertEquals(6, minHeap.extractMin());
    }
}
