---
layout: default
title: Arrays
parent: Home
nav_order: 100
description: "Arrays & ArrayLists"
permalink: /arrays
---

# Data Structures & Algorithms
{: .fs-9 }

Each design pattern offers a reusable solution for a for common (repeatable) design problem. 
{: .fs-6 .fw-300 }

[Get started now](#data-structures-vs-apis){: .btn .btn-primary .fs-5 .mb-4 .mb-md-0 .mr-2 } [View examples on GitHub](https://github.com/Iretha/data-structures-and-algorithms){: .btn .fs-5 .mb-4 .mb-md-0 }

---



# Array (DS) & ArrayList(API)

[Source Code]()

## Array
* They can contain everything: **primitives** & wrappers, objects, custom types; 
* Arrays have FIXED size, that means that they can't grow
* Random access to elements - you can use the index to access any element at any time; 
* **The access to any element of the array (get/ set) by index is a constant time O(1), which is extremely fast**

## ArrayList (Dynamic Arrays)
The internal implementation of the ArrayList uses an array.

* They can contain: wrappers, objects, custom types; 
* They have initial capacity (of 10 elements) and can grow dynamically
* Random access to elements - you can use the index to access any element at any time;
* **The access to any element of the array (get/ set) by index is a constant time O(1), which is extremely fast**
* To **insert** an element at specific position, we need to:
    * shift all elements from the given position to the right, so that we make room for the new element
    * copy the element at the position
    * increase the size by 1

It takes linear time O(N) to do the insert, where N depends on the number of the elements
* To **delete** an element at specific position, we need to:
    * delete the element at the position
    * shift all elements from the position + 1 to left, so that we don't leave empty spots
    * decrease the size by 1

It takes linear time O(N) to do the delete, where N depends on the number of the elements

access(get/ set)|insert|delete
---|---|---
O(1)|O(N)|O(N)
fast|not fast|not fast

### Capacity vs Size (Length)
As we said, the internal implementation of the ArrayList uses an array and arrays have fixed size.
The capacity is the size of the internal array, that will hold the elements, when we add them.
This means that the capacity of the ArrayList shows the number of the elements the list can contain. 
The size (length) of the ArrayList shows the actual count of the elements, that are already added to it.

### What's the initial capacity of an ArrayList?
When a new ArrayList is created, its default capacity is 10.
```java
List<String> list = new ArrayList<>(); // capacity = 10
```
You may also specify the initial capacity, when you know the number of elements to prevent it from growing while adding elements.
```java
 List<String> list = new ArrayList<>(300);
```
Implementations also may differ.

### How ArrayLists grow?
When you add elements and if there is not enough capacity (free spots for more elements to be added), 
a new array is created with double capacity (2 * 10 = 20) and all elements are copied to the new array.
If you add more elements, new array will be created with double capacity (2 * 20 = 40) and so on...
That's why adding an element has constant **amortized** time cost.

### Simple Implementation
* get(idx) - returns the element at the given position
* set(idx, obj) - replaces the element at the given position
* insert(idx, obj) - inserts element at the given position
* add(obj) - adds element at the end
* remove(idx) - removes element at given position

```java
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
```


