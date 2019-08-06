package com.smdev.algorithm;

import java.util.Arrays;

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
