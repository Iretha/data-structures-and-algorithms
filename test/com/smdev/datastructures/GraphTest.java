package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GraphTest {
    private Graph graph;

    @BeforeEach
    void setup(){
        graph = new Graph(8);
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
    }

    @Test
    void testBFS() {
        List<Integer> bfsPath = graph.bfs(0);

        List<Integer> bfxExp = List.of(0, 1, 6, 3, 4, 5, 2, 7);
        Assertions.assertEquals(bfxExp, bfsPath);

        List<Integer> bfxNotExp = List.of(0, 1, 6, 3, 4, 5, 7, 2);
        Assertions.assertNotEquals(bfxNotExp, bfsPath);
    }

    @Test
    void testDFS() {
        List<Integer> path = graph.dfs(0);

        List<Integer> expected = List.of(0, 3, 5, 2, 7, 6, 4, 1);
        Assertions.assertEquals(expected, path);

        List<Integer> notExpected = List.of(0, 1, 5, 2, 7, 3, 6, 4);
        Assertions.assertNotEquals(notExpected, path);
    }
}
