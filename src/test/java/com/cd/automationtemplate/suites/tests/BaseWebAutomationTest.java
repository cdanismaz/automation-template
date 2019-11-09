package com.cd.automationtemplate.suites.tests;

import com.cd.automationtemplate.suites.config.Constants;
import com.cd.automationtemplate.suites.tests.login.LoginPage;
import com.cd.automationtemplate.suites.utils.Wait;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.text.MessageFormat;


@Slf4j
public class BaseWebAutomationTest extends BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setupClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("keep-alive-for-test");
        options.addArguments("dns-prefetch-disable");
        options.addArguments("--incognito");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        log.info("Creating new Chrome driver");
        this.driver = new ChromeDriver(options);

        this.loginPage = this.navigateToLoginPage();
        Wait.waitDefault();
    }

    @AfterClass
    public void cleanUpClass() {
        log.info("Closing Chrome driver");
        this.driver.quit();
    }

    @AfterMethod
    public void logFailedTest(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            log.error(MessageFormat.format("TEST FAILED: {0}.{1} is failed!",
                    result.getMethod().getTestClass().getName(),
                    result.getMethod().getMethodName()));
        }
    }

    protected LoginPage navigateToLoginPage() {
        log.info("Navigating to login page");
        this.driver.navigate().to(Constants.Urls.LOGIN_PAGE);
        return PageFactory.initElements(this.driver, LoginPage.class);
    }
}
