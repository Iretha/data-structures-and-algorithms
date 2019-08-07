package com.smdev.datastructures;

import com.smdev.algorithm.searching.BreadthFirstSearch;
import com.smdev.algorithm.searching.DepthFirstSearch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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
