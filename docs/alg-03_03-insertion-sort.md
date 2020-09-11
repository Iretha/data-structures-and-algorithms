---
layout: default
title: Insertion Sort
parent: Elementary Sorting Algorithms
nav_order: 237
description: "Insertion Sort"
permalink: /insertion-sort
---
# Insertion Sort (Elementary Sorting)
{: .fs-9 }
This is the preferable sorting algorithm from all elementary sorting algorithms.

Relatively slow, but better than Bubble Sort & Selection Sort, that does in
-place sorting (sorts the array itself) and does
not generate additional instances. The avg. time complexity is O(N^2), which
 is slow, but the time complexity of nearly sorted arrays is close to O(N).
{: .fs-6 .fw-300 }
---

## Description
Start with the first element and compare with the next one, if it's larger than
 the second, then swap their places. Go with the third element, if less than the
  second, leave it where it is. Then go with the fourth element, if larger than
   the third, leave where it is, otherwise compare with the elements left of
    the third and swap until you find the right place.

## Runtime Characteristics
2 embedded loops => time complexity is O(N^2)

## Pros
* Fast for VERY small data sets
* Inline sorting with space compexity of O(1) => Use when you have very
 limited space
* Fast when elements are nearly sorted => time complexity can be close to O(N)
* Better than Bubble Sort and Selection Sort

## Cons
- You should prefer more advanced algorithms instead of this one, unless you
 have nearly sorted small data set
- Not appropriate for large data sets

## Properties
* Stable
* O(1) extra space
* O(n^2) comparisons and swaps
* Adaptive: O(n) when nearly sorted

## Uses
- Insertion sort is used when number of elements is small. 
- It can also be useful when input array is almost sorted, only few elements
 are misplaced in complete big array

## Implementation
```java
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
```

## Useful Links

[Very Cool Animations from Toptal](https://www.toptal.com/developers/sorting-algorithms)

[Insertion Sort in Wikipedia](https://en.wikipedia.org/wiki/Insertion_sort)

[Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/tutorial/)