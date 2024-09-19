import java.util.List;

class Attributions {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

class City {
    private String name;
    private List<Double> geo;

    public String getName() {
        return name;
    }

    public List<Double> getGeo() {
        return geo;
    }

    public double getLatitude() {
        return geo != null && geo.size() > 0 ? geo.get(0) : 0.0;
    }

    public double getLongitude() {
        return geo != null && geo.size() > 1 ? geo.get(0) : 0.0;
    }
}

class Data {
    private List<Attributions> attributions;
    private City city;

    public List<Attributions> getAttributions() {
        return attributions;
    }

    public City getCity() {
        return city;
    }
}

class AirQualityResponse {
    private Data data;

    public Data getData() {
        return data;
    }
}