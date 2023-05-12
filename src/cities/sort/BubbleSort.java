package cities.sort;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        ArrayList<City> cities;

        try {
            cities = readCitiesFromCSV(csvFile);
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return; // If we can't read the file, there's no point in continuing
        }

        //sortCitiesByLatitude(cities);

        Collections.shuffle(cities); // Randomly sorting first

        long startTime = System.nanoTime();
        int numSwaps = bubbleSort(cities.toArray(new City[0]));
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        for (City city : cities) {
            System.out.println(city.getCityName() + " " + city.getLatitude());
        }

        System.out.println("Number of swaps: " + numSwaps);
        System.out.println("Execution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");
    }

    /**In the worst-case scenario (when the input is sorted in reverse order),
     * Bubble Sort would need to do n*(n-1)/2 swaps, where n is the size of the input array.
     *
     * In the best-case scenario (when the input is already sorted),
     * Bubble Sort can finish in linear time n if we optimize the algorithm to stop early when it finds the list is sorted.
     *
     * If you randomly order the list before sorting, the number of swaps will likely be less than the worst-case scenario
     * but more than the best-case scenario, as the algorithm will likely need to do some but not the maximum possible number of swaps.*/

    // Got sick of the same method in main, needs refactoring
    public static ArrayList<City> readCitiesFromCSV(String filePath) throws IOException {
        ArrayList<City> cities = new ArrayList<>();
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
                cities.add(new City(cityName, latitude));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing latitude for city: " + cityName);
            }
        }

        br.close();
        return cities;
    }

    // bubblesort without counting swaps
    public static void sortCitiesByLatitude(ArrayList<City> cities) {
        int n = cities.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (cities.get(j).getLatitude() > cities.get(j+1).getLatitude()) {
                    // swap cities[j+1] and cities[j]
                    City temp = cities.get(j);
                    cities.set(j, cities.get(j+1));
                    cities.set(j+1, temp);
                }
            }
        }
    }

    // bubblesort with counting swaps
    public static int bubbleSort(City[] cities) {
        int n = cities.length;
        int numSwaps = 0; // add a counter for the number of swaps

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (cities[j].getLatitude() > cities[j+1].getLatitude()) {
                    // swap cities[j+1] and cities[j]
                    City temp = cities[j];
                    cities[j] = cities[j+1];
                    cities[j+1] = temp;
                    numSwaps++; // increment the counter each time a swap is made
                }
            }
        }

        return numSwaps; // return the total number of swaps
    }

    /**For Bubble Sort, the term "merge" isn't typically used.
     * We usually refer to "swaps" or "comparisons".
     * Bubble sort works by repeatedly swapping the adjacent elements if they are in the wrong order.*/

}
