package com.cd.automationtemplate.utils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PropertyManager {
    private static PropertyReader propertyReader;
    private static Properties properties;

    public static void initProperties(List<String> propertiesFileList) throws IOException {
        propertyReader = new PropertyReader();

        properties = new Properties();
        for (int i = 0; i < propertiesFileList.size(); i++) {
            propertyReader.readPropertiesFile(propertiesFileList.get(i), properties);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getWebUrlProperty(String key) {
        return getWebUrlProperty(key, "http://");
    }

    public static String getSecureWebUrlProperty(String key) {
        return getWebUrlProperty(key, "https://");
    }

    private static String getWebUrlProperty(String key, String prefix) {
        String value = properties.getProperty(key);
        if (!value.startsWith(prefix)) {
            value = prefix + value;
        }
        return value;
    }
}
