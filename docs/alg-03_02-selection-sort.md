---
layout: default
title: Selection Sort
parent: Elementary Sorting
nav_order: 235
description: "Selection Sort"
permalink: /selection-sort
---
# Selection Sort (Elementary Sorting)
{: .fs-9 }

Very slow sorting algorithm, that does in-place sorting (sorts the array itself
) and does
not generate additional instances. The best, worst & avg. time complexity is O
(N^2), which is VERY slow! 
{: .fs-6 .fw-300 }
---

## Description
Scanning for the smallest item and placing it on the first position.
On the next iteration, starting from the second position, scanning for the
 second smallest item and so on until we reach the last position.
 
- Worse than Bubble Sort & Insertion Sort
- Prefer Insertion Sort over Selection Sort

## Runtime Characteristics
  * Time Complexity O(N^2) - best, avg. and worst case scenario
  * Space Complexity O(1) - inline sorting

## Pros
- In-place sorting, does not generate new objects (no additional memory usage)

## Cons
- Very slow
- Not appropriate for large data sets
- Prefer Insertion Sort from the Elementary Sorting algorithms

## Properties
* O(1) extra space
* O(n^2) comparisons and swaps
* Non-Adaptive: O(N^2) even when nearly sorted
* Not-Stable by default, but depending on the implementation can be made
 stable 
 
## Usage
- Not used in practise, because of it's runtime

## Implementation
```java
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
```

## Useful Links

[Cool Animations from Toptal](https://www.toptal.com/developers/sorting-algorithms)

[Selection Sort in Wikipedia](https://en.wikipedia.org/wiki/Selection_sort)

[Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/selection-sort)