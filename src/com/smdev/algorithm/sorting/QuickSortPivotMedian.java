package com.smdev.algorithm.sorting;

import java.util.Arrays;

public class QuickSortPivotMedian {

    private static int stepCounter = 0;

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

    /**
     * Partition the array around the pivot and return the index of the partition
     * <p>
     * We will "partition" the array in two partitions and move all numbers, that are less than the pivot
     * to the left partition and all the numbers, that are larger than the pivot to the right partition.
     * <p>
     * This is done as follows:
     * 2.1). Init the left pointer, that should start from the first element of the array and should move to right (left++)
     * 2.2). Init the right pointer, that should start from the last element of the array and should move to left (right--)
     * 2.3). While the left pointer is less or equal than the right pointer (left <= right), because they hadn't met yet, do:
     * 2.3.1). While the element at arr[left] is less than the pivot, it means it's on the right place and we want to leave it there,
     * that's why we continue moving left pointer to the right (left++). If you find a number, that is bigger than the pivot,
     * then stop the pointer and wait (we need to find a number from the right side as well, so that we can swap both numbers).
     * 2.3.2). While the element at arr[right] is larger than the pivot, it means it's on the right place and we want to leave it there,
     * that's why we continue moving right pointer to the left (right--). If you find a number, that is less than the pivot,
     * then stop the pointer.
     * 2.3.3). If left is still less or if it's equal to right (left < right), then swap the values, located on "left" and "right"
     * and then increase both pointers (left++ / right--)
     * 2.3.4). Continue until both pointers meet (left == right)
     * 2.3.5). Return the index, where they met. When we are at this point, the left pointer is equal to the right pointer.
     * You can return any of them.
     */
    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) { // pointers hadn't met yet

            while (arr[left] < pivot) { // Move right until you find an element bigger than the pivot
                left++;
            }

            while (arr[right] > pivot) { // Move left until you find an element less than the pivot
                right--;
            }

            if (left < right) { // Swap
                swapValues(arr, left, right);
            }

            left++;
            right--;
        }
        return left; // return any of them (left==right), this is the index where they met each other.
    }

    /**
     * The best way to choose a pivot is to select the median number between the first/ mid and last element.
     * This is great performance boost when the array is already sorted or nearly sorted.
     * <p>
     * This is done as follows:
     * - Compare first and last, swap if first is larger than last.
     * - Compare first and mid, swap if first is larger than last.
     * - Compare last and mid, swap if mid is larger than last.
     */
    private static int pickPivot(int[] arr, int first, int last) {
        int mid = (first + last) / 2;

        if (arr[first] > arr[last]) {
            swapValues(arr, first, last);
        }

        if (arr[first] > arr[mid]) {
            swapValues(arr, mid, first);
        }

        if (arr[last] < arr[mid]) {
            swapValues(arr, mid, last);
        }
        return arr[mid]; // the pivot number
    }

    /**
     * Swap the values at the given positions
     */
    private static void swapValues(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;

        System.out.println("Step " + (++stepCounter) + ": " + Arrays.toString(arr));
    }
}
