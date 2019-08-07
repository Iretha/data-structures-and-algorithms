---
layout: default
title: Breadth First Search (BFS)
parent: Algorithms (Graphs)
nav_order: 91
description: "Breadth First Search (BFS)"
permalink: /bfs-graph
---

# Breadth First Search (BFS) - Nearest Neighbour
{: .fs-9 }

We start from the nearest neighbours and when we visit all of them, then we continue with their neighbours 
and so on
{: .fs-6 .fw-300 }
---

We start from the nearest neighbours and when we visit all of them, then we continue with their neighbours 
and so on, until there are no more neighbours of neighbours.

## Real Life Usages
* Finding friends in social graphs
* Finding recommendations in Spotify

## Algorithm
We use Queue (FIFO) to track the nodes we have to visit and when a node is visited, we poll it from the queue.

1). Add the nodes you to plan to visit to the queue
2). Poll the node, to mark it as visited, add it to the Path and add its' neighbours to the queue 
3). Poll the first neighbour (to mark it as visited, add it to the Path) and add its neighbours to the queue
4). Poll the next one (to mark it as visited, add it to the Path) and add its neighbours to the queue and so on...
5). When you are adding new neighbours to the queue, check if they are not already visited (added to the path). 
If they are not visited, then add them to the queue. If they are visited (in the path), then don't add them again to the queue.

If we count how many times we try to add a node to the queue, but it's already visited, we can count i.e. 
the number of the "mutual friends" in social networking or to suggest people as friends.

## Implementation
```java
public static List<Integer> bfs(Deque<Integer>[] neighbours, int startAt) { // traversal from given source
        if (neighbours == null) {
            return new ArrayList();
        }

        // Keep track of the visited nodes
        boolean[] visited = new boolean[neighbours.length];

        // I'm going to track the path as well
        List<Integer> path = new ArrayList<>(neighbours.length);

        // Create a queue for BFS
        Deque<Integer> queue = new ArrayDeque<>();

        //Enqueue it
        queue.add(startAt);

        int curr;
        Iterator<Integer> neighbourIterator;
        int neighbour;
        while (queue.size() != 0) { // keep going if there are elements in the queue
            curr = queue.poll();

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
                    queue.add(neighbour);
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
Following is Breadth First Traversal (starting from vertex 0)
BFS Path is: [0, 1, 6, 3, 4, 5, 2, 7]
```
