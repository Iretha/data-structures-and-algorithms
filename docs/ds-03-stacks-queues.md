---
layout: default
title: Stacks & Queues
parent: Data Structures
nav_order: 120
description: "Stacks & Queues"
permalink: /linked-lists
---
# Stacks & Queues
{: .fs-9 }
 
Stacks & Queues are very simple APIs, based on the LinkedList.
{: .fs-6 .fw-300 }
---

# Stack (LIFO - Last In First Out)
The stack represents a pile of things (a deck), where you can push (in) things on top and pop them out.

The stack is very simple API, based on Linked List. It has very few functions: 
* push (insert on top) - same as adding in front of the linked list
* pop (get the element from the top and **remove** it from the pile) - same as removing the first element of the linked list
* peek (get the element from the top, but **do not remove it** from the pile)
* isEmpty (checks if there are any elements)

Push/ pop/ peek/ isEmpty have constant time complexity  O(1).

# Queue (FIFO - First In First Out / First come, First served)
The queue represents a regular line, when first is served first. 

The differences between stack and queue is that queue also keeps a reference to the tail, not only head.
This makes adding to tail (in queue) as fast as adding to head (in stack). 

The queue is very simple API, based on Linked List. It has very few functions: 
* add (to tail / to end) - same as adding to the tail of the linked list (because the time should be 0(1), we need to keep reference to the tail as well)
* remove (from head) - same as removing the first element of the linked list
* peek (get the element from the head, but **do not remove it**)
* isEmpty (checks if there are any elements)

Add/ remove/ peek/ isEmpty have constant time complexity  O(1).

## Summary

ACCESS/ FIND|INSERT|DELETE
---|---|---
O(N)|O(1)|O(N)
linear| constant| linear
not that fast|ultra fast|not that fast

## Discussion

### Stack vs Queue
- Stack (LIFO) - add to tail, remove from tail - like a pile, add to top, remove from top
- Queue (FIFO) - add to tail, remove from head - as a line, add to end, remove from start
- insert and delete have constant time O(1)
- search through elements has linear time O(N) as we need to loop though all elements

### Simple Implementation of Stack
```java
public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public void push(T o) {
        Node node = new Node(o);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public T pop() {
        if (this.head == null) {
            return null;
        }

        T data = (T) this.head.data;
        this.head = this.head.next;

        this.size--;
        return data;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }
        return (T) this.head.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
```

### Simple Implementation of Queue
```java
public class Queue<T> {

    private static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void add(T o) {
        Node node = new Node(o);
        if (this.head == null) { // first element
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public T remove() {
        if (this.head == null) {
            return null;
        }

        T data = (T) this.head.data;
        if (this.head.equals(this.tail)) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.size--;
        return data;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }
        return (T) this.head.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
```