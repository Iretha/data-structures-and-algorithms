---
layout: default
title: Linked Lists & Double Linked
parent: Home
nav_order: 110
description: "Linked Lists & Double Linked Lists"
permalink: /linked-lists
---
# Linked Lists
{: .fs-9 }
 
A linked list is just series of nodes, linked together, forming a list. 
Each node has two parts - the data and a pointer, which points to the next node.
The very first element of the list is called "Head" and the very last is called "Tail".
{: .fs-6 .fw-300 }
---
When we manipulate the elements (adding, removing, switching places), we actually manipulate
the links (the pointers). 

Pros:
* Super fast Inserts/ Deletes (at front) - constant time O(1)
* No fixed capacity, can grow incrementally

Cons:
* No indexes => no random access (access by index) to the elements
* Access (Get/ Set) is linear O(N), because we have to iterate all the elements, starting from the head

**Stacks & Queues are internally implemented with Linked Lists.**

# Double Linked Lists

Same as LinkedList with the only difference, that each Node keeps references to the next node and 
to the previous node. This helps you to optimize part of the operations.

# Summary
FIND/ DELETE BY VALUE|ADD/REMOVE (FRONT)|ADD/REMOVE (BACK)
---|---|---
O(N)|O(1)|O(N)
linear| constant| linear
not that fast|ultra fast|not that fast