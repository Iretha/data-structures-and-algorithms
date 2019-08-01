package com.smdev.datastructures;

import java.util.Arrays;

public class DynamicArray<T extends Object> {

    private static final int INITIAL_CAPACITY = 10;

    private Object[] elements;

    private int length = 0;

    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length < 1;
    }

    public T get(int pos) {
        if (pos < 0 || pos > this.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        return (T) this.elements[pos];
    }

    public void set(int pos, T o) {
        if (pos < 0 || pos > this.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.elements[pos] = o;
    }

    public void insert(int pos, T o) {
        if (pos < 0 || pos > this.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        ensureCapacity();
        for (int i = this.length - 1; i >= pos; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[pos] = o;
        this.length++;
    }

    public void add(T o) {
        insert(this.length, o);
    }

    public void remove(int pos) {
        if (pos < 0 || pos > this.length) {
            throw new IllegalArgumentException("Invalid position");
        }

        for (int i = pos; i < this.length - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.length - 1] = null;
        this.length--;
    }

    private void ensureCapacity() {
        if (this.length == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
        }
    }
}
