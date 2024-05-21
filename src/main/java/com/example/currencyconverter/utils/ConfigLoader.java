package main.java.com.example.currencyconverter.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "config.properties";
    private static final String API_KEY_PROPERTY = "apiKey";

    public static String loadApiKey() {
        Properties properties = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IOException("Não foi encontrado o arquivo de configurações " + CONFIG_FILE);
            }
            properties.load(input);
            return properties.getProperty(API_KEY_PROPERTY);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
