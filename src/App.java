import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class App {
    public static void main(String[] args) {
        String latitude = "4.754361";
        String longitude = "-74.092215";
        String token = "e7a849016e6d922c12f76420a266fcf0febb7b23";

        AirQualityService airQualityService = new AirQualityService(latitude, longitude, token);

        try {
            System.out.println("API: " + airQualityService.getApiUrl());
            airQualityService.getAirQualityData()
                .thenAccept(response -> {
                    try {
                        System.out.println("Datos de calidad del aire recibidos:");
                        Gson gson = new Gson();
                        AirQualityResponse airQualityResponse = gson.fromJson(response, AirQualityResponse.class);
                        String attributionName = airQualityResponse.getData().getAttributions().get(0).getUrl();
                        String cityName = airQualityResponse.getData().getCity().getName();
                        System.out.println(attributionName);
                        System.out.println("Usted está ubicado en: " + cityName);
                        System.out.println("Su latitud es: " + airQualityResponse.getData().getCity().getLatitude());
                        System.out.println("Su longitud es: " + airQualityResponse.getData().getCity().getLongitude());
                    } catch (JsonSyntaxException e) {
                        System.err.println("Error al parsear el JSON: " + e.getMessage());
                    }
                })
                .join();
        } catch (Exception e) {
            System.err.println("Error en la llamada a la API: " + e.getMessage());
        }
    }
}