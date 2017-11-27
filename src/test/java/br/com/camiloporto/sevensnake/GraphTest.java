package br.com.camiloporto.sevensnake;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by camiloporto on 11/23/17.
 */
public class GraphTest {

    @Test
    public void shouldCreateGraphFromSnakeGrid() {
        int[][] grid = new int[][] {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        Graph graph = new Graph(grid);

        Assert.assertEquals(graph.nodes[0].value, 1);
        Assert.assertEquals(graph.nodes[1].value, 2);
        Assert.assertEquals(graph.nodes[2].value, 3);
        Assert.assertEquals(graph.nodes[3].value, 4);
        Assert.assertEquals(graph.nodes[4].value, 5);
        Assert.assertEquals(graph.nodes[5].value, 6);
        Assert.assertEquals(graph.nodes[6].value, 7);
        Assert.assertEquals(graph.nodes[7].value, 8);
        Assert.assertEquals(graph.nodes[8].value, 9);

        Assert.assertTrue(graph.nodes[0].adjList.containsAll(Arrays.asList(1,3)));
        Assert.assertTrue(graph.nodes[8].adjList.containsAll(Arrays.asList(5,7)));
        Assert.assertTrue(graph.nodes[4].adjList.containsAll(Arrays.asList(1,3, 5, 7)));
        Assert.assertFalse(graph.nodes[4].adjList.contains(0));
        Assert.assertFalse(graph.nodes[4].adjList.contains(2));
        Assert.assertFalse(graph.nodes[4].adjList.contains(6));
        Assert.assertFalse(graph.nodes[4].adjList.contains(8));
    }

}
