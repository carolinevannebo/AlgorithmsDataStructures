package cities.search.graph;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BFS {

    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        /** Although HashMap is not a type of Graph, it can be used to represent a graph.
            In this case, I'm using HashMap where each key is a node in the graph, and its value is a list of
            all the nodes it's connected to. This is an adjacency list representation of a graph.*/
        HashMap<String, ArrayList<City>> cities;

        try {
            cities = readCitiesFromCSV(csvFile);
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return; // If we can't read the file, there's no point in continuing
        }

        // Connect cities in the same country
        for (ArrayList<City> citiesInCountry : cities.values()) {
            for (City city1 : citiesInCountry) {
                for (City city2 : citiesInCountry) {
                    // Connect cities if they are not the same
                    if (city1 != city2) {
                        city1.addConnection(city2);
                    }
                }
            }
        }

        City oslo = null;
        // Finding Oslo in the list of Norwegian cities
        for (City city : cities.get("NO")) {
            if (city.getCityName().equals("Oslo")) {
                oslo = city;
                break;
            }
        }

        if (oslo != null) {
            // Performing BFS from Oslo
            long startTime = System.nanoTime();
            bfs(oslo);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("\nExecution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");
        } else {
            System.out.println("Could not find Oslo in the list of cities.");
        }

    }

    // BFS algorithm implementation
    public static void bfs(City city) {
        Set<City> visited = new HashSet<>();
        Queue<City> queue = new LinkedList<>();

        // Adding the starting city to the visited set and the queue
        visited.add(city);
        queue.add(city);

        while (!queue.isEmpty()) {
            // Polling the next city from the queue and printing its name
            City current = queue.poll();
            System.out.println(current.getCityName() + ", " + current.getCountry());

            // Adding all unvisited neighbors of the current city to the visited set and the queue
            for (City neighbor : current.getConnectedCities()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    /**Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures.
     It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'source node'),
     and explores all of the neighbor nodes at the present depth prior to moving on to nodes at the next depth level.

     Here's how BFS works:

     - Initialization: Mark all nodes as not visited. Create an empty queue and enqueue the source vertex (node) into it.
        Mark this node as visited.

     - Traversal: While the queue is not empty, perform the following steps:
        Dequeue a vertex from the queue. Let's say the dequeued vertex is v. Print v or process it based on your goal.
        Enqueue all unvisited neighbors of v and mark them as visited.

     - Completion: The algorithm ends when every node that can be reached from the source node has been visited.

     BFS uses the adjacency matrix or adjacency list representation of a graph.
     The main advantage of BFS is that it can be used to find the shortest path between two nodes in an unweighted graph.

     In terms of time complexity, BFS will visit each vertex once and each edge once, leading to a time complexity of O(V+E),
     where V is the number of vertices and E is the number of edges.

     One of the key characteristics of BFS is that it provides a complete search—it is guaranteed to find a solution if one exists,
     even if it has to search the entire graph. The solution found by BFS is also guaranteed to be the shortest in terms of the
     number of steps, but not necessarily in terms of the path cost.

     BFS is often contrasted with depth-first search (DFS). While BFS explores neighbors first and thus is excellent
     for searching at a shallow level, DFS goes deep into a graph, exploring a path as far as possible before backtracking,
     which can be useful when the search space is large and solutions are dense but located deep in the graph.*/


    public static HashMap<String, ArrayList<City>> readCitiesFromCSV(String filePath) throws IOException {
        HashMap<String, ArrayList<City>> cityMap = new HashMap<>();
        String line;
        String csvSeparator = ",";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        // Skip the header line
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] columns = line.split(csvSeparator);
            String cityName = columns[1].replace("\"", ""); // Remove double quotes

            try {
                double latitude = Double.parseDouble(columns[2].replace("\"", "")); // Remove double quotes and parse the latitude
                String country = columns[5].replace("\"", ""); // 2 digit country code, could be country name
                City city = new City(cityName, latitude, country);

                if (cityMap.containsKey(country)) {
                    // If the country is already in the map, add the city to the existing list
                    cityMap.get(country).add(city);
                } else {
                    // If the country is not in the map, create a new list and add the city
                    ArrayList<City> citiesInCountry = new ArrayList<>();
                    citiesInCountry.add(city);
                    cityMap.put(country, citiesInCountry);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing latitude for city: " + cityName);
            }
        }

        br.close();
        return cityMap;
    }
}
