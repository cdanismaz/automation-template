package com.cd.automationtemplate.suites.tests.login;

import com.cd.automationtemplate.suites.config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    protected void login() {
        this.username.sendKeys(Constants.Credentials.VALID_USERNAME);
        this.password.sendKeys(Constants.Credentials.VALID_PASSWORD);
        this.submitButton.click();
    }

    protected String currentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void close() {
        this.driver.quit();
    }
}
