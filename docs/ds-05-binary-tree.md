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
The height of the tree is the maximum distance from root to the highest level (height = the number of levels - 1).
{: .fs-6 .fw-300 }
---
Binary Trees are made from smaller binary trees. This means, that we need "recursion" to traverse them (for each node with it's direct children).

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

## Binary Search Tree (BST)
It's a binary **sorted** tree, that contains elements with unique keys and has super fast search/insert/delete with complexity time of O(log N),
because when every time we inter the recursion with reduce the number of elements to traverse by half!

Find/ Insert/ Delete => O(log N) => 1/2 -> 1/4 -> 1/8 -> 1/16 (this is how elements are reduced)

### What is a Binary Search (Ordered/ Sorted) Tree (BST)
* It's a binary tree, which elements are always sorted. Sorted means that the value of the key of the left node is less than 
the value of the key of the parent node and the key of the right node is greater than the key of the parent node.
* All keys must be unique, when working with BST. No duplicate keys are allowed.
* The min value is the leftmost node on the last level.
* The max value is the rightmost node on the last level
* Search is from top (root) to bottom
* Height is the maximum distance from the root => height = the number of levels - 1

### How are search and insert implemented?
* Start from root -> Is that the key? If not and if the key is less than root, 
then we continue with the left child, if it is greater, then we continue with the right child and so on until we find the element 
or reach the end (the last level) and return null. This means that each time we enter the recursion, we eliminate the elements by half. 
This is the O(log N) runtime!!!

### How is the delete implemented?
We have the following cases:
* No child - find the element and set the reference to null (voila!)
* One child - we replace the node with its' only child (voila!)
* Two children - we have the following tree steps:
    * 1). Find the node with the minimum value of the right subtree of the node, we want to delete
    * 2). Copy the key and the value of the min node to the node, we want to delete
    * 3). Recursively delete the min node. We can't just delete it like setting the reference to null (minNode = null), 
because it may have a right child and we should keep it. To do that, we need to call the same method to delete the min node 
recursively and if there is a child, the child will replace the min node (= delete the min node).

### Depth First Traversal
There are 3 different ways, depending ot when you visit root:
```
    a
   / \
  b   c
```
* **In**order (Left, **Root**, Right) : b -> a -> c -> Print the nodes in sorted order
* **Pre**order (**Root**, Left, Right) : a -> b -> c
* **Post**order (Left, Right, **Root**) : b -> c -> a

### Summary
* Ordered = Sorted
* Recursive
* Full = Perfect = Complete
* Balanced
* Ways to traverse them (Depth First vs Breadth First)
* Depth First (In/Pre/PostOrder)
* O(log N) for all operations: Find/ Insert/ Delete

### Worst Case Scenario
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

### Construct BST from traversal order
When we know either preorder or postorder traversal, we can construct the BST. 
Note that we can always sort the given traversal and get the inorder traversal. 
Inorder traversal of BST is always sorted.

## Binary Heap
Binary Heap is another type of binary tree. There are two types of binary heaps. Trees, which root 
holds the MAX value or the MIN value and they are respectively called:
* Binary Heap MAX 

If it's a binary heap max, then the max value is the root value. The rule is that the value
of the children must be the same or less than the value of the parent. This means that the 
highest values are closer to top, while lowest values are located at the bottom levels.

* Binary Heap MIN 

If it's a binary heap min, then the min value is the root value. The rule is that the value
of the children must be the same or bigger than the value of the parent. This means that the 
lowest values are closer to top, while the highest values are located at the bottom levels.

Binary heaps are very common. The algorithm is used for Routers, Shortest Path, Priority Queues, Scheduling,
Kernel Process Scheduling. Another important point is that Binary Heaps allow duplicates. 

### Binary Heap vs Binary Search Tree
The difference with the BST is that the elements are not sorted, not unique and the left child value is not necessary 
less than the value of the right child. A parent node of a Binary Heap MAX tree must have same or higher value 
than it's children and same of less value if it's a Binary Heap MIN tree.

### How are they implemented?
The most common way is to implement them as an array, with elements ordered in breadth first order, 
starting from the root. The root is always the first element of the array:
```
     42
     /\
  29    18
  /\    /\
 14 7 18 12
 /\
11 13
```
Will become: arr[42, 29, 18, 14, 7, 18, 12, 11, 13]

Then, we can extract the nodes with this formulas:
* parent - arr[(i-1)/2] returns the parent node
* left child - arr[(2*i)+1] returns the left child node
* right child - arr[(2*i)+2] returns the right child node

### How is the insert implemented?
1). First, we add the element at the very end of the array
2). We need to perform a **heapify up** operation. "Heapify up" means that we compare it with it's parent.
MAX HEAP: If it's bigger, we swap it with its' parent and we move up, until we reach the root. If it's smaller, we
leave it wherever it is.
MIN HEAP: If it's smaller, we swap it with it's parent and proceed further until we reach the root. If it's not, we 
leave it on its place.

### How to extract MAX, resp. MIN?
1). We swap the top and the most bottom node, then we start from top (root) and go to bottom (leaves). 
2). We need to perform a **heapify down** operation. "Heapify down" means that we compare the value with its children
and swap it with the biggest of them, then we compare, proceed furher with the next children until we reach the end or the 
children values are less than the value of the parent node.

### MIN & MAX binary heaps are used to:
* Find MIN/MAX value, which is O(1)






