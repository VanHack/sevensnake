package br.com.camiloporto.sevensnake;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by camiloporto on 11/22/17.
 */
public class SevenSnakeSearchTest {

    @Test
    public void shouldFindSevenSnakesOnGrid() {
        int[][] grid = new int[][] {
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 6, 15, 7},
                new int[]{8, 8, 9, 7, 8},
                new int[]{7, 8, 9, 7, 10},
                new int[]{4, 3, 2, 1, 5}
        };

        Graph graph = new Graph(grid);

        SevenSnakeSearch snakeSearch = new SevenSnakeSearch(graph);
        SevenSnake[] snake = snakeSearch.search();
        System.out.println(Arrays.deepToString(snake));

    }

}

