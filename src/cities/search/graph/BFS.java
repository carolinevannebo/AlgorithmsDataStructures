package cities.search.graph;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BFS {

    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        HashMap<String, ArrayList<City>> cities;

        try {
            cities = readCitiesFromCSV(csvFile);
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return; // If we can't read the file, there's no point in continuing
        }

        // Connect cities
        for (ArrayList<City> citiesInCountry : cities.values()) {
            for (City city1 : citiesInCountry) {
                for (City city2 : citiesInCountry) {
                    if (city1 != city2) {
                        city1.addConnection(city2);
                    }
                }
            }
        }

        City oslo = null;
        for (City city : cities.get("NO")) {
            if (city.getCityName().equals("Oslo")) {
                oslo = city;
                break;
            }
        }

        if (oslo != null) {
            bfs(oslo);
        } else {
            System.out.println("Could not find Oslo in the list of cities.");
        }

    }

    public static void bfs(City city) {
        Set<City> visited = new HashSet<>();
        Queue<City> queue = new LinkedList<>();

        visited.add(city);
        queue.add(city);

        while (!queue.isEmpty()) {
            City current = queue.poll();
            System.out.println(current.getCityName() + ", " + current.getCountry());

            for (City neighbor : current.getConnectedCities()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }


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
