package search.binarySearch;

import search.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/search/worldcities.csv";
        String line;
        String csvSeparator = ",";
        ArrayList<City> cities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSeparator);
                String cityName = columns[1].replace("\"", ""); // Remove double quotes

                try {
                    double latitude = Double.parseDouble(columns[2].replace("\"", "")); // Remove double quotes and parse the latitude
                    cities.add(new City(cityName, latitude));
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing latitude for city: " + cityName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double targetLatitude = 40.4169;
        City[] citiesArray = cities.toArray(new City[cities.size()]);

        // Sort
        sortByLatitude(citiesArray);

        // Perform binary search
        long startTime = System.nanoTime();
        City foundCity = binarySearchByLatitude(citiesArray, targetLatitude);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        //System.out.println(foundCity.getCityName());

        if (foundCity != null) {
            System.out.println("City found: " + foundCity.getCityName());
        } else {
            System.out.println("City not found.");
        }

        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }

    public static void sortByLatitude(City[] cities) {
        Arrays.sort(cities, Comparator.comparingDouble(City::getLatitude));
    }

    public static City binarySearchByLatitude(City[] cities, double targetLatitude) {
        int left = 0;
        int right = cities.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            double middleLatitude = cities[middle].getLatitude();

            if (middleLatitude == targetLatitude && Objects.equals(cities[middle].getCityName(), "Madrid")) {
                    return cities[middle];
            } else if (middleLatitude < targetLatitude) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }

}
