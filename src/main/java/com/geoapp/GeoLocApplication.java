package com.geoapp;

import com.geoapp.services.GeoService;
import org.json.JSONObject;

public class GeoLocApplication {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide at least one location.");
            return;
        }

        GeoService service = new GeoService();
        for (String location : args) {
            JSONObject result = service.getGeoLocation(location);
            if (result != null && !result.isEmpty()) {
                System.out.println("Results for " + location + ":");
                System.out.println(result.toString(2));
                System.out.println("------------------------------------");
            } else {
                System.out.println("No data found for: " + location);
            }
        }
    }
}
