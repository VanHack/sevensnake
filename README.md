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
A solution for the problem is a pair of 7Snakes that:

* .. to continue..
