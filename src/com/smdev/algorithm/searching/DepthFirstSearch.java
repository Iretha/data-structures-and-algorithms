package com.smdev.algorithm.searching;

import java.util.*;

public class DepthFirstSearch {

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
}
