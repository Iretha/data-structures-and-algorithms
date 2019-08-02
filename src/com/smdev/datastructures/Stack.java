package com.smdev.datastructures;

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
