package com.smdev.algorithm.sorting.elementary;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }

        int maxLen = arr.length;
        int tmp;
        while (maxLen > 1) {
            for (int i = 1; i < maxLen; i++) {
                if (arr[i - 1] > arr[i]) {
                    tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
            maxLen--;
        }
        return arr;
    }

    public static int[] sort0(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }

        int tmp;
        int n = arr.length - 1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;

                    System.out.println(Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
}
