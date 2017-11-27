package br.com.camiloporto;

import br.com.camiloporto.sevensnake.Graph;
import br.com.camiloporto.sevensnake.GridReader;
import br.com.camiloporto.sevensnake.SevenSnake;
import br.com.camiloporto.sevensnake.SevenSnakeSearch;

import java.io.IOException;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        String filePath = args[0];

        try {
            int[][] grid = new GridReader(filePath).readGrid();
            Graph graph = new Graph(grid);
            SevenSnakeSearch snakeSearch = new SevenSnakeSearch(graph);
            SevenSnake[] snakePair = snakeSearch.search();
            if(snakePair == null) {
                System.out.println("FAIL");
            }
            else {
                System.out.println(Arrays.deepToString(snakePair));
            }
        } catch (IOException e) {
            System.err.println("could nod read file " + args[0]);
        }

    }
}
