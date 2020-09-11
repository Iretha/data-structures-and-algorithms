package com.smdev.algorithm.sorting.elementary;

public class InsertionSort {

    public static int[] sort(int[] arr) {
        int tmp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        return arr;
    }


    public static int[] sort0(int[] arr) {
        int tmp;
        int j;
        for (int i = 0; i < arr.length - 1; i++) {
            j = i;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                tmp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int temp = A[i];
            int j = i;
            while (j > 0 && temp < A[j - 1]) {
                A[j] = A[j - 1];
                j = j - 1;

            }
            A[j] = temp;
        }
        return A;
    }

}
