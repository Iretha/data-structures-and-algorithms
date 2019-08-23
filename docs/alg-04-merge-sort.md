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

Divide and Conquer type of algorithms. We split the array into two sub-arrays until you reach the smallest possible sub-arrays (from 1 element), then merge them back, while sorting.
The Time Complexity is O(N log(N), which is relatively fast.
{: .fs-6 .fw-300 }
---

## Description
You split the array in halves until you reach the smallest possible sub-arrays, then merge them back.

### Steps:
MergeSort(arr[], l,  r)
If r > l
1. Find the middle of the array: m = (l+r)/2
2. Invoke mergeSort(arr, l, m) for the first half
3. Invoke mergeSort(arr, l, m) for the second half
4. Merge them back, while sorting

## Runtime Characteristics
Relatively fast - O(nlog(n))

## Pros
* Pretty efficient sorting algorithm - O(n log(n))
* Can be used for external sorting (when memory is not enough, you may use external memory (like HDD or smth else))
* Highly parallelizable
* Can be used to implement a stable sort

## Cons
* Requires extra space (as you are copying and duplicating arrays and it's content)

## Properties
* Stable
* Θ(n) extra space for arrays
* Θ(lg(n)) extra space for linked lists
* Θ(n·lg(n)) time
* Not adaptive
* Does not require random access to data

## Usage
* You can combine arrays and sort the elements or to remove duplicates
* For sorting Linked Lists
* Inversion Count Problem (to calculate how many inversions should be made to sort an array)
* **External sorting** - External sorting is a class of sorting algorithms that can handle massive amounts of data. 
External sorting is required when the data being sorted do not fit into the main memory of a computing device (usually RAM) 
and instead they must reside in the slower external memory, usually a hard disk drive. 

## Animations, illustrating the algorithm
![Merge sort steps](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif)

![Merge sort](https://upload.wikimedia.org/wikipedia/commons/e/e6/Merge_sort_algorithm_diagram.svg)

## Implementation
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
## Example
```
Initial: [9, 1, 6, 2, 5, 3, 7]
Merged: [1, 6]
Merged: [1, 6, 9]
Merged: [2, 5]
Merged: [3, 7]
Merged: [2, 3, 5, 7]
Merged: [1, 2, 3, 5, 6, 7, 9]
Sorted:  [1, 2, 3, 5, 6, 7, 9]
```

## Useful Links

[Very Cool Animations from Toptal](https://www.toptal.com/developers/sorting-algorithms/merge-sort)

[Merge Sort in Wikipedia](https://en.wikipedia.org/wiki/Merge_sort)

[Merge Sort Hackerearth Visualizer](https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/visualize/)