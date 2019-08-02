---
layout: default
title: Linked Lists (incl. Double)
parent: Home
nav_order: 110
description: "Linked Lists & Double Linked Lists"
permalink: /linked-lists
---
# Linked Lists & Double Linked Lists
{: .fs-9 }
 
A linked list is just series of nodes, linked together, forming a list. 
Each node has two parts - the data and a pointer, which points to the next node.
The very first element of the list is called "Head" and the very last is called "Tail".
{: .fs-6 .fw-300 }
---
When we manipulate the elements (adding, removing, switching places), we actually manipulate
the links (the pointers). 

Double Linked Lists are same as Linked Lists with the only difference, that each Node keeps references to the next node and 
to the previous node. This helps you optimize part of the operations.

Pros:
* Super fast Inserts/ Deletes (at front) - constant time O(1)
* No fixed capacity, can grow incrementally

Cons:
* No indexes => no random access (access by index) to the elements
* Access (Get/ Set) is linear O(N), because we have to iterate all the elements, starting from the head

**Stacks & Queues are internally implemented with Linked Lists.**

**There are also circular Linked Lists. They do not have head and tail.**

## Summary

FIND/ DELETE BY VALUE|ADD/REMOVE (FRONT)|ADD/REMOVE (BACK)
---|---|---
O(N)|O(1)|O(N)
linear| constant| linear
not that fast|ultra fast|not that fast

## Discussion

### Linked List vs Double Linked List
Double Linked Lists are same as Linked Lists with the only difference, that each Node keeps references to the next node and 
to the previous node. This helps you optimize part of the operations.

### Array vs ArrayList vs Linked List

* Array and Linked List are the basic Data Structures, while ArrayList is the API, build on top of the arrays, with some additional functionality.

* Arrays can contain primitives, while ArrayLists & Linked Lists contain only objects.

* Arrays have fixed size, ArrayList have fixed capacity, that can grow dynamically and the size of the LinkedLists grow incrementally with the elements

* Arrays & ArrayLists offer random access to elements (by index), whereas the access takes constant time O(1). LinkedLists don't and the access takes linear time O(N)

* Arrays & ArrayLists take linear time O(N) to insert/ delete element, because we have to shift all elements right or left. Inserts & Deletes in front of the LinkedLists takes constant time O(1).

* Array List takes more memory most of the time, because i.e. if the capacity is 2000, but we may have 1001 elements.

o|Array| ArrayList| Linked List
---|---|---|---
FIXED SIZE| YES| NO (grows dynamically)| NO (grows incrementally)
ALLOCATED MEMORY|exact|more (because of the capacity)|exact
RANDOM ACCESS (BY INDEX)| YES| YES| NO
GET/SET| O(1)|O(1)|FRONT: O(1) / INNER & BACK: O(N)
INSERT/DELETE| O(N)|O(N)|FRONT: O(1) / INNER & BACK: O(N)
CONTAIN PRIMITIVES| YES| NO| NO 

### Simple Implementation of Linked List
```java
public class LinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public void addFront(T o) {
        Node node = new Node(o);
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
        this.size++;
    }

    public void removeFront() {
        if (this.head == null) {
            return;
        }

        this.head = this.head.next;
        this.size--;
    }

    public void addBack(T o) {
        Node node = new Node(o);

        Node last = getLastNode();
        if (last == null) {
            this.head = node;
        } else {
            last.next = node;
        }

        this.size++;
    }

    public void removeBack() {
        if (this.head == null) {
            return;
        }

        if (this.head.next == null) {
            this.head = null;
            return;
        }

        Node curr = this.head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;

        this.size--;
    }

    public T getFirst() {
        if (this.head == null) {
            return null;
        }
        return (T) this.head.data;
    }

    public T getLast() {
        Node last = getLastNode();
        return last == null ? null : (T) last.data;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean deleteValue(T o) {
        if (this.head == null || o == null) {
            return false;
        }

        if (this.head.data.equals(o)) {
            if (this.head.next != null) {
                this.head = this.head.next;
            } else {
                this.head = null;
            }
            this.size--;
            return true;
        }

        Node curr = this.head;
        while (curr.next != null && !curr.next.data.equals(o)) {
            curr = curr.next;
        }
        if (curr.next.data.equals(o)) {
            bypassNext(curr);

            this.size--;
            return true;
        }
        return false;
    }

    private void bypassNext(Node node) {
        if (node.next == null) {
            return;
        }

        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
    }

    public boolean contains(T o) {
        return findByValue(o) != null;
    }

    private Node findByValue(T o) {
        if (this.head == null || o == null) {
            return null;
        }
        Node curr = this.head;
        while (curr != null) {
            if (curr.data.equals(o)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private Node getLastNode() {
        if (this.head == null) {
            return null;
        }

        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}
```
### Simple Implementation of Double Linked List
```java
public class DoubleLinkedList<T> {

    private static class Node<T> {
        private T data;

        private Node prev;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public void addFront(T o) {
        Node node = new Node(o);
        if (this.head != null) {
            node.next = this.head;
            node.next.prev = node;
        }
        this.head = node;
        this.size++;
    }

    public void removeFront() {
        if (this.head == null) {
            return;
        }

        this.head = this.head.next;
        this.head.prev = null;
        this.size--;
    }

    public void addBack(T o) {
        Node node = new Node(o);

        Node last = getLastNode();
        if (last == null) {
            this.head = node;
        } else {
            last.next = node;
            node.prev = last;
        }

        this.size++;
    }

    public void removeBack() {
        Node last = getLastNode();
        if (last != null) {
            last.prev = null;
            this.size--;
        }
    }

    public T getFirst() {
        if (this.head == null) {
            return null;
        }
        return (T) this.head.data;
    }

    public T getLast() {
        Node last = getLastNode();
        return last == null ? null : (T) last.data;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean deleteValue(T o) {
        if (this.head == null || o == null) {
            return false;
        }

        Node node = findByValue(o);
        if (node != null) {
            if (node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                node.prev.next = null;
            }
            this.size--;
            return true;
        }

        return false;
    }

    public boolean contains(T o) {
        return findByValue(o) != null;
    }

    private Node findByValue(T o) {
        if (this.head == null || o == null) {
            return null;
        }
        Node curr = this.head;
        while (curr != null) {
            if (curr.data.equals(o)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private Node getLastNode() {
        if (this.head == null) {
            return null;
        }

        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }
}
```

