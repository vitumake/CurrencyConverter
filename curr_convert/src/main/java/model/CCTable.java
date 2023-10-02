package model;


// Currency conversion class. 
// A singleton class that handles updating and retrevial of currency exchange rates.

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.json.*;
import com.opencsv.CSVReader;


public class CCTable {
    // Using NBP API to generate currency exchange rate tabel.
    private static final String api = "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=json";
    private static final String csv = "rates.csv";
    private List<List<String>> rates = new ArrayList<List<String>>();

    public CCTable() {
        if(!new File(csv).exists()) {
            updateRates();
        } else {
            updateHashMap();
        }
    }

    private void updateHashMap() {
        try (CSVReader csvReader = new CSVReader(new FileReader(csv));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                rates.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // This function updates the csv file with data from the NBP API.
    public boolean updateRates() {
        
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
                File file = new File(csv);
                file.delete();
                FileUtils.writeStringToFile(file, CDL.toString(ratesArr), "UTF-8", true);

                System.out.println("Rates retrieved.");
                // Update rates HashMap.
                updateHashMap();
                return true;
            } catch (JSONException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.print("Error: " + e.getMessage());
        }
        return false;
    }

    public Double getRate(String currency) {
        for(List<String> rate : rates) {
            if(rate.get(0).equals(currency)) {
                return Double.parseDouble(rate.get(1));
            }
        }
        return null;
    }

    public String[] getCurrencies() {
        String[] currencies = new String[rates.size()-1];
        for(int i=0; i<rates.size()-1; i++) {
            String currency = rates.get(i).get(0);
            if(!currency.equals("code")) {
                currencies[i] = currency;
            }
        }
        return currencies;
    }
}
