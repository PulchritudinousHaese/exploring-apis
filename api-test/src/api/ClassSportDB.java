package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassSportDB implements SportDB {
    private static final String API_URL = "https://api.sportmonks.com/v3/core/countries?api_token=QitEucGKAXbCkSJAboUWB4FMyECopeJ5iPoR3BMaHfxuIrVPkhab5hyCKIkD&include=";

    /*
    * Returns API Token.
    * */
    public static String getApiToken() {
        return "QitEucGKAXbCkSJAboUWB4FMyECopeJ5iPoR3BMaHfxuIrVPkhab5hyCKIkD";
    }

    /*
    * Test usage of the API of SportMonkeys to retrieve countries.
    * Simply prints the output of the API request.
    */

    @Override
    public void getCountries() {
        HttpClient testClient = HttpClient.newHttpClient(); // Create new HTTPClient to make request

        HttpRequest testRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build(); // Make new request
        try { // Catch Errors
            // Get response
            HttpResponse<String> response = testClient.send(testRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println(response.body()); // Print result status
            } else {
                System.out.println("STATUS CODE FAILURE: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
