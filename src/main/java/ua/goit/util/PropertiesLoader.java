package ua.goit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try (InputStream is = getInputStream(PROPERTIES_FILE_NAME)) {
            PROPERTIES.load(is);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getProperty(String name) {
        return PROPERTIES.getProperty(name);
    }

    public static InputStream getInputStream(String filename) {
        return PropertiesLoader.class.getClassLoader().getResourceAsStream(filename);
    }
}
