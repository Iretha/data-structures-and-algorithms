package com.smdev.datastructures;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


    public List<Integer> dfs(int startFrom) {
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(startFrom);
        boolean[] visited = new boolean[edges.length];

        Integer v = startFrom;
        visited[v] = true;
        while (!stack.isEmpty()) {
            v = stack.pop();
            path.add(v);

            Iterator<Integer> neighboursIt = this.edges[v].iterator();
            while (neighboursIt.hasNext()) {
                v = neighboursIt.next();
                if (!visited[v]) {
                    stack.add(v);
                    visited[v] = true;
                }
            }
        }
        return path;
    }
}
