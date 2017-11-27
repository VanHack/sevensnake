package br.com.camiloporto.sevensnake;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by camiloporto on 11/22/17.
 */
public class GridCellTest {

    @Test
    public void shouldIdentifyAdjacentCells() {
        final int gridSize = 10;

        GridCell c00 = new GridCell(0, 0, gridSize);
        Assert.assertTrue(c00.isAdjacent(new GridCell(1,0,gridSize)));
        Assert.assertTrue(c00.isAdjacent(new GridCell(0,1,gridSize)));
        Assert.assertFalse(c00.isAdjacent(new GridCell(1,1,gridSize)));

        GridCell c33 = new GridCell(3, 3, gridSize);
        Assert.assertTrue(c33.isAdjacent(new GridCell(3,4,gridSize)));
        Assert.assertTrue(c33.isAdjacent(new GridCell(3,2,gridSize)));
        Assert.assertTrue(c33.isAdjacent(new GridCell(2,3,gridSize)));
        Assert.assertTrue(c33.isAdjacent(new GridCell(4,3,gridSize)));
        Assert.assertFalse(c33.isAdjacent(new GridCell(2,4,gridSize)));
        Assert.assertFalse(c33.isAdjacent(new GridCell(4,4,gridSize)));
        Assert.assertFalse(c33.isAdjacent(new GridCell(4,2,gridSize)));
        Assert.assertFalse(c33.isAdjacent(new GridCell(2,2,gridSize)));
    }
}
