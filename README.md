problem description: https://docs.google.com/document/d/1pgc1EiJFOAxaEwfFI0PyUkbUSPAckYKgIZ4N407oj94/edit?usp=sharing

## Building and Running
1. Download project
2. mvn clean package
3. java -cp target/classes/ br.com.camiloporto.App <filename.csv>

## About the output:
The program will output a pair of 7Snakes in the following format:

* [\<Snake1\>, \<Snake2\>], where:
* \<Snake\> = a sequence of 7 \<GridNode\>, where:
* \<GridNode\> = (\<GridNodeIndex\>{GridNodeValue}), where:
* \<GridNodeIndex\> = An index of the Input Grid's cell, between 0 and the number of elements of the input grid. 

For example:
Given the input grid:
```
1, 2, 3
4, 5, 6
7, 8, 9
```

- element of value 1 has index 0
- element of value 3 has index 2
- element of value 4 has index 3
- element of value 7 has index 6
- element of value 9 has index 8

* \<GridNodeValue\> = the cell value of a GridNode

## Sample output:
Given the following Grid:
```
4, 6, 7, 12, 4
1, 7, 4, 5, 2
10, 11, 6, 3, 5
1, 2, 4, 8, 9
9, 6, 3, 5, 1
```

A sample output is:
\[(1{6}) (2{7}) (3{12}) (4{4}) (9{2}) (14{5}) (19{9}) , (11{11}) (10{10}) (15{1}) (20{9}) (21{6}) (22{3}) (23{5})\]

which corresponds to the following snakes:
```
4, *, *, *, *
1, 7, 4, 5, *
*, *, 6, 3, *
*, 2, 4, 8, *
*, *, *, *, 1
```
## Approach to the problem
### Input representation
Given the problem description about the grid and adjacency rules of each cell, I modelled the Grid as a Graph as follow:

* each grid cell is a Graph Node
* each Graph Node receives an id as follow
** given a grid of size NxN, the Grid Cell a\[i\]\[j\]  is mapped to a Graph Node of index (i * N) + j; where 0 \>= i,j \< N.
* Each Node's adjacency list is created as follow:
** Given a Node n and its equivalent GridCell a\[i\]\[j\], the Adjacency list of the node will be the Nodes equivalent to the GridCells b\[k\]\[l\] where 
*** k = i+1, k=i-1; 0 >= k < N
*** l = j+1, l=j-1; 0 >= l < N
* A 7Snake is a Path on the Graph with 7 nodes length;

### Solution Definition
Given two snakes s1 and s2. They form a solution to the problem if:

* sum(s1) = sum(s2); where sum(s)
* s1.nodes intersection with s2.nodes = empty
* s1.adjacencyNodes intersection with s2.nodes = empty

### Finding valid Pair of 7Snakes
The reasoning for the proposed solution is as follows:
1. Finding a 7Snake is like finding a 7-length-path in a graph
2. We have to find two 7-length-paths in the graph that is also a *valid solution*.
3. So, we keep searching the graph fot these paths until: a) find a valid solution or b) conclude that there is no valid solution in the graph.

#### Finding a 7-Snake
Given a Node n in the Graph g, we find a 7Snake using an algorithm technique composed of a Depth-First-Search like approach together with a backtracking technique. Below is the pseudo-code for the algorithm

```
Snake findSnake(Node startNode)
    Snake s = emptySnake()
    Stack stack = emptyStack()
    stack.push(startNode)
    while(stack is not empty && s.size() < 7)
        Node n = stack.pop()
        if(adding n to s will keep a valid snake)
            s.add(n)                                     // add n to the snake and increments its size by 1
            stack.pushAll(n.adjList)
        else
            // backtrack, try other node
    return s
```

We start with an Empty Snake and, in each iteration inside the while loop, we try to increase the snake by one Node. If the current node addition lead the snake state in a *valid one*, we add the node to the snake. Otherwise, we backtrack and try other Node. 

A Snake is a valid one if it:
* has size = 1
* do not have cycles
* has no intersection between its head (most recently added node) and nodes belonging to the adjacency lists of the Nodes inside the snake.

#### Finding Snakes in the Graph
For searching the graph for a valid solution, we could:
1. Enumerate all possible valid 7-snake starting from all nodes in the graph
2. group snakes by their sum
3. For each group, try to find a pair os snakes which composes a *valid solution*.

Though, I chose a probabilistic approach for the search, as follow:
1. choose a random node n from the graph
2. find a random 7-snake starting with n as startNode
3. if snake has already been discovered
    3.1 increment repeated snake count
    3.2 discard snake and goto #1.
4. else
    1. check if other snakes with the same sum has been found
    2. for all snakes with the same sum, check if one of them compounds a valid solution with the recently found snake.
    3. if found, return the pair.
    4. add recently found snake to the group of snakes with the same sum.
5. if you think you have found all snakes (too many repeated snakes are being found), stop the process. no valid pair found!



