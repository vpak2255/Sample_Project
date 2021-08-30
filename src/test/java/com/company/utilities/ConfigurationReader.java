package com.company.utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties;
    public static OutputStream logfile;


    static {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            Files.newBufferedWriter(Paths.get("src/test/resources/logs.txt"), StandardOpenOption.TRUNCATE_EXISTING);
            logfile = new FileOutputStream("src/test/resources/logs.txt", true);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
