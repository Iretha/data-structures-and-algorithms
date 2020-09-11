package com.smdev.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] leftArr = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeArrays(leftArr, rightArr);
    }

    private static int[] mergeArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (idx1 == a1.length) { // copy a2
                while (i < merged.length) {
                    merged[i] = a2[idx2];
                    i++;
                    idx2++;
                }
            } else if (idx2 == a2.length) { // copy a1
                while (i < merged.length) {
                    merged[i] = a1[idx1];
                    i++;
                    idx1++;
                }
            } else {
                if (a1[idx1] < a2[idx2]) {
                    merged[i] = a1[idx1];
                    idx1++;
                } else {
                    merged[i] = a2[idx2];
                    idx2++;
                }
            }
        }
        return merged;
    }


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

        System.out.println("Merged: " + Arrays.toString(merged));
        return merged;
    }
}
