package com.geoapp.integration;

import com.geoapp.services.GeoService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeoLocApplicationTests {

    @Test
    public void testGetGeoLocationByCityState_Valid() throws Exception {
        GeoService service = new GeoService();
        JSONObject result = service.getGeoLocation("Madison, WI");

        assertNotNull(result);
        assertEquals("Madison", result.getString("name"));
        assertEquals("Wisconsin", result.getString("state"));
    }

    @Test
    public void testGetGeoLocationByZip_Valid() throws Exception {
        GeoService service = new GeoService();
        JSONObject result = service.getGeoLocation("12345");

        assertNotNull(result);
        assertEquals("Schenectady", result.getString("name"));
    }

    @Test
    public void testGetGeoLocationCity_Invalid() throws Exception {
        GeoService service = new GeoService();
        JSONObject result = service.getGeoLocation("InvalidCity, ZZ");

        assertNull(result);
    }

    @Test
    public void testGetGeoLocationZip_Invalid() throws Exception {
        GeoService service = new GeoService();
        JSONObject result = service.getGeoLocation("0000000");

        assertNull(result);
    }

    @Test
    public void testGetGeoLocationEmpty_Invalid() throws Exception {
        GeoService service = new GeoService();
        JSONObject result = service.getGeoLocation(" ");

        assertNull(result);
    }
}
