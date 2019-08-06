package com.smdev.algorithm.sorting;

public class QuickSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) { // we reached the end
            return;
        }

        // Step 1: Pick a pivot
        int pivot = pickPivot(arr, left, right);

        // Step 2: Partition the array around this pivot - return the index of the partition
        int index = partition(arr, left, right, pivot);

        // Step 3: Repeat for the left partition
        quickSort(arr, left, index - 1);

        // Step 4: Repeat for the right partition
        quickSort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            // Move right until you find an element bigger than the pivot
            while (arr[left] < pivot) {
                left++;
            }

            // Move left until you find an element less than the pivot
            while (arr[right] > pivot) {
                right--;
            }

            // Then swap
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * For best performance compare first, mid and last and pick the medium number as a pivot
     */
    private static int pickPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }

        if (arr[left] > arr[mid]) {
            swap(arr, mid, left);
        }

        if (arr[right] < arr[mid]) {
            swap(arr, mid, right);
        }
        return arr[mid];
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }
}
