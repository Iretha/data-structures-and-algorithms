package com.smdev.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void testSort() {
        int[] array = {5, 1, 4, 2, 8};
        System.out.println("Initial: " + Arrays.toString(array));

        int[] sorted = bubbleSort.sort(array);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assert.assertEquals(1, sorted[0]);
        Assert.assertEquals(2, sorted[1]);
        Assert.assertEquals(4, sorted[2]);
        Assert.assertEquals(5, sorted[3]);
        Assert.assertEquals(8, sorted[4]);
    }

}
