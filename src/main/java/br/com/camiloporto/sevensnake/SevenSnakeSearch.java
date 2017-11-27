package br.com.camiloporto.sevensnake;

import java.util.*;

/**
 * Created by camiloporto on 11/22/17.
 */
public class SevenSnakeSearch {

    private final Random random;
    private Graph graph;

    private HashSet<SevenSnake> snakesDiscovered = new HashSet<SevenSnake>();
    private int repeatedSnakesDiscoveredCount = 0;

    public SevenSnakeSearch(Graph graph) {
        this.random = new Random();
        this.graph = graph;
    }

    public SevenSnake[] search() {
        Map<Integer, List<SevenSnake>> searchMap = new HashMap<Integer, List<SevenSnake>>();
        while(hasSnakeToSearch()) {
            Graph.Node startNode = randomNode();
            SevenSnake nextSnake = findOne(startNode);
//            if(nextSnake.toString().startsWith("(0")) {
//                System.out.println("found snake 0: " + nextSnake);
//            }
            if(!snakesDiscovered.contains(nextSnake)) {
                int sum = nextSnake.sum();
                if(sum == 30) {
                    System.out.println("found " + nextSnake);
                }
                if(searchMap.containsKey(sum)) {
                    SevenSnake validPair = getValidPairFor(nextSnake, searchMap.get(sum));
                    if(validPair != null) {
                        return new SevenSnake[]{
                                nextSnake,
                                validPair
                        };
                    }
                }
                else {
                    searchMap.put(sum, new LinkedList<SevenSnake>());
                }

                searchMap.get(sum).add(nextSnake);

            } else {

                repeatedSnakesDiscoveredCount++;
            }
            snakesDiscovered.add(nextSnake);
        }
        System.out.println("total: " + snakesDiscovered.size());
        return null;
    }

    private SevenSnake getValidPairFor(SevenSnake nextSnake, List<SevenSnake> possibleSnakes) {
        for(SevenSnake s : possibleSnakes) {
            if(s.isCompatible(nextSnake)) {
                return s;
            }
        }
        return null;
    }

    private boolean hasSnakeToSearch() {

        return repeatedSnakesDiscoveredCount < 10000000;
    }

    public SevenSnake findOne(Graph.Node startNode) {

        SevenSnake snake = dfs7(startNode);
        while (snake.size() != 7) {
            startNode = randomNode();
            snake = dfs7(startNode);
        }
        return snake;
    }

    private SevenSnake dfs7(Graph.Node startNode) {
        Deque<Graph.Node> stack = new LinkedList<Graph.Node>();
        stack.push(startNode);
        SevenSnake snake = new SevenSnake();
        Graph.Node n = null;
        while (!stack.isEmpty() && snake.size() <7) {
            n = stack.pop();
            if(snake.canAdd(n)) {
                snake.add(n);
                List<Integer> shuffleAdjList = new ArrayList<Integer>(n.adjList);
                Collections.shuffle(shuffleAdjList, this.random);
                for(int i : shuffleAdjList) {
                    if(i != snake.head().index) {
                        stack.push(graph.nodes[i]);
                    }
                }
            }
        }
        return snake;
    }


    private Graph.Node randomNode() {
        int randomIndex = this.random.nextInt(graph.nodes.length);
        return graph.nodes[randomIndex];
    }
}
