package cities.sort;

import cities.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        String csvFile = "/Users/carolinevannebo/Desktop/IT/4-semester/AlgDat/oppgaver/Oppgaver/src/cities/worldcities.csv";
        ArrayList<City> cities;

        try {
            cities = readCitiesFromCSV(csvFile);
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return; // If we can't read the file, there's no point in continuing
        }
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
