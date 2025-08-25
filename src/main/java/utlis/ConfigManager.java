package utlis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    public static void loadProperties() throws IOException {
        properties = new Properties();
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties") ) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties file");
        }
    }

    public static String getProperty(String key) throws IOException {
        if (properties == null)
        {
            loadProperties();
        }
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value)
    {
        try (FileOutputStream output = new FileOutputStream("src/test/resources/outputData.properties")) {
            properties.setProperty(key,value);
            properties.store(output,"updated property file");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load outputData.properties file");
        }

    }

}
