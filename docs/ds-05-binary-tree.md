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

A tree, which nodes may have have up to 2 children (left and right).
{: .fs-6 .fw-300 }
---
Binary Trees are made from smaller binary trees. This means, that we need "recursion" to traverse 
them (for each node with it's direct children).

Glossary:
* Tree - a tree-like (hierarchical) data structure, which data is stored in nodes
* Root - the topmost node
* Children - elements, that are directly under an element
* Parent - the element directly above another element
* Leaf - a node without children
* Height - the maximum distance from root to the highest level (height = the number of levels - 1).
* Binary Tree - a tree, which nodes may have up to two children (left child and right child)
```
      tree
      ----
       a  <- root
     /  \
    b    c  <- nodes
  /  \    \
 d    e    f  <- leaves 
```
* "a" is the root
* "a" is parent of "b" and "c"
* "b" and "c" are children of "a"
* "d", "e", "f" are leaves, because don't have children
* the height is 2 => all levels - 1 => 3 - 1 = 2

## Types of Binary Trees
* Full Binary Tree (also known as "perfect" or "complete") - each node has 0 or 2 binary children (no single nodes) 
```
             17
           /   \   
         16    19    
        /  \       
      35    45   
    /   \
  30   45
```
* Not full - there are nodes with only 1 child
```
               18
            /     \  
          40       30  
                    \
                    40
```
* Complete Binary Tree - if all levels are completely filled, except possibly the last level. 
An example of a complete binary tree is the binary heap.
```
               17
           /        \  
         25         35  
        /  \        /  \
      40    50    99   40
     /  \   /      \
    8   6  19       7
```
* Perfect Binary Tree - which all nodes have two children and all leaves are at the same level
```
             17
           /    \   
         16      19    
        /  \    /  \    
      35   45  13  21
```

* Balanced Binary Tree - the left and right subtrees' heights differ by at most 1 AND left tree is balanced AND right tree is balanced
* Unbalanced Binary Tree - when the left and right subtrees differ in height by more than 1 and when left or right (or both) subtree is non balanced

## Traverse Algorithms (Search Algorithms):
* Breadth First (Shortest Path Algorithms use it) - we search level by level, starting from root.
This means that we start from root (lvl 0), then we continue with the children of the root node (level 1), then with 
level 3 etc.
* Depth First - we start from root(level 0) and then we go deep to the highest level (level N)
