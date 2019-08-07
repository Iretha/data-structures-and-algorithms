package com.smdev.algorithm.searching;

import java.util.*;

public class BreadthFirstSearch {

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
}
