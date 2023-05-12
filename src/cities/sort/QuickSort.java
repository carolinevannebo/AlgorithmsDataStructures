package cities.sort;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    private static int comparisons = 0;
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
        QuickSort.quickSort(citiesArray, 0, citiesArray.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        for (City city : citiesArray) {
            System.out.println(city.getCityName() + " " + city.getLatitude());
        }

        System.out.println("\nNumber of comparisons: " + QuickSort.getComparisons()); //834 453 with shuffle, 876 586 without
        System.out.println("Execution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");

        resetComparisons();
    }

    /**QuickSort is a Divide and Conquer algorithm.
     It picks an element as pivot and partitions the given array around the picked pivot.
     The pivot element is placed in its correct position,
     elements smaller than the pivot are placed to the left,
     and elements greater than the pivot are placed to the right.

     Note that unlike Merge Sort, the performance of Quick Sort depends heavily on the choice of pivot.
     In the worst-case scenario (i.e., when the smallest or largest element is always chosen as the pivot),
     Quick Sort performs poorly with a time complexity of O(n^2).
     However, in the best and average cases, Quick Sort performs well with a time complexity of O(n log n).
     The best case occurs when the pivot always divides the array into two halves.*/

    /**The QuickSort algorithm's performance heavily depends on the pivot's selection.
     In the worst-case scenario (when the input array is already sorted or reverse sorted),
     if the pivot is always the smallest or the largest element,
     QuickSort performs very poorly with a time complexity of O(n^2), where n is the number of elements.
     This is because it makes the maximum number of comparisons.

     In this case, when not shuffling the array, and if the data has some order to it (like sorted or nearly sorted),
     QuickSort might perform poorly because the pivot selection (which is the last element in this implementation)
     might be creating partitions that are very unbalanced (one partition is much larger than the other).

     On the other hand, when you shuffle the array, it helps to avoid this worst-case scenario by randomizing the data.
     The shuffled array is likely to create more balanced partitions, which reduces the number of comparisons needed.

     That's why the output resulted in fewer comparisons when the array is shuffled first.
     This behavior demonstrates the importance of pivot selection in the QuickSort algorithm and why some
     implementations choose the pivot randomly or use techniques like 'median of three'
     (choosing the median of the first, middle, and last elements of the array as the pivot) to improve performance
     on certain types of input data.*/

    public static void quickSort(City[] cities, int low, int high) {
        if (low < high) {
            // pi is partitioning index, cities[pi] is
            // now at right place
            int pi = partition(cities, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(cities, low, pi - 1);
            quickSort(cities, pi + 1, high);
        }
    }

    private static int partition(City[] cities, int low, int high) {
        City pivot = cities[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            comparisons++;
            // If current element is smaller than or
            // equal to pivot
            if (cities[j].getLatitude() <= pivot.getLatitude()) {
                i++;

                // swap cities[i] and cities[j]
                City temp = cities[i];
                cities[i] = cities[j];
                cities[j] = temp;
            }
        }

        // swap cities[i+1] and cities[high] (or pivot)
        City temp = cities[i + 1];
        cities[i + 1] = cities[high];
        cities[high] = temp;

        return i + 1;
    }

    /**The partition method is a crucial part of the quicksort algorithm.
     Its main purpose is to select a "pivot" element from the array and partition the other elements into two sub-arrays,
     according to whether they are less than or greater than the pivot.
     The pivot element itself is in its final position of the sorted array.

     Breakdown of the partition function:

     - Select a pivot: In many versions of quicksort, the pivot is the last element of the array
     (as in this implementation), but it can be any element. The choice of pivot selection can
     influence the performance of quicksort but that's a more advanced topic.

     - Initialize two pointers: i is initialized to be one element before the start of the array/sub-array
     (low - 1 in this case), and j is initialized to the start of the array (low).

     - Iterate over the array: The j pointer moves through the array from low to high - 1,
     comparing each element with the pivot.

     - Move elements: If the element at j is less than or equal to the pivot,
     increment i and then swap the elements at i and j. This process ensures that elements less than or equal
     to the pivot are always on the left side of i, and elements greater than the pivot are on the right side of i.

     - Place the pivot correctly: Once all elements have been visited, swap the pivot element
     (currently at high) with the element at i + 1. Now, the pivot is in its correct sorted position in the array.

     - Return the pivot index: Finally, the function returns i + 1, which is the index of the pivot element in the array.

     After partition is called, the pivot is in the correct place of the sorted array, and the array is divided into two parts
     - elements less than the pivot are on the left side, and elements greater than the pivot are on the right side.
     These sub-arrays are not sorted yet, and quickSort is called recursively on these two sub-arrays.*/

    public static int getComparisons() {
        return comparisons;
    }

    public static void resetComparisons() {
        comparisons = 0;
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
