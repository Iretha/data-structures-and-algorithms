package com.smdev.datastructures;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private java.util.LinkedList<Integer>[] edges;

    public Graph(int vertices) {
        this.edges = new java.util.LinkedList[vertices];
    }

    public void addEdge(int from, int to) {
        if (this.edges[from] == null) {
            this.edges[from] = new LinkedList<>();
        }
        this.edges[from].add(to);
    }

    public List<Integer> bfs(int startFrom) {
        List<Integer> path = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startFrom);

        boolean[] visited = new boolean[edges.length];

        Integer v;
        while (!queue.isEmpty()) {
            v = queue.poll();
            if (!visited[v]) {
                visited[v] = true;
                path.add(v);
                queue.addAll(this.edges[v]);
            }
        }
        return path;
    }
}
