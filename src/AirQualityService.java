import java.util.concurrent.CompletableFuture;

public class AirQualityService {
    private String apiUrl;
    private HttpClientWrapper clientWrapper;

    public AirQualityService(String lat, String lon, String token) {
        this.apiUrl = "https://api.waqi.info/feed/geo:" + lat + ";" + lon + "/?token=" + token;
        this.clientWrapper = new HttpClientWrapper();
    }

    public CompletableFuture <String> getAirQualityData() {
        return clientWrapper.sendRequest(apiUrl);
    }
    
}
