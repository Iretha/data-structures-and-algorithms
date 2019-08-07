---
layout: default
title: Quick Sort
parent: Algorithms (Sorting)
nav_order: 250
description: "Quick Sort"
permalink: /quick-sort
---
# Quick Sort
{: .fs-9 }

Quicksort is a sorting algorithm and also known as a Partion-Exchange Sort in which
partition is carried out dynamically. Quicksort is a comparision sort and is popular because works well 
for a variety of different kinds of input data, and is substantially faster than any other sorting method in typical applications.
{: .fs-6 .fw-300 }
---

## Description
The three "main" steps of quicksort are:
Divide: Rearrange the elements and partition the array into two partitions such that each element
on the left partition is less than or equal to the middle element and each element in the right
partition is greater than the middle element.
Conquer: Recursively sort the two partitions.
Combine: None.

### Steps:

1). Pick a pivot for the round and move it to the mid position

The best way to choose a pivot is to select the median number between the first/ mid and last element.
This is great performance boost when the array is already sorted or nearly sorted.

This is done as follows:
- Compare first and last, swap if first is larger than last.
- Compare first and mid, swap if first is larger than last.
- Compare last and mid, swap if mid is larger than last.

And now, mid is the pivot number as it is the median number as well.
```
[4,2,6,5,3,9] -> [4, 5, 9] -> the median is 5
[4,2,10,9,3,2] -> [4, 9, 2] -> [2, 9, 4] -> [2, 4, 9] -> the median is 4
```

2). Partition the array around the pivot and return the index of the partition

We will "partition" the array in two partitions and move all numbers, that are less than the pivot
to the left partition and all the numbers, that are larger than the pivot to the right partition.

This is done as follows:

2.1). Init the left pointer, that should start from the first element of the array and should move to right (left++)

2.2). Init the right pointer, that should start from the last element of the array and should move to left (right--)

2.3). While the left pointer is less or equal than the right pointer (left <= right), because they didn't met yet, do:

2.3.1). While the element at arr[left] is less than the pivot, it means it's on the right place and we want to leave it there, 
that's why we continue moving left pointer to the right (left++). If you find a number, that is bigger than the pivot, 
then stop the pointer and wait (we need to find a number from the right side as well, so that we can swap both numbers).

2.3.2). While the element at arr[right] is larger than the pivot, it means it's on the right place and we want to leave it there, 
that's why we continue moving right pointer to the left (right--). If you find a number, that is less than the pivot, 
then stop the pointer.

2.3.3). If left is still less or if it's equal to right (left < right), then swap the values, located on "left" and "right"
and then increase both pointers (left++ / right--)

2.3.4). Continue until both pointers hit the same index (left == right)

2.3.5). Return the index, where they met. When we are at this point, the left pointer is equal to the right pointer and you can return any of them.
At this point we "know" that all numbers in the right partition are larger then the numbers in the left partition and vice versa.

3). Repeat step 1 and 2 for the left partition
```
quickSort(arr, left, index - 1);
```
4). Repeat step 1 and 2 for the right partition
```
quickSort(arr, index, right);
```

### Strategies to choose a pivot:
* First element - poor performance for sorted or nearly sorted
* Last element - poor performance for sorted or nearly sorted
* Median number - best way
* Random element - unpredictable

## Runtime Characteristics
Relatively fast - O(nlog(n))

## Pros
* Very efficient for large data sets - O(nlogn)
* Best choice if speed is the primary focus
* Also well used for massively repetitive sorting
* Doesn't take additional memory because the elements are swapped inside the same array (in-place sorting) and
no new arrays are created or no elements are copied

## Cons
* Not good for small or semi-ordered lists
* Not a stable sort (the relative order of equal sort items is not preserved)
* Poor performance for sorted or almost sorted data sets

## Usage
* Uniqueness Testing
* Deleting Duplicates
* Frequency Counting
* Efficient Searching

## Implementation
```java
public class QuickSortPivotMedian {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {  // we reached the end
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

            if (left < right) { // Swap
                swapValues(arr, left, right);
            }

            left++;
            right--;
        }
        return left;
    }

    /**
     * For best performance compare first, mid and last and pick the median number as a pivot
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
```
## Example
```java
Initial: [9, 1, 6, 2, 5, 3, 7]
Step 1:[7, 1, 6, 2, 5, 3, 9]
Step 2:[2, 1, 6, 7, 5, 3, 9]
Step 3:[2, 1, 6, 3, 5, 7, 9]
Step 4:[2, 1, 5, 3, 6, 7, 9]
Step 5:[2, 1, 3, 5, 6, 7, 9]
Step 6:[1, 2, 3, 5, 6, 7, 9]
Sorted:  [1, 2, 3, 5, 6, 7, 9]
```

