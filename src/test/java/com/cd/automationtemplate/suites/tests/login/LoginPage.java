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

    protected void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
    }

    protected String currentUrl() {
        return this.driver.getCurrentUrl();
    }

    protected void clearInput() {
        this.username.clear();
        this.password.clear();
    }

    protected void close() {
        this.driver.quit();
    }
}
