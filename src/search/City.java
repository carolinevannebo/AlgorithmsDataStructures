package search.linearSearch;

public class City {
    private String cityName;
    private double latitude;

    public City(String cityName, double latitude) {
        this.cityName = cityName;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

}
