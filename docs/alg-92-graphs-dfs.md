---
layout: default
title: Depth First Search (DFS)
parent: Algorithms (Graphs)
nav_order: 92
description: "Depth First Search (DFS)"
permalink: /dfs-graph
---

# Depth First Search (DFS)
{: .fs-9 }

We start from a node and then we expand down until we hit the a node, that has no more nodes to expand.
{: .fs-6 .fw-300 }
---

We start from a node and then we expand down until we hit the a node, that has no more nodes to expand.

## Real Life Usages
* Path Finding (like Google Maps)
* Unique Solutions (Paths) 
* Cycle Detection

## Algorithm
The implementation is almost the same with the difference that we use Stack (LIFO) to "queue" the nodes.

1). Add (Push) the node you to plan to visit to the stack

2). Pop it out, mark it as visited and it's neighbours to the stack

3). Repeat until there are elements in the stack

5). When you are adding new neighbours to the stack, check if they are not already visited/ added to the path. 
If they are not visited, then add them to the stack. If they are visited (or in the path), then don't add them again.

## Implementation
```java
public static List<Integer> dfs(Deque<Integer>[] neighbours, int startAt) { // traversal from given source
        if (neighbours == null) {
            return new ArrayList();
        }

        // Keep track of the visited nodes
        boolean[] visited = new boolean[neighbours.length];

        // I'm going to track the path as well
        List<Integer> path = new ArrayList<>(neighbours.length);

        // Create a stack for DFS
        Deque<Integer> stack = new ArrayDeque<>();

        //Enqueue it
        stack.push(startAt);

        int curr;
        Iterator<Integer> neighbourIterator;
        int neighbour;
        while (stack.size() != 0) { // keep going if there are elements in the stack
            curr = stack.pop();

            // already visited => skip it
            if (visited[curr]) {
                continue;
            }

            // visit for first time
            visited[curr] = true;
            path.add(curr);

            // enqueue neighbours, if they are not already visited
            neighbourIterator = neighbours[curr].iterator();
            while (neighbourIterator.hasNext()) {
                neighbour = neighbourIterator.next();
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
        return path;
    }
```
## Example
```
[
[0,1], [1,0],
[1,4], [4,1],
[4,6], [6,4],
[6,0], [0,6],
[1,5], [5,1],
[5,3], [3,5],
[3,0], [0,3],
[5,2], [2,5],
[2,7], [7,2],
]
```
Output:
```
Following is Depth First Traversal (starting from vertex 0)
DFS Path is: [0, 3, 5, 2, 7, 1, 4, 6]
```
