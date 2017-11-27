package br.com.camiloporto.sevensnake;

import java.util.*;

/**
 * Created by camiloporto on 11/22/17.
 */
public class SevenSnake {

    private GridCell[] snake = new GridCell[7];
    private Graph.Node head = null;

    Set<Graph.Node> sequence = new LinkedHashSet<Graph.Node>();
    Set<Integer> prohibitedNodes = new HashSet<Integer>();

    public SevenSnake() {}


    public Set<Graph.Node> getSequence() {
        return new HashSet<Graph.Node>(sequence);
    }

    public int size() {
        return sequence.size();
    }

    public void add(Graph.Node n) {
        sequence.add(n);
        head = n;
        prohibitedNodes.add(n.index);
    }

    public boolean canAdd(Graph.Node n) {
        if(sequence.isEmpty()) return true;
        if(sequence.contains(n)) return false;

        for(int i : n.adjList) {
            if(prohibitedNodes.contains(i) && i != head.index) {
                return false;
            }
        }
        return true;
    }

    public Graph.Node head() {
        return head;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SevenSnake that = (SevenSnake) o;
        return that.toString().equals(o.toString());
//        return sequence != null ? sequence.equals(that.sequence) : that.sequence == null;

    }

    @Override
    public int hashCode() {
        return toString().hashCode();
//        return sequence != null ? sequence.hashCode() : 0;
    }

    public Set<Integer> adjacencyNodes() {
        Set<Integer> adjacencyNodes = new HashSet<Integer>();
        for(Graph.Node n : sequence) {
            adjacencyNodes.addAll(n.adjList);
        }
        return adjacencyNodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Graph.Node n : sequence) {
            sb.append("(" + n + ") ");
        }
        return sb.toString();
    }

    public int sum() {
        int sum = 0;
        for(Graph.Node n : sequence) {
            sum += n.value;
        }
        return sum;
    }

    public boolean isCompatible(SevenSnake snake) {
        Set<Integer> adjNodes = this.adjacencyNodes();
        Set<Graph.Node> snakeNodes = this.getSequence();
        Set<Integer> otherSnakeNodeIndexes = new HashSet<Integer>();
        for(Graph.Node n : snake.getSequence()) {
            otherSnakeNodeIndexes.add(n.index);
        }

        adjNodes.retainAll(otherSnakeNodeIndexes);
        snakeNodes.retainAll(snake.getSequence());

        return adjNodes.isEmpty() && snakeNodes.isEmpty();
    }
}
