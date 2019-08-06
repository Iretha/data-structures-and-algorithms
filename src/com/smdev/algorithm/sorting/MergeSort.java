package com.smdev.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int midIdx = arr.length / 2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, midIdx));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, midIdx, arr.length));
        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] merged = new int[len1 + len2];

        int pointer1 = 0;
        int pointer2 = 0;
        int idx = 0;
        while (pointer1 < len1 && pointer2 < len2) {// both arrays still have elements
            if (arr1[pointer1] < arr2[pointer2]) {
                merged[idx++] = arr1[pointer1++];
            } else if (arr2[pointer2] < arr1[pointer1]) {
                merged[idx++] = arr2[pointer2++];
            } else {
                // copy only 1 value here if you want to remove the duplicates
                merged[idx++] = arr1[pointer1++];
                merged[idx++] = arr2[pointer2++];
            }
        }

        while (pointer1 < len1 && pointer2 >= len2) {// arr1 still has elements
            merged[idx++] = arr1[pointer1++];
        }

        while (pointer2 < len2 && pointer1 >= len1) {// arr2 still has elements
            merged[idx++] = arr2[pointer2++];
        }
        return merged;
    }
}
