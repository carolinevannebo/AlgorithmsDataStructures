package cities.search.graph;

import java.util.*;

/*  Depth-First Search (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking.
    DFS can be implemented using recursion or an explicit stack data structure. */

//  DFS using an adjacency list to represent an undirected graph
public class DepthFirstSearchRecursion {

    //  The graph is initialized with a number of vertices, and each vertex has a corresponding adjacency list to store its neighbors.
    static class Graph {
        private final int numVertices;
        private final LinkedList<Integer>[] adjacencyList;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new LinkedList[numVertices];

            for (int i = 0; i < numVertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        //  The addEdge method adds an edge between two vertices in the adjacency list. Since the graph is undirected, we add the edge in both directions.
        void addEdge(int vertex1, int vertex2) {
            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1); // For undirected graph
        }

        /*  The DFS method initializes an array of boolean values to keep track of visited vertices.
            Then, it calls the DFSUtil method with the starting vertex and the visited array. */
        void DFS(int startVertex) {
            boolean[] visited = new boolean[numVertices];
            DFSUtil(startVertex, visited);
        }

        /*  The DFSUtil method is a recursive function that implements the DFS algorithm.
            It marks the current vertex as visited and prints it.
            Then, it iterates through the neighbors of the current vertex.
            If a neighbor hasn't been visited yet, the method calls itself recursively with the neighbor as the new current vertex. */
        void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (Integer neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    //  Create a graph, add edges to it, and perform DFS starting from vertex 0.
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("Depth First Traversal (starting from vertex 0):");
        g.DFS(0); // Output: 0 1 3 5 4 2
    }
}