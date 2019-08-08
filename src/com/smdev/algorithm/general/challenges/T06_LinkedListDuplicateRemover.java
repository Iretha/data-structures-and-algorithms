package com.smdev.algorithm.general.challenges;

import java.util.HashSet;
import java.util.Set;

public class T06_LinkedListDuplicateRemover {

    private class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public T06_LinkedListDuplicateRemover() {
    }

    public T06_LinkedListDuplicateRemover(Integer... values) {
        for (Integer i : values) {
            add(i);
        }
    }

    public void add(Integer i) {
        Node n = new Node(i);
        if (this.root == null) {
            this.root = n;
        } else {
            n.next = this.root;
            this.root = n;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    /**
     * Challenge: Write a method that removes any duplicates from our Linked List.
     */
    public void removeDuplicates() {
        Set<Integer> uniqueValues = new HashSet<>();

        Node n = this.root;
        uniqueValues.add(n.value);

        while (n.next != null) {
            if (!uniqueValues.add(n.next.value)) {
                n.next = n.next.next;
                this.size--;
            } else {
                n = n.next;
            }
        }
    }
}
