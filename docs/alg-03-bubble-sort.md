---
layout: default
title: Bubble Sort
parent: Algorithms (Sorting)
nav_order: 230
description: "Bubble Sort"
permalink: /bubble-sort
---
# Bubble Sort
{: .fs-9 }

Relatively slow sorting algorithm, that does in-place sorting (sorts the array itself) and does
not generate additional instances. The avg. time complexity is O(N^2), which is slow! 
{: .fs-6 .fw-300 }
---

## Description
Start from the beginning (index=0), compare the element with the next, if it's larger than next => swap positions, 
if it's not, then proceed with the next element. At the end of the first iteration, the largest element will be placed at the last position.
At the end of the second iteration, the second largest element will be placed (on the last position -1) and so
on until we hit the first position, where should be the MIN element.

## Runtime Characteristics
2 embedded loops => time complexity is O(N^2)

## Pros
- In-place sorting, does not generate new objects (no additional memory usage)
- The fastest on an extremely small and/or nearly sorted set of data

## Cons
- No really fast
- Not appropriate for large data sets

## Usage
- Not used in practise, because of it's runtime except the cases of very small amount of data, 
that is almost sorted

## Implementation
```java
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }

        int tmp;
        int n = arr.length - 1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;
                }
            }
        }
        return arr;
    }
```
## Example
```java
Initial: [9, 1, 6, 2, 5, 3, 7]
[1, 9, 6, 2, 5, 3, 7]
[1, 6, 9, 2, 5, 3, 7]
[1, 6, 2, 9, 5, 3, 7]
[1, 6, 2, 5, 9, 3, 7]
[1, 6, 2, 5, 3, 9, 7]
[1, 6, 2, 5, 3, 7, 9]
[1, 2, 6, 5, 3, 7, 9]
[1, 2, 5, 6, 3, 7, 9]
[1, 2, 5, 3, 6, 7, 9]
[1, 2, 3, 5, 6, 7, 9]
Sorted:  [1, 2, 3, 5, 6, 7, 9]
```
