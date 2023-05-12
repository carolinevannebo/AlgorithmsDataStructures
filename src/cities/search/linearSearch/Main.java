package cities.search.linearSearch;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        String line;
        String csvSeparator = ",";
        ArrayList<City> cities = new ArrayList<City>();

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

        // Perform linear cities.search
        long startTime = System.nanoTime();
        City foundCity = linearSearch(citiesArray, targetLatitude);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        if (foundCity != null) {
            System.out.println("City found: " + foundCity.getCityName());
        } else {
            System.out.println("City not found.");
        }

        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }

    public static City linearSearch(City[] cities, double targetLatitude) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getLatitude() == targetLatitude) {
                return cities[i];
            }
        }
        return null;
    }
}
