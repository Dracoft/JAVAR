class City {
    private String name;

    public String getName() {
        return name;
    }
}

class Data {
    private City city;

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
