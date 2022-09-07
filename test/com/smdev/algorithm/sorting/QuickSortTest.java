package com.smdev.algorithm.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSortTest {

    @Test
    void testSort() {
        int[] array = {5, 1, 4, 2, 8};
        System.out.println("Initial: " + Arrays.toString(array));

        int[] sorted = QuickSortPivotMedian.sort(array);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assertions.assertEquals(1, sorted[0]);
        Assertions.assertEquals(2, sorted[1]);
        Assertions.assertEquals(4, sorted[2]);
        Assertions.assertEquals(5, sorted[3]);
        Assertions.assertEquals(8, sorted[4]);
    }

    @Test
    void testSort2() {
        int[] arr = {4, 7, 14, 1, 3, 9, 17};
        System.out.println("Initial: " + Arrays.toString(arr));

        int[] sorted = QuickSortPivotMedian.sort(arr);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assertions.assertEquals(1, sorted[0]);
        Assertions.assertEquals(3, sorted[1]);
        Assertions.assertEquals(4, sorted[2]);
        Assertions.assertEquals(7, sorted[3]);
        Assertions.assertEquals(9, sorted[4]);
        Assertions.assertEquals(14, sorted[5]);
        Assertions.assertEquals(17, sorted[6]);
    }

    @Test
    void testSort3() {
        int[] arr = {9, 1, 6, 2, 5, 3, 7};
        System.out.println("Initial: " + Arrays.toString(arr));

        int[] sorted = QuickSortPivotMedian.sort(arr);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assertions.assertEquals(1, sorted[0]);
        Assertions.assertEquals(2, sorted[1]);
        Assertions.assertEquals(3, sorted[2]);
        Assertions.assertEquals(5, sorted[3]);
        Assertions.assertEquals(6, sorted[4]);
        Assertions.assertEquals(7, sorted[5]);
        Assertions.assertEquals(9, sorted[6]);
    }
}
