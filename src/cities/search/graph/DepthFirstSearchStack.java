package cities.search.graph;

import java.util.*;

public class DepthFirstSearchStack {
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

        void addEdge(int vertex1, int vertex2) {
            adjacencyList[vertex1].add(vertex2);
            adjacencyList[vertex2].add(vertex1); // For undirected graph
        }

        /*  The DFS method now initializes an array of boolean values to keep track of visited vertices and a stack to store the vertices to be visited.
            It marks the starting vertex as visited and pushes it onto the stack.*/
        void DFS(int startVertex) {
            boolean[] visited = new boolean[numVertices];
            Stack<Integer> stack = new Stack<>();

            visited[startVertex] = true;
            stack.push(startVertex);

            //  The DFS algorithm iterates while the stack is not empty.
            while (!stack.isEmpty()) {
                // It pops the top vertex from the stack, prints it, and iterates through its neighbors.
                int currentVertex = stack.pop();
                System.out.print(currentVertex + " ");

                for (Integer neighbor : adjacencyList[currentVertex]) {
                    //  If a neighbor hasn't been visited yet, the method marks it as visited and pushes it onto the stack.
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(5, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 8);
        g.addEdge(4, 7);

        System.out.println("Depth First Traversal (starting from vertex 0):");
        g.DFS(5); // Output: 5, 3, 2, 4, 7, 8
    }
}
