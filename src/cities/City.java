package cities;

import java.util.ArrayList;

public class City {
    private String cityName;
    private double latitude;
    private String country;
    private ArrayList<City> connectedCities;

    public City(String cityName, double latitude) {
        this.cityName = cityName;
        this.latitude = latitude;
    }

    public City(String cityName, double latitude, String country) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.country = country;
        this.connectedCities = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() { return country; }

    public ArrayList<City> getConnectedCities() { return connectedCities; }

    public void addConnection(City city) {
        this.connectedCities.add(city);
    }

}
