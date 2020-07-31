package com.smdev.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GraphAdjTest {

    private GraphAdjList undirectedGraph;

    private GraphAdjList directedGraph;

    @Before
    public void setUp(){
        undirectedGraph = new GraphAdjList(8);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 0);
        undirectedGraph.addEdge(1, 4);
        undirectedGraph.addEdge(4, 1);
        undirectedGraph.addEdge(4, 6);
        undirectedGraph.addEdge(6, 4);
        undirectedGraph.addEdge(6, 0);
        undirectedGraph.addEdge(0, 6);
        undirectedGraph.addEdge(1, 5);
        undirectedGraph.addEdge(5, 1);
        undirectedGraph.addEdge(5, 3);
        undirectedGraph.addEdge(3, 5);
        undirectedGraph.addEdge(3, 0);
        undirectedGraph.addEdge(0, 3);
        undirectedGraph.addEdge(5, 2);
        undirectedGraph.addEdge(2, 5);
        undirectedGraph.addEdge(2, 7);
        undirectedGraph.addEdge(7, 2);

        directedGraph = new GraphAdjList(8);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 4);
        directedGraph.addEdge(4, 6);
        directedGraph.addEdge(6, 0);
        directedGraph.addEdge(1, 5);
        directedGraph.addEdge(5, 3);
        directedGraph.addEdge(3, 0);
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(2, 7);
    }

    @Test
    public void testBreadthFirstSearch() {
        System.out.println("Undirected: Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = undirectedGraph.BFS(0);
        System.out.println("Undirected BFS Path is: " + Arrays.toString(path.toArray()));

        // Undirected BFS Path is: [0, 1, 6, 3, 4, 5, 2, 7]
    }

    @Test
    public void testBreadthFirstSearchDirected() {
        System.out.println("Directed: Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = directedGraph.BFS(0);
        System.out.println("Directed BFS Path is: " + Arrays.toString(path.toArray()));

        // Directed BFS Path is: [0, 1, 4, 5, 6, 3, 2, 7]
    }

    @Test
    public void testDepthFirstSearch() {
        System.out.println("Undirected: Following is Depth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = undirectedGraph.DFS(0);
        System.out.println("Undirected DFS Path is: " + Arrays.toString(path.toArray()));

        // Undirected DFS Path is: [0, 3, 5, 2, 7, 1, 4, 6]
    }

    @Test
    public void testDepthFirstSearchDirected() {
        System.out.println("Directed: Following is Depth First Traversal "+
                "(starting from vertex 0)");

        List<Integer> path = directedGraph.DFS(0);
        System.out.println("Directed DFS Path is: " + Arrays.toString(path.toArray()));

        //Directed DFS Path is: [0, 1, 5, 2, 7, 3, 4, 6]
    }
}
