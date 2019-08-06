---
layout: default
title: Binary Heap/ HeapSort
parent: Sorting Algorithms
nav_order: 220
description: "Binary Heap"
permalink: /binary-heap
---
# Binary Heap
{: .fs-9 }

Binary Heap is another type of binary tree, that allows duplicated keys. 
It supports supper fast search and extraction of the MIN/MAX value, which has time complexity of O(1).
{: .fs-6 .fw-300 }
---

The Binary Heap (HeapSort) is an example of a Complete Binary Tree (all levels are completely filled, except possibly the last level).
It represents a sorting algorithm.

## Types of Binary Trees
There are two types of binary heaps. Trees, which root holds the MAX value or the MIN value.

### Binary Heap MAX 
If it's a binary heap max, then the max value is the root value. The rule is that the value
of the children must be the same or less than the value of the parent. This means that the 
highest values are closer to top, while lowest values are located at the bottom levels.

### Binary Heap MIN 
If it's a binary heap min, then the min value is the root value. The rule is that the value
of the children must be the same or bigger than the value of the parent. This means that the 
lowest values are closer to top, while the highest values are located at the bottom levels.

## How are they implemented?
The most common way is to implement them as an array, with elements ordered in breadth first order, 
starting from the root. The root is always the first element of the array:
```
     42
     /\
  29    18
  /\    /\
 14 7 18 12
 /\
11 13
```
Will become: arr[42, 29, 18, 14, 7, 18, 12, 11, 13]

Then, we can extract the nodes with this formulas:
* parent - arr[(i-1)/2] returns the parent node
* left child - arr[(2*i)+1] returns the left child node
* right child - arr[(2*i)+2] returns the right child node

## How is the insert implemented?
1). First, we add the element at the very end of the array
2). We need to perform a **heapify up** operation. "Heapify up" means that we compare it with it's parent.
MAX HEAP: If it's bigger, we swap it with its' parent and we move up, until we reach the root. If it's smaller, we
leave it wherever it is.
MIN HEAP: If it's smaller, we swap it with it's parent and proceed further until we reach the root. If it's not, we 
leave it on its place.

## How to extract MAX, resp. MIN?
1). We swap the top and the most bottom node, then we start from top (root) and go to bottom (leaves). 
2). We need to perform a **heapify down** operation. "Heapify down" means that we compare the value with its children
and swap it with the larger(MAX) / lowest (MIN) of them, then proceed further with the next children until we reach the end 
or the children values are lower (MAX) / larger (MIN) than the value of the parent node.

## MIN & MAX binary heaps are used to:
* Find/ Extract MIN/MAX value, which is O(1)

## Usage
Binary heaps are very common. The algorithm is used for Routers, Shortest Path, Priority Queues, Scheduling,
Kernel Process Scheduling. Another important point is that Binary Heaps allow duplicates. 

## Binary Heap vs Binary Search Tree
The difference with the BST is that the elements are not sorted, not unique and the left child value is not necessary 
less than the value of the right child. A parent node of a Binary Heap MAX tree must have same or higher value 
than it's children and same of less value if it's a Binary Heap MIN tree.

## Example Implementation of Binary Heap MAX
```java
public class BinaryHeapMax {

    private static final int INITIAL_CAPACITY = 10;

    private int[] items;
    private int size = 0;

    public BinaryHeapMax() {
        this(INITIAL_CAPACITY);
    }

    public BinaryHeapMax(int capacity) {
        this.items = new int[capacity];
    }

    public void insert(int value) {
        ensureCapacity();

        //1. put the element at the bottom (as last element in the arr)
        int itemIdx = this.size;
        this.items[itemIdx] = value;
        this.size++;

        //2. heapify up = start from bottom and proceed to top
        heapifyUp(itemIdx);
    }

    private void heapifyUp(int itemIdx) {
        int parentIdx = getParentIdx(itemIdx);
        while (parentIdx >= 0) {
            if (this.items[itemIdx] <= this.items[parentIdx]) {
                break;
            }

            swap(parentIdx, itemIdx);

            itemIdx = parentIdx;
            parentIdx = getParentIdx(itemIdx);
        }
    }

    private void ensureCapacity() {
        if (this.size < this.items.length) {
            return;
        }
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    public int getMax() {
        return getByIndex(0);
    }

    public int getByIndex(int idx) {
        if (this.items == null || idx < 0 || idx > (this.size - 1)) {
            return -1;
        }
        return this.items[idx];
    }

    public int extractMax() {
        if (this.items == null) {
            throw new IllegalArgumentException();
        }

        int max = this.items[0];
        if (this.size == 1) {
            this.items[0] = 0;
        } else {
            //1. swap top and bottom node
            swap(0, this.size - 1);

            //2. remove bottom node
            this.items[this.size - 1] = 0;
            this.size--;

            //3. heapify down =  start from top
            heapifyDown(0);
        }
        return max;
    }

    private void heapifyDown(int itemIdx) {
        int largerChildIdx;
        while (indexExists(getLeftChild(itemIdx))) {
            largerChildIdx = getIdxOfTheLarger(getLeftChild(itemIdx), getRightChild(itemIdx));
            if (this.items[itemIdx] > this.items[largerChildIdx]) {
                break;
            } else {
                swap(itemIdx, largerChildIdx);
                itemIdx = largerChildIdx;
            }
        }
    }

    private void swap(int idx1, int idx2) {
        int tmp = this.items[idx1];
        this.items[idx1] = this.items[idx2];
        this.items[idx2] = tmp;
    }

    private int getParentIdx(int itemIdx) {
        if (itemIdx == 0) {
            return -1; // no parent
        }
        return ((itemIdx - 1) / 2);
    }

    private int getLeftChild(int itemIdx) {
        return (2 * itemIdx) + 1;
    }


    private int getRightChild(int itemIdx) {
        return (2 * itemIdx) + 2;
    }

    private int getIdxOfTheLarger(int leftIdx, int rightIdx) {
        if (indexExists(rightIdx)) {
            return this.items[leftIdx] > this.items[rightIdx] ? leftIdx : rightIdx;
        }
        return leftIdx;
    }

    private boolean indexExists(int idx) {
        return idx < this.size;
    }
}
```
## Example Implementation of Binary Heap MIN
```java
public class BinaryHeapMin {

    private static final int INITIAL_CAPACITY = 10;

    private int[] items;
    private int size = 0;

    public BinaryHeapMin() {
        this(INITIAL_CAPACITY);
    }

    public BinaryHeapMin(int capacity) {
        this.items = new int[capacity];
    }

    public void insert(int value) {
        ensureCapacity();

        //1. put the element at the bottom (as last element in the arr)
        int itemIdx = this.size;
        this.items[itemIdx] = value;
        this.size++;

        //2. heapify up = start from bottom and proceed to top
        heapifyUp(itemIdx);
    }

    private void heapifyUp(int itemIdx) {
        int parentIdx = getParentIdx(itemIdx);
        while (parentIdx >= 0) {
            if (this.items[itemIdx] >= this.items[parentIdx]) {
                break;
            }

            swap(parentIdx, itemIdx);

            itemIdx = parentIdx;
            parentIdx = getParentIdx(itemIdx);
        }
    }

    private void ensureCapacity() {
        if (this.size < this.items.length) {
            return;
        }
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    public int getMin() {
        return getByIndex(0);
    }

    public int getByIndex(int idx) {
        if (this.items == null || idx < 0 || idx > (this.size - 1)) {
            return -1;
        }
        return this.items[idx];
    }

    public int extractMin() {
        if (this.items == null) {
            throw new IllegalArgumentException();
        }

        int min = this.items[0];
        if (this.size == 1) {
            this.items[0] = 0;
        } else {
            //1. swap top and bottom node
            swap(0, this.size - 1);

            //2. remove bottom node
            this.items[this.size - 1] = 0;
            this.size--;

            //3. heapify down =  start from top
            heapifyDown(0);
        }
        return min;
    }

    private void heapifyDown(int itemIdx) {
        int smallerChildIdx;
        while (indexExists(getLeftChild(itemIdx))) {
            smallerChildIdx = getIdxOfTheSmaller(getLeftChild(itemIdx), getRightChild(itemIdx));
            if (this.items[itemIdx] < this.items[smallerChildIdx]) {
                break;
            } else {
                swap(itemIdx, smallerChildIdx);
                itemIdx = smallerChildIdx;
            }
        }
    }

    private void swap(int idx1, int idx2) {
        int tmp = this.items[idx1];
        this.items[idx1] = this.items[idx2];
        this.items[idx2] = tmp;
    }

    private int getParentIdx(int itemIdx) {
        if (itemIdx == 0) {
            return -1; // no parent
        }
        return ((itemIdx - 1) / 2);
    }

    private int getLeftChild(int itemIdx) {
        return (2 * itemIdx) + 1;
    }


    private int getRightChild(int itemIdx) {
        return (2 * itemIdx) + 2;
    }

    private int getIdxOfTheSmaller(int leftIdx, int rightIdx) {
        if (indexExists(rightIdx)) {
            return this.items[leftIdx] < this.items[rightIdx] ? leftIdx : rightIdx;
        }
        return leftIdx;
    }

    private boolean indexExists(int idx) {
        return idx < this.size;
    }
}
```





