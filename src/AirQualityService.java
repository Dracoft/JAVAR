import java.util.concurrent.CompletableFuture;

public class AirQualityService {
    private String apiUrl;

    protected String getApiUrl(){
        return apiUrl;
    }

    private HttpClientService httpClientService;

    public AirQualityService(String lat, String lon, String token) {
        this.apiUrl = "https://api.waqi.info/feed/geo:" + lat + ";" + lon + "/?token=" + token;
        this.httpClientService = new HttpClientService();
    }

    public CompletableFuture <String> getAirQualityData() {
        return httpClientService.sendRequest(apiUrl);
    }
    
}
