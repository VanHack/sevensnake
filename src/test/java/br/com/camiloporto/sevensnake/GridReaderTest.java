package br.com.camiloporto.sevensnake;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by camiloporto on 11/22/17.
 */
public class GridReaderTest {

    @Test
    public void shouldReadGridFromCsvFile() throws IOException {

        String filePath = "src/test/resource/br/com/camiloporto/sevensnake/grid1.csv";

        int[][] grid1 = new GridReader(filePath).readGrid();
        int[][] expectedGrid = new int[][] {
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{8, 9, 10, 11, 12, 13, 14},
                new int[]{15, 16, 17, 18, 19, 20, 21},
                new int[]{22, 23, 24, 25, 26, 27, 28},
                new int[]{29, 30, 31, 32, 33, 34, 35},
                new int[]{36, 37, 38, 39, 40, 41, 42},
                new int[]{43, 44, 45, 46, 47, 48, 49}
        };

        Assert.assertArrayEquals(grid1[0], expectedGrid[0]);
        Assert.assertArrayEquals(grid1[1], expectedGrid[1]);
        Assert.assertArrayEquals(grid1[2], expectedGrid[2]);
        Assert.assertArrayEquals(grid1[3], expectedGrid[3]);
        Assert.assertArrayEquals(grid1[4], expectedGrid[4]);
        Assert.assertArrayEquals(grid1[5], expectedGrid[5]);
        Assert.assertArrayEquals(grid1[6], expectedGrid[6]);
    }

}
