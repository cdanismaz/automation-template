package com.cd.automationtemplate.tests;

import com.cd.automationtemplate.utils.PropertyManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseSuite {

    @BeforeSuite
    public void beforeSuite() throws IOException {
        log.info("Before suite started");

        // read the APP_SELENIUM_DRIVER environment variable : The relative path to driver
        final String driverRelativePath = System.getenv("APP_SELENIUM_DRIVER");

        // Convert the relative path to full path (absolute path)
        String driverPath = Thread.currentThread().getContextClassLoader().getResource(driverRelativePath).getPath();

        // Set driver system property
        System.setProperty("webdriver.chrome.driver", driverPath);

        List<String> propertiesFileList = this.getPropertiesFileList();
        PropertyManager.initProperties(propertiesFileList);

        log.info("Suite initialization completed. Starting tests...");
    }

    protected List<String> getPropertiesFileList() {
        List<String> propertyFileList = new ArrayList<>();
        propertyFileList.add("config/application.properties");
        return propertyFileList;
    }

}
