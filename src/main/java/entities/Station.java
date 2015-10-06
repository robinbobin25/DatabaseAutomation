package entities;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Station {
    int id;
    String city;
    String state;
    double lat_n;
    double long_w;

    public Station(int id, String city, String state, double lat_n, double long_w) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.lat_n = lat_n;
        this.long_w = long_w;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat_n() {
        return lat_n;
    }

    public void setLat_n(double lat_n) {
        this.lat_n = lat_n;
    }

    public double getLong_w() {
        return long_w;
    }

    public void setLong_w(double long_w) {
        this.long_w = long_w;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Station{" +
                "city='" + city + '\'' +
                ", id=" + id +
                ", state='" + state + '\'' +
                ", lat_n=" + lat_n +
                ", long_w=" + long_w +
                '}';
    }

}
