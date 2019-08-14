package com.smdev.datastructures;

public class RandomBinaryTree {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Node add(Node parent, int value, boolean left) {
        Node node = new Node(value);
        if (parent == null) {
            this.root = node;
        } else {
            if (left) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return node;
    }


}
