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
        SevenSnake s1 = createSnake(graph, 0, 1, 2, 3, 4, 9, 14);

        SevenSnake s2 = createSnake(graph, 10, 15, 20, 21, 22, 23, 24);

        Assert.assertTrue(s1.isCompatible(s2));

        s1 = createSnake(graph, 24, 23, 22, 17, 12, 13, 14);
        s2 = createSnake(graph, 7, 6, 11, 10, 15, 20, 21);

        Assert.assertFalse(s1.isCompatible(s2));
    }

    private SevenSnake createSnake(Graph graph, int... nodes) {
        SevenSnake s = new SevenSnake();
        for(int i : nodes) {
            s.add(graph.nodes[i]);
        }
        return s;
    }
}
