package ru.mail.helpers;


import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private Properties properties = new Properties();

    public ConfigurationManager() {
        try {
            properties.load(ConfigurationManager.class.getResourceAsStream("/configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
