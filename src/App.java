import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws Exception {
        String latitude = "4.754361";
        String longitude = "-74.092215";
        String token = "e7a849016e6d922c12f76420a266fcf0febb7b23";

        AirQualityService airQualityService = new AirQualityService(latitude, longitude, token);

        airQualityService.getAirQualityData()
            .thenAccept(response -> {
                System.out.println("Datos de calidad del aire recibidos:");

                Gson gson = new Gson();
                AirQualityResponse airQualityResponse = gson.fromJson(response, AirQualityResponse.class);

                String cityName = airQualityResponse.getData().getCity().getName();

                System.out.println("La ciudad es: " + cityName);
            })
            .join();
    }
}
