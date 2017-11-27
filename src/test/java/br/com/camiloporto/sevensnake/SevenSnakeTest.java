package br.com.camiloporto.sevensnake;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by camiloporto on 11/26/17.
 */
public class SevenSnakeTest {

    @Test
    public void testCompatible() {
        int[][] grid = new int[][] {
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 6, 15, 7},
                new int[]{8, 8, 9, 7, 8},
                new int[]{7, 8, 9, 7, 10},
                new int[]{4, 3, 2, 1, 5}
        };

        Graph graph = new Graph(grid);
        SevenSnake s1 = new SevenSnake();
        s1.add(graph.nodes[0]);
        s1.add(graph.nodes[1]);
        s1.add(graph.nodes[2]);
        s1.add(graph.nodes[3]);
        s1.add(graph.nodes[4]);
        s1.add(graph.nodes[9]);
        s1.add(graph.nodes[14]);

        SevenSnake s2 = new SevenSnake();
        s2.add(graph.nodes[10]);
        s2.add(graph.nodes[15]);
        s2.add(graph.nodes[20]);
        s2.add(graph.nodes[21]);
        s2.add(graph.nodes[22]);
        s2.add(graph.nodes[23]);
        s2.add(graph.nodes[24]);


        Assert.assertTrue(s1.isCompatible(s2));
    }
}
