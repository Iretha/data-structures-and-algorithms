---
layout: default
title: Graphs
parent: Data Structures
nav_order: 160
description: "Graphs"
permalink: /graphs
---
# Graphs 
{: .fs-9 }

Graph is another word for a network i.e., a set of objects called vertices (V) or Nodes, that are connected 
together via Edges (E) or Links. 
{: .fs-6 .fw-300 }
---

## Definition
Graph is another word for a network i.e., a set of objects (called vertices (V) or nodes) that are connected 
together. The connections between the vertices are called edges (E) or links.
G = (V, E)

Glossary:
* Graph - a network (objects linked together)
* Vertices / Nodes - the objects, that are connected/ linked together
* Edges / Links - the connections between the objects
* Directed Edges / Links - when there is only one direction (like binary tree: parent -> children)
* UndirectedEdges / Links (or Bidirectional)  - when we can go in both directions
* Weight - edges may have weight, this is the relative cost, when you pass through that edge

## Data Representations of Graphs
### Edge Lists
We take each edge and represent it as set of two nodes and put it in a list.

Edges List: 
```java
[[0,1], 
 [1,2],  
 [0,4], 
 [4,3], 
 [3,1], 
 [3,2]]
```
! If the graph is undirected, we should double the edges (with swapped nodes for both directions):
```java
[[0,1], [1,0],
 [1,2], [2,1],
 [0,4], [4,0],
 [4,3], [3,4],
 [3,1], [1,3]
 [3,2], [2,3]]
```
Representation: Array of arrays or array of array lists or array of LinkedLists.

* Pros - Simple, Space Efficient
* Cons - Linear Search O(N), because we should iterate through the whole list to find something

### Adjacency Matrices
We take every edge of the graph and represent it as a 2D array or matrix and if there is a link between 
the edges, we mark it with 1, if there isn't - we place 0. 
```
@  |  0|  1|  2|  3|  4
---|---|---|---|---|---
0  |  0|  1|  0|  0|  1
1  |  0|  0|  1|  0|  0
2  |  0|  0|  0|  0|  0
3  |  0|  1|  1|  0|  0
4  |  0|  0|  0|  1|  0
```
! If the graph is undirected, we should mirror the matrix, for both directions:
```
@  |  0|  1|  2|  3|  4
---|---|---|---|---|---
0  |  0|  1|  0|  0|  1
1  |  1|  0|  1|  1|  0
2  |  0|  1|  0|  1|  0
3  |  0|  1|  1|  0|  1
4  |  0|  0|  0|  1|  0
```
Representation: 2D array

* Pros - O(1) Lookup
* Cons - Not space efficient (we add a lot of additional nils)

### Adjacency Lists (Neighbours List)
Combination of Edge List and Adjacency List. We start from edge 0 and add it's neighbours, 
in our case [1,4]. Be careful with directed graphs, you should only add the neighbours, within the
right direction. In our example, from 0 we can go to 1 and 4.

The index is the edge itself, the value at that index represent the neighbours.
```
0 -> [1,4]
1 -> [2]
2 -> [ ]
3 -> [1,2]
4 -> [3]
```

! If the graph is undirected, we should add neighbours for both directions:
```
0 -> [1,4]
1 -> [0,2,3]
2 -> [1,3]
3 -> [1,2,4]
4 -> [0,3]
```
Representation: Array of ArrayLists / Array of Array Lists

* Pros - Fast Lookup; Easy to find neighbours
* Cons - no such

## Types of Graphs
* Directed Graph - there is only one direction between two nodes (Example: Binary Tree - type of graph, that always have a direction from top to bottom)
* Undirected (Bidirectional) Graph - you can go in both directions
* Weighted Graph - type of graph, where edges have weight (relative cost) 
i.e. when you need to find the shortest path or the cheapest flight to Sydney

## Real Life Examples
* Path-Finding Algorithms (google maps)
* Social Networks (like Fb etc.)
* Games (Nearest Gamers)
* Torrents (Nearest Peers/ Seeders)
* Indexing/ Mapping World Wide Web (sites and pages) from Search Engines like Google
* Any kind of network (internet/ social/ friends/ work)

## Traverse Algorithms (Search Algorithms)

Name|Implementation|Usage
---|---|---
[Breadth First Search (BFS)](https://iretha.github.io/data-structures-and-algorithms/bfs-graph)|Queue|Finding friends in social graphs, finding recommendations in Spotify
[Depth First Search (DFS)](https://iretha.github.io/data-structures-and-algorithms/dfs-graph)|Stack|Path Finding, Unique Solutions (Paths), Cycle Detection

## Implementation of Graph with Adjacency Lists (Neighbours List)
```java
public class GraphAdjList {

    private int nodeCount;
    private Deque<Integer>[] neighbours;

    public GraphAdjList(int nodeCount) {
        this.nodeCount = nodeCount;

        this.neighbours = new Deque[this.nodeCount];
        for (int i = 0; i < this.nodeCount; ++i) {
            neighbours[i] = new ArrayDeque<>();
        }
    }

    public void addEdge(int n, int m) {
        neighbours[n].add(m);
    }

    public List<Integer> BFS(int startAt) { // traversal from given source
        return BreadthFirstSearch.bfs(this.neighbours, startAt);
    }

    public List<Integer> DFS(int startAt) { // traversal from given source
        return DepthFirstSearch.dfs(this.neighbours, startAt);
    }
}
```


