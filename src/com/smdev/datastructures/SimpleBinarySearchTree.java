package com.smdev.datastructures;

public class SimpleBinarySearchTree {

    private static class Node {
        private Integer data;

        private Node left;
        private Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private Node root;

    public SimpleBinarySearchTree() {
    }

    public void insert(Integer i) {
        Node n = new Node(i);

        this.root = insert(this.root, n);
    }

    private Node insert(Node parent, Node n) {
        if (parent == null) {
            return n;
        }

        if (n.data < parent.data) {
            parent.left = insert(parent.left, n);
        } else if (n.data > parent.data) {
            parent.right = insert(parent.right, n);
        }
        return parent;
    }

    public String getPreOrder() {
        StringBuilder order = new StringBuilder();
        preOrderIterate(this.root, order);

        System.out.println(order.toString());
        return order.toString();
    }

    private void preOrderIterate(Node parent, StringBuilder order) {
        if (parent == null) {
            return;
        }
        order.append(parent.data).append(" ");
        preOrderIterate(parent.left, order);
        preOrderIterate(parent.right, order);
    }

    public String getInOrder() {
        StringBuilder order = new StringBuilder();
        inOrderIterate(this.root, order);

        System.out.println(order.toString());
        return order.toString();
    }

    private void inOrderIterate(Node parent, StringBuilder order) {
        if (parent == null) {
            return;
        }
        inOrderIterate(parent.left, order);
        order.append(parent.data).append(" ");
        inOrderIterate(parent.right, order);
    }

    public String getPostOrder() {
        StringBuilder order = new StringBuilder();
        postOrderIterate(this.root, order);

        System.out.println(order.toString());
        return order.toString();
    }

    private void postOrderIterate(Node parent, StringBuilder order) {
        if (parent == null) {
            return;
        }
        postOrderIterate(parent.left, order);
        postOrderIterate(parent.right, order);
        order.append(parent.data).append(" ");
    }
}
