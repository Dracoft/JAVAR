import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientService {
    private HttpClient client;

    public HttpClientService() {
        this.client = HttpClient.newHttpClient();
    }

    public CompletableFuture <String> sendRequest(String apiUrl) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

}
