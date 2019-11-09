package com.cd.automationtemplate.suites.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public void readPropertiesFile(String path, Properties properties) throws IOException {
        InputStream propertiesStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        properties.load(propertiesStream);
    }
}
