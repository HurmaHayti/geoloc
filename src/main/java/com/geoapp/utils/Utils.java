package com.geoapp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    public static String getEnvVariable(String envVariableName) {
        Properties properties = System.getProperties();
        String apiKey = properties.getProperty(envVariableName);

        if (apiKey == null || apiKey.isEmpty()) {
            try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/data.properties"))) {
                properties.load(input);
                apiKey = properties.getProperty(envVariableName);
            } catch (IOException ex) {
                System.out.println("Please provide apikey per readme file");
            }
        }
        return apiKey;
    }
}

