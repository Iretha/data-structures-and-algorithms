---
layout: default
title: Merge Sort
parent: Algorithms (Sorting)
nav_order: 241
description: "Merge Sort"
permalink: /merge-sort
---
# Merge Sort (Divide and Conquer)
{: .fs-9 }

Divide and Conquer type of algorithms. We split the array into two sub-arrays until you reach the smallest possible sub-arrays (from 1 element), then merge them back, while sorting.
The Time Complexity is O(N log(N), which is relatively fast.

    !!! Divide and Conquer ==> Recursion !!!
{: .fs-6 .fw-300 }
---

## Description
You split the array in halves until you reach the smallest possible sub
-arrays, then merge them back, while ordering elements from min to max.

### Steps:
MergeSort(arr[], l,  r)
If r > l
1. Find the middle of the array: m = (l+r)/2
2. Invoke mergeSort(arr, l, m) for the first half
3. Invoke mergeSort(arr, l, m) for the second half
4. Merge them back, while ordering elements from min to max.

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
* Θ(log(n)) extra space for linked lists
* Θ(n·log(n)) time
* Not adaptive - time complexity does not improve under special conditions
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