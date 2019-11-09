package com.cd.automationtemplate.suites;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

@Slf4j
public class BaseSuite {

    @BeforeSuite
    public void beforeSuite() {
//        log.info("Before suite started");
//        List<String> propertiesFileList = this.getPropertiesFileList();
//        PropertyManager.initProperties(propertiesFileList);
//
//        System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.chrome.driver"));
//        System.setProperty("webdriver.gecko.driver", PropertyManager.getProperty("path.firefox.driver"));
//
//        logger.info("Before suite ended... Starting test classes");
    }

//    protected abstract List<String> getPropertiesFileList();

}
