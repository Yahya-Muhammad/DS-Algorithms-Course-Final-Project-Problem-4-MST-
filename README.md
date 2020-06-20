Note: The problem statement, solution’s pseudo code, sample runs, etc can be found in the report.


Program Structure:

● class LinkedList<T>
A class representing a linked list of generic nodes.

● class Node<T>
A class representing the generic nodes of the linked list.

● class Edge
A class representing the edges of the graph.
Data:
- int from: an integer representing the “from” node.
- int to: an integer representing the “to” node.
- int cost: an integer representing the cost of removing the edge. (abs(to - from))

● class MinSpanningTree The driver class.
Behavior:
- void quickSortDescByCost(Edge[] arr, int start, int end): a method that sorts the edges
descendingly according to their cost.
- int partition(Edge[] arr, int start, int end): a method that partitions the array, returning a
pivot where all edges with cost greater than the pivot precede it.
- boolean greater(int x, int y): a method that returns true if x is greater than y and false
otherwise.
- void exchange(Edge[] arr, int x, int y): a method that exchanges the position of two
edges in the array.
- LinkedList<LinkedList<Integer>> initializeForest(int n): a method that creates and returns
a list containing “n” lists where each list contains an integer value representing the node.
“forest”
- Edge[] getEdges(int m, Scanner s): a method that creates and returns an array of “m”
edges.
- LinkedList<Edge> MST(LinkedList<LinkedList<Integer>> forest, Edge[] edges): a
method that applies Kruskal’s algorithm, returning a list of the edges of the minimum spanning tree. “safeEdges”
- void printTotalMinCost(Edge[] edges, LinkedList<Edge> safeEdges): a method that prints the total minimum cost required to convert the graph to a MST.


Program Instructions:

1) Type the number of nodes of the graph and the number of edges separated by a white space (e.g., “5 6” for a graph of 5 nodes and 6 edges)
2) Type the integer representing the “from” node and the integer representing the “to” node separated by a white space (e.g., “1 3” for an edge going from 1 to 3)
3) Repeat (2) for the number of edges you entered.
4) The program should output the total minimum cost required to convert the graph to a
MST.
