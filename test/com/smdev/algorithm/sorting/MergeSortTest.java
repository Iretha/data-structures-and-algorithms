package com.smdev.algorithm.sorting;

import com.smdev.algorithm.sorting.elementary.BaseSort;

public class MergeSortTest extends BaseSort {

    @Override
    protected int[] sort(int[] arr) {
        return MergeSort.sort(arr);
    }

}
