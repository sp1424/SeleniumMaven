package simpleHTTP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonPlaceholderHttpHandler {

    private static final String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/users/%s";

    private static final String EMPTY_JSON = "{}";

    private final HttpClient client;

   public JsonPlaceholderHttpHandler()
   {
       this.client = HttpClient.newHttpClient();
   }

    /**
     *
     * @param developerIndex - depending on this number we would retrieve different data
     * @return String
     * @throws IOException - can be thrown due to send or receive errors
     * @throws InterruptedException - thrown if connection is interrupted
     */
   public String getPersonJsonData(int developerIndex) throws Exception {
       HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(String.format(JSON_PLACEHOLDER_URL, developerIndex)))
               .build();

       HttpResponse<String> response =  this.client.send(request, HttpResponse.BodyHandlers.ofString());

       if (response.body().equals(EMPTY_JSON)) {
           throw new Exception("Json Retrieved is empty please check developer index");
       }

       return response.body();
   }
}
