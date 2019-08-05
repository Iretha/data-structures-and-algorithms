---
layout: default
title: Binary Trees
parent: Data Structures
nav_order: 140
description: "Binary Trees"
permalink: /binary-trees
---
# Binary Tree 
{: .fs-9 }

Binary Tree is a tree-like data structure, which data is stored in nodes. 
The top node is called "root". Nodes also may have have up to 2 children (left and right).
{: .fs-6 .fw-300 }
---
Binary Trees are made from smaller binary trees. This means we need "recursion" to traverse them (for each node with it's direct children).

Types of Binary Trees:
* Full (also known as "perfect" or "complete") - each node has 0 or 2 binary children (no single nodes)
* Not full - there are nodes with only 1 child
* Balanced - the left and right subtrees' heights differ by at most 1 AND left tree is balanced AND right tree is balanced
* Unbalanced - when the left and right subtrees differ in height by more than 1 and when left or right (or both) subtree is non balanced

Search Algorithms:
* Breadth First (Shortest Path Algorithms use it) - we search level by level, starting from root.
This means that we start from root (lvl 0), then we continue with the children of the root node (level 1), then with 
level 3 etc.
* Depth First - we start from root(level 0) and then we go deep to the highest level (level N)

# Binary Search Tree (BST)
It's a binary **sorted** tree, that contains elements with unique keys and has super fast search/insert/delete with complexity time of O(log N),
because when every time we inter the recursion with reduce the number of elements to traverse by half!

Find/ Insert/ Delete => O(log N) => 1/2 -> 1/4 -> 1/8 -> 1/16 (this is how elements are reduced)

## What is a Binary Search (Sorted) Tree (BST)
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


