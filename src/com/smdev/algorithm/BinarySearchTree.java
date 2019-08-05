package com.smdev.algorithm;

public class BinarySearchTree<T extends Comparable> {

    private static class Node {
        private int key;
        private String value;

        private Node leftChild;
        private Node rightChild;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public String find(int key) {
        Node node = find(this.root, key);
        return node != null ? node.value : null;
    }

    private Node find(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.leftChild, key);
        } else {
            return find(node.rightChild, key);
        }
    }

    public void insert(int key, String value) {
        this.root = insert(this.root, new Node(key, value));
    }

    private Node insert(Node currentParent, Node node) {
        if (currentParent == null) {
            return node;
        }
        if (node.key < currentParent.key) {
            currentParent.leftChild = insert(currentParent.leftChild, node);
        } else if (node.key > currentParent.key) {
            currentParent.rightChild = insert(currentParent.rightChild, node);
        }
        return currentParent;
    }

    public int findMinKey() {
        if (this.root == null) {
            return -1;
        }
        return getMin(this.root).key;
    }

    private Node getMin(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return getMin(node.leftChild);
    }

    public void delete(int key) {
        delete(this.root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.leftChild = delete(node.leftChild, key);
        } else if (key > node.key) {
            node.rightChild = delete(node.rightChild, key);
        } else {

            if (node.leftChild == null && node.rightChild == null) { // both children are null (has no children)
                node = null;
            } else if (node.leftChild == null) { // only left is null (only one child)
                node = node.rightChild;
            } else if (node.rightChild == null) { // only right is null (only one child)
                node = node.leftChild;
            } else { // has two children => find min child and replace current and delete the min as a child
                Node minNode = getMin(node.rightChild);

                node.key = minNode.key;
                node.value = minNode.value;
                node.rightChild = delete(node.rightChild, node.key);
            }
        }
        return node;
    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.leftChild);
        System.out.print(node.value);
        traverseInOrder(node.rightChild);
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value);
        traverseInOrder(node.leftChild);
        traverseInOrder(node.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.leftChild);
        traverseInOrder(node.rightChild);
        System.out.print(node.value);
    }
}
