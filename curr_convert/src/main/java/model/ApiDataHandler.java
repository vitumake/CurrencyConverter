package model;


// Currency conversion class. 
// A singleton class that handles updating and retrevial of currency exchange rates.

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.*;
import entity.Currency;


public class ApiDataHandler {
    // Using NBP API to generate currency exchange rate tabel.
    private static final String api = "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=json";

    // This function updates the database with data from the NBP API.
    public List<Currency> retrieveRates() {
        
        try {
            // Get rates JSON from API.
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(java.net.URI.create(api)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonStr = response.body();
            
            // If response is not what is expected, return false.
            try {
                JSONArray resp = new JSONArray(jsonStr);
                JSONObject jsonObj = resp.getJSONObject(0);
                JSONArray ratesArr = jsonObj.getJSONArray("rates");

                // Create list of currencies.
                List<Currency> currencies = new ArrayList<Currency>();
                for(int i=1; i<ratesArr.length(); i++) {
                    JSONObject rate = ratesArr.getJSONObject(i);
                    String code = rate.getString("code");
                    double rateVal = rate.getDouble("mid");
                    currencies.add(new Currency(code, rateVal));
                }
                return currencies;

            } catch (JSONException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.print("Error: " + e.getMessage());
        }
        return null;
    }
}
