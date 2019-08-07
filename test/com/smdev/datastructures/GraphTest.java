package com.smdev.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GraphTest {

    private GraphAdjList g;

    @Before
    public void setUp(){
        g = new GraphAdjList(8);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);
        g.addEdge(0, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(7, 2);
    }

    @Test
    public void testBreadthFirstSearch() {
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = g.BFS(0);
        System.out.println("BFS Path is: " + Arrays.toString(path.toArray()));
    }

    @Test
    public void testDepthFirstSearch() {
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = g.DFS(0);
        System.out.println("DFS Path is: " + Arrays.toString(path.toArray()));
    }
}
