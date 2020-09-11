package com.smdev.algorithm.sorting.elementary;

public class SelectionSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int currMinIdx;
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            currMinIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[currMinIdx]){
                    currMinIdx = j;
                }
            }
            if(currMinIdx > 0){
                tmp = arr[i];
                arr[i] = arr[currMinIdx];
                arr[currMinIdx] = tmp;
            }
        }
        return arr;
    }
}
