---
layout: default
title: Algorithms (Linked Lists)
nav_order: 80
description: "Algorithms for Linked Lists"
permalink: /linked-list-algorithms
---

# Algorithms (Linked Lists)
{: .fs-9 }{: .no_toc }

Mostly loop detection algorithms.
{: .fs-6 .fw-300 }

## Table of contents
{: .no_toc .text-delta }

1. TOC
{:toc}

---

## 1). Loop Detection Algorithms
Here are 3 different approaches you can use:

###  1.1). [Floyd’s Cycle-Finding Algorithm](https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare) - O(N)
The algorithm is also known as **Floyd's Tortoise and Hare**.

You need 2 pointers (slow and fast), both starting from the same node.
The slow pointer moves with a step = 1 (Tortoise)
The fast pointer moves with a step = 2 (Hare).
If the pointers meet, then there is a cycle. 
If they don't meet and some of them reaches the end instead (null), then there is no cycle.

**This is the preferred approach.**

Example Sequence:
```
1 2 3 4 5 1
```

Position| Slow Pointer Position (+1 Step) | Fast Pointer Position (+2 Steps)
---|---|---
Initial | 1 (+ 1)| 1 (+ 2)
Moving| 2 (+ 1)| 3 (+ 2)
Moving| 3 (+ 1)| 5 (+ 2)
Moving| 4 (+ 1)| 2 (+ 2)
Moving| 5 (+ 1)| 4 (+ 2)
Cycle Found| 1 (+ 1)| 1 (+ 2)

* Implementation:
```
    public boolean detectLoop() {
        // both start from the same place
        Node slow = this.root; 
        Node fast = this.root;

        // while some of them reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) { // they met => there is a cycle
                return true; 
            }
        }
        return false;  // fast reached null, so there is no loop
    }
```

* Example:

```
1 5 4 3 2 1

Start At:   S: 1 | F: 1
Moving:     S: 5 | F: 4
Moving:     S: 4 | F: 2
Moving:     S: 3 | F: 5
Moving:     S: 2 | F: 3
Cycle:      S: 1 | F: 1
```

###  1.2). Hashing - O(N)
You can iterate over the nodes and add them in a HashSet. If the node is already added,
then there is a cycle.

**This is kind of a brute force approach.**

###  1.3). Mark Visited Nodes - O(N)
You need to extend the Node class and add a flag (boolean), which shows if the node is visited.
Then you need to iterate through the nodes and if the node is already visited, then there is a cycle.

**This is kind of a brute force approach.**

## 2). Find length of a loop in linked list
The best approach is to use Floyd’s Cycle-Finding Algorithm and when you find the node, 
to iterate through the nodes, until you reach the same node and count the iterations.

## 3). Detect if is a Circular Linked List
Well, this is a tricky task, because you should not only detect if there is a loop, 
but you also should keep in mind, that the length of the loop should be equal to the list size.
