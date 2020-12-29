package data;

import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesGetter {

    private static String pathToProperties = "src\\main\\resources\\config.properties";
    static FileInputStream fis;
    static java.util.Properties property;

    public String getProperty(String nameOfProperty) throws IOException {
        try {
            fis = new FileInputStream(pathToProperties);
            property = new java.util.Properties();
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (property.getProperty(nameOfProperty));
    }
}
