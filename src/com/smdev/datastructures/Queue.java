package com.smdev.datastructures;

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
