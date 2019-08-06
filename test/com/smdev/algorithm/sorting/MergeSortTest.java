package com.smdev.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void testSort() {
        int[] array = {5, 1, 4, 2, 8};
        System.out.println("Initial: " + Arrays.toString(array));

        int[] sorted = MergeSort.mergeSort(array);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assert.assertEquals(1, sorted[0]);
        Assert.assertEquals(2, sorted[1]);
        Assert.assertEquals(4, sorted[2]);
        Assert.assertEquals(5, sorted[3]);
        Assert.assertEquals(8, sorted[4]);
    }

    @Test
    public void testSort2() {
        int arr[] = {4, 7, 14, 1, 3, 9, 17};
        System.out.println("Initial: " + Arrays.toString(arr));

        int[] sorted = MergeSort.mergeSort(arr);
        System.out.println("Sorted:  " + Arrays.toString(sorted));

        Assert.assertEquals(1, sorted[0]);
        Assert.assertEquals(3, sorted[1]);
        Assert.assertEquals(4, sorted[2]);
        Assert.assertEquals(7, sorted[3]);
        Assert.assertEquals(9, sorted[4]);
        Assert.assertEquals(14, sorted[5]);
        Assert.assertEquals(17, sorted[6]);
    }

}
