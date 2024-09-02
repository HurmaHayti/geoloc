package com.geoapp.services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.geoapp.utils.Utils.getEnvVariable;

public class GeoService {
    private static final String GEO_API_URL = "http://api.openweathermap.org/geo/1.0/";
    private static final String COUNTRY_CODE = "US";


    public JSONObject getGeoLocation(String location) throws Exception {
        if (location.matches("\\d{5}")) { // ZIP Code
            return getGeoLocationByZip(location);
        } else { // City, State
            return getGeoLocationByCityState(location);
        }
    }

    private JSONObject getGeoLocationByCityState(String location) throws Exception {
        String[] parts = location.split(",");
        String city = parts[0].trim();
        String state = parts.length > 1 ? parts[1].trim() : "";

        String urlString = GEO_API_URL + "direct?q=" + city + "," + state + "," + COUNTRY_CODE + "&limit=1&appid=" + getEnvVariable("apikey");
        return getGeoLocationFromAPI(urlString, "city");
    }

    private JSONObject getGeoLocationByZip(String zip) throws Exception {
        String urlString = GEO_API_URL + "zip?zip=" + zip + "," + COUNTRY_CODE + "&appid=" + getEnvVariable("apikey");
        return getGeoLocationFromAPI(urlString, "zip");
    }

    private JSONObject getGeoLocationFromAPI(String urlString, String type) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if (type.equals("city")) {
                JSONArray jsonArray = new JSONArray(response.toString());
                if (jsonArray.length() > 0) {
                    return jsonArray.getJSONObject(0);
                }
            } else {
                return new JSONObject(response.toString());
            }
        }
        return null;
    }
}
