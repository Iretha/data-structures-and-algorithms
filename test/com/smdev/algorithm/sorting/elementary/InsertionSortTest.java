package com.smdev.algorithm.sorting.elementary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest extends BaseSort {

    @Override
    protected int[] sort(int[] array) {
        //return InsertionSort.insertionSort(array);
        return InsertionSort.sort(array);
    }

    @Test
    public void testSort() {
        //Assertions.assertArrayEquals(new int[]{1, 2, 3}, sort(new int[]{3, 2, 1}));
        //Assertions.assertArrayEquals(new int[]{1, 2, 3}, sort(new int[]{1, 2, 3}));
        //Assertions.assertArrayEquals(new int[]{1, 2, 3}, sort(new int[]{3, 1, 2}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, sort(new int[]{2, 3, 1}));
    }

}
