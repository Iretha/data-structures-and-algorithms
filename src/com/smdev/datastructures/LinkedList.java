package com.smdev.datastructures;

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

    public void reverse(){
        if(this.head == null || this.head.next == null){
            return;
        }

        Node first = this.head;
        Node second = this.head.next;
        Node third;
        while(second != null){
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        this.head = first;
    }
}
