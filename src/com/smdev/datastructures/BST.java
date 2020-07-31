package com.smdev.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(Integer num) {
        Node n = new Node(num);
        this.root = insert(this.root, n);
    }

    private Node insert(Node parent, Node node) {
        if (parent == null) {
            return node;
        }
        if (parent.value > node.value) {
            parent.left = insert(parent.left, node);
        } else if (parent.value < node.value) {
            parent.right = insert(parent.right, node);
        }
        return parent;
    }

    public boolean lookup(Integer num) {
        if (this.root == null) {
            return false;
        }
        Node n = lookup(this.root, num);
        return n != null;
    }

    private Node lookup(Node parent, Integer num) {
        if (parent == null) {
            return null;
        }
        if (parent.value == num) {
            return parent;
        } else if (parent.value > num) {
            return lookup(parent.left, num);
        } else {
            return lookup(parent.right, num);
        }
    }

    public void delete(Integer num) {
        if (root == null) {
            return;
        } else if (this.root.value == num) {
            this.root = null;
            return;
        }

        this.root.left = delete(this.root.left, num);
        this.root.right = delete(this.root.right, num);
    }

    private Node delete(Node parent, Integer num) {
        if (parent == null || parent.value == num) {
            return null;
        } else if (num < parent.value) {
            return delete(parent.left, num);
        } else {
            return delete(parent.right, num);
        }
    }

    /**
     * Root, Left, Right (Good for Copying & Expression Trees)
     */
    public List<Integer> preorder() {
        List<Integer> list = new ArrayList<>();
        preorder(this.root, list);
        return list;
    }

    private void preorder(Node parent, List<Integer> list) {
        if (parent == null) {
            return;
        }
        list.add(parent.value);
        preorder(parent.left, list);
        preorder(parent.right, list);
    }

    /**
     * Left, Right, Root = Bottom Up (Good for Deletion Algorithms)
     */
    public List<Integer> postorder() {
        List<Integer> list = new ArrayList<>();
        postorder(this.root, list);
        return list;
    }

    private void postorder(Node parent, List<Integer> list) {
        if (parent == null) {
            return;
        }
        postorder(parent.left, list);
        postorder(parent.right, list);
        list.add(parent.value);
    }

    /**
     * Left, Root, Right (Good for Iterating Nodes in Non-Decreasing Order)
     */
    public List<Integer> inorder() {
        List<Integer> list = new ArrayList<>();
        inorder(this.root, list);
        return list;
    }

    private void inorder(Node parent, List<Integer> list) {
        if (parent == null) {
            return;
        }
        inorder(parent.left, list);
        list.add(parent.value);
        inorder(parent.right, list);
    }

    public List<Integer> inorderLinear() {
        List<Integer> list = new ArrayList();
        inorderLinear(this.root, list);
        return list;
    }

    private void inorderLinear(Node root, List<Integer> list){
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node curr = root;
        while(curr != null){
            stack.add(curr);
            curr = curr.left;
            while(curr == null && !stack.isEmpty()){
                Node n = stack.pop();
                System.out.println(n.value);
                list.add(n.value);
                curr = n.right;
            }
        }
    }

}
