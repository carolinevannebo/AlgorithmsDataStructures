package cities.sort;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {
    private static int mergeCount = 0;

    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        ArrayList<City> cities;

        try {
            cities = readCitiesFromCSV(csvFile);
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return; // If we can't read the file, there's no point in continuing
        }

        Collections.shuffle(cities);
        City[] citiesArray = cities.toArray(new City[0]);

        long startTime = System.nanoTime();
        mergeSort(citiesArray, 0, citiesArray.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        for (City city : citiesArray) {
            System.out.println(city.getCityName() + " " + city.getLatitude());
        }

        System.out.println("\nNumber of merge operations: " + MergeSort.getMergeCount());
        System.out.println("Execution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");

        MergeSort.resetMergeCount();
    }

    /**The Merge Sort algorithm is a Divide and Conquer algorithm.
     It divides the array into two halves, recursively sorts them, and then merges the two sorted halves.
     Regardless of the initial order of the elements in the array, the number of divisions
     (and subsequent merges) is determined by the total number of elements.

     The process of splitting the array continues until we have n sub-arrays of size 1,
     where n is the total number of elements.Then, the process of merging starts.
     These n sub-arrays get merged into n/2 sub-arrays of size 2,
     then n/4 sub-arrays of size 4, and so on, until we have one final sorted array.

     So, the number of merge operations in Merge Sort depends only on the total number of elements and not on their initial order.
     This is why shuffling the array doesn't change the number of merge operations.
     It would, however, affect an algorithm like Bubble Sort or Insertion Sort,
     which are sensitive to the initial order of elements.*/

    public static void mergeSort(City[] cities, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(cities, left, middle);
            mergeSort(cities, middle + 1, right);

            // Merge the sorted halves
            merge(cities, left, middle, right);
        }
    }

    public static void merge(City[] cities, int left, int middle, int right) {
        // Find sizes of two sub-arrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temp arrays
        City[] L = new City[n1];
        City[] R = new City[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = cities[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = cities[middle + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getLatitude() <= R[j].getLatitude()) {
                cities[k] = L[i];
                i++;
            } else {
                cities[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            cities[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            cities[k] = R[j];
            j++;
            k++;
        }

        mergeCount++;
    }

    public static int getMergeCount() {
        return mergeCount;
    }

    public static void resetMergeCount() {
        mergeCount = 0;
    }

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
}
