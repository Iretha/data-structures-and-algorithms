---
layout: default
title: Binary Search Tree (BST)
parent: Algorithms
nav_order: 210
description: "Binary Search Tree"
permalink: /binary-search-tree
---
# Binary Search Tree (BST)
{: .fs-9 }

It's a type of binary tree, which allows only unique keys of the nodes and the keys/ nodes are sorted.
It supports super fast search/insert/delete with complexity time of O(log N).
{: .fs-6 .fw-300 }
---
Binary Search Tree (BST) is a sorting algorithm.

It's a binary **sorted** tree, that contains elements with unique keys and has super fast search/insert/delete with complexity time of O(log N),
because when every time we inter the recursion with reduce the number of elements to traverse by half!

Find/ Insert/ Delete => O(log N) => 1/2 -> 1/4 -> 1/8 -> 1/16 (this is how elements are reduced)

## What is a Binary Search (Ordered/ Sorted) Tree (BST)
* It's a binary tree, which elements are always sorted. Sorted means that the value of the key of the left node is less than 
the value of the key of the parent node and the key of the right node is greater than the key of the parent node.
* All keys must be unique, when working with BST. No duplicate keys are allowed.
* The min value is the leftmost node on the last level.
* The max value is the rightmost node on the last level
* Search is from top (root) to bottom
* Height is the maximum distance from the root => height = the number of levels - 1

## How are search and insert implemented?
* Start from root -> Is that the key? If not and if the key is less than root, 
then we continue with the left child, if it is greater, then we continue with the right child and so on until we find the element 
or reach the end (the last level) and return null. This means that each time we enter the recursion, we eliminate the elements by half. 
This is the O(log N) runtime!!!

## How is the delete implemented?
We have the following cases:
* No child - find the element and set the reference to null (voila!)
* One child - we replace the node with its' only child (voila!)
* Two children - we have the following tree steps:
    * 1). Find the node with the minimum value of the right subtree of the node, we want to delete
    * 2). Copy the key and the value of the min node to the node, we want to delete
    * 3). Recursively delete the min node. We can't just delete it like setting the reference to null (minNode = null), 
because it may have a right child and we should keep it. To do that, we need to call the same method to delete the min node 
recursively and if there is a child, the child will replace the min node (= delete the min node).

## Depth First Traversal
There are 3 different ways, depending ot when you visit root:
```
    a
   / \
  b   c
```
* **In**order (Left, **Root**, Right) : b -> a -> c -> Print the nodes in sorted order
* **Pre**order (**Root**, Left, Right) : a -> b -> c
* **Post**order (Left, Right, **Root**) : b -> c -> a

## Summary
* Ordered = Sorted
* Recursive
* Full = Perfect = Complete
* Balanced
* Ways to traverse them (Depth First vs Breadth First)
* Depth First (In/Pre/PostOrder)
* O(log N) for all operations: Find/ Insert/ Delete

## Worst Case Scenario
In the following case, all operations have O(N) time complexity:
```
       40
      /
     30
    /
   20
  /
 10
```

## Construct BST from traversal order
When we know either preorder or postorder traversal, we can construct the BST. 
Note that we can always sort the given traversal and get the inorder traversal. 
Inorder traversal of BST is always sorted.

## Example Implementation
```java
public class BinarySearchTree {

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
```

