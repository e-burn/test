package dataManagment.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesController
{
    private static Properties properties_;
    private static String propertiesPath = "src\\main\\resources\\config.properties";
    public static void loadProperties()
    {
        try {
            FileInputStream fis = new FileInputStream(propertiesPath);
            properties_ = new Properties();
            properties_.load(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName)
    {
        return properties_.getProperty(propertyName);
    }
}
