package br.com.camiloporto.sevensnake;

import java.util.*;

/**
 * Created by camiloporto on 11/23/17.
 */
public class Graph {

    Node[] nodes;

    public Graph(int[][] grid) {
        nodes = new Node[grid.length * grid.length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int nodeIndex = (i * grid.length) + j;
                GridCell c = new GridCell(i, j, grid.length);
                Set<GridCell> adjCells =  c.getAdjacentCells();
                nodes[nodeIndex] = new Node(nodeIndex, grid[i][j], adjCells);
            }
        }
    }

    static final class Node {

        int value;

        Set<Integer> adjList;
        public Integer index;

        public Node(int nodeIndex, int value, Set<GridCell> adjCells) {
            index = nodeIndex;
            this.value = value;
            createAdjList(adjCells);
        }

        private void createAdjList(Set<GridCell> adjCells) {
            adjList = new HashSet<Integer>();
            for(GridCell c : adjCells) {
                adjList.add(((c.i * c.gridSize) + c.j));
            }
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.index == ((Node)obj).index;
        }

        @Override
        public String toString() {
            return "" + index + "{" + value + "}";
        }
    }
}
