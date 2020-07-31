package com.smdev.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GraphTest {

    @Test
    public void testBFS() {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 2);
        graph.addEdge(0, 6);
        graph.addEdge(1, 5);
        graph.addEdge(5, 1);
        graph.addEdge(5, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 0);
        graph.addEdge(0, 3);
        graph.addEdge(5, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(7, 2);

        List<Integer> bfsPath = graph.bfs(0);

        List<Integer> bfxExp = List.of(0, 1, 6, 3, 4, 5, 2, 7);
        Assert.assertEquals(bfxExp, bfsPath);

        List<Integer> bfxNotExp = List.of(0, 1, 6, 3, 4, 5, 7, 2);
        Assert.assertNotEquals(bfxNotExp, bfsPath);
    }
}
