package br.com.camiloporto.sevensnake;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by camiloporto on 11/22/17.
 */
public class GridCell {

    int i;
    int j;
    int gridSize;

    public GridCell(int i, int j, int gridSize) {
        checkValues(i,j, gridSize);

        this.gridSize = gridSize;
        this.i = i;
        this.j = j;
    }

    private void checkValues(int i, int j, int gridSize) {
        if(!isInside(i,j,gridSize)) {
            throw new IllegalArgumentException("cell coordinates must be equal or greater than zero");
        }
    }

    public boolean isAdjacent(GridCell gridCell) {

        return distance(gridCell) == 1;
    }

    private int distance(GridCell gridCell) {
        int xDistance = Math.abs(i - gridCell.i);
        int yDistance = Math.abs(j - gridCell.j);
        return xDistance + yDistance;
    }

    public Set<GridCell> getAdjacentCells() {
        Set<GridCell> adjCells = new HashSet<GridCell>();
        for(int i = this.i-1; i <= (this.i + 1); i++) {
            for(int j = this.j-1; j <= (this.j + 1); j++) {
                if(isInside(i,j,this.gridSize)) {
                    GridCell cell = new GridCell(i, j, this.gridSize);
                    if(isAdjacent(cell)) {
                        adjCells.add(cell);
                    }
                }

            }
        }
        return adjCells;
    }

    private boolean isInside(int i, int j, int gridSize) {
        return ((i >= 0 && i < gridSize) &&
                (j >= 0 && j < gridSize));
    }
}
