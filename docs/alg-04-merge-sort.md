---
layout: default
title: Merge Sort
parent: Algorithms (Sorting)
nav_order: 240
description: "Merge Sort"
permalink: /merge-sort
---
# Merge Sort
{: .fs-9 }

You split the array in halves until you reach the smallest possible sub-arrays, then merge them back, while sorting.
{: .fs-6 .fw-300 }
---

# Description
It's "Divide & Conquer" type of algorithm.

You split the array in halves until you reach the smallest possible sub-arrays, then merge them back.

Steps:
MergeSort(arr[], l,  r)
If r > l
1. Find the middle of the array: m = (l+r)/2
2. Invoke mergeSort(arr, l, m) for the first half
3. Invoke mergeSort(arr, l, m) for the second half
4. Merge them

# Runtime Characteristics
Relatively fast - O(nlog(n))

# Pros
* Pretty efficient sorting algorithm - O(n log(n))
* Can be used for external sorting (when memory is not enough, you may use external memory (like HDD or smth else))
* Highly parallelizeable
* Can be used to implement a stable sort

# Cons
* Requires extra space (as you are copying and duplicating arrays and it's content)

# Usage
* You can combine arrays and sort the elements or to remove duplicates
* For sorting Linked Lists
* Inversion Count Problem (to calculate how many inversions should be made to sort an array)
* **External sorting** - External sorting is a class of sorting algorithms that can handle massive amounts of data. 
External sorting is required when the data being sorted do not fit into the main memory of a computing device (usually RAM) 
and instead they must reside in the slower external memory, usually a hard disk drive. 

# Implementation
```java
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
```
