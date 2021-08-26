package com.company.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
