---
layout: default
title: Algorithms (Trees)
nav_order: 95
description: "Algorithms for Trees"
has_children: true
permalink: /trees-algorithms
---

# Algorithms & Common Tasks (Trees)
{: .fs-9 }

Algorithms for Тrees
{: .fs-6 .fw-300 }
---

## Binary Trees

Name|Algorithm Type|Summary|Usage
---|---|---|---
[Binary Search Tree (BST)](https://iretha.github.io/data-structures-and-algorithms/binary-search-tree)|Sorting Alg.|Sorted Binary Tree with super fast search/insert/delete of O(log N).|In many search applications, where data constantly changes. It will be sorted, while added.
[Binary Heap MAX/MIN](https://iretha.github.io/data-structures-and-algorithms/binary-heap)|Sorting Alg.|To find/ extract MAX/MIN value super fast with complexity of O(1) | Priority Queues (esp. OS & kernels), Scheduling, Routing, Shortest Path Alg.

### [How to check if a tree is a subtree of another tree](https://github.com/Iretha/data-structures-and-algorithms/blob/master/test/com/smdev/algorithm/general/TreeTests.java)
You can use DFS with any of the traversal methods (pre/ in/ post) and export the order for both trees as strings.
Then check if the first one order contains the second one, if yes - then the second tree is a subtree of the first.

* Tree 1

```
      5
    /   \
   3     7
  /\    / \
 2  4  6   8 

Pre order:  5 3 2 4 7 6 8 
In order:   2 3 4 5 6 7 8 
Post order: 2 4 3 6 8 7 5 
```

* Tree 2

```
   7
  / \
 6   8

Pre order:  7 6 8 
In order:   6 7 8  
Post order: 6 8 7 
```