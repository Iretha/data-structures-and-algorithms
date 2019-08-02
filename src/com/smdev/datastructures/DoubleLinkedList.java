package com.smdev.datastructures;

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
