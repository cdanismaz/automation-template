package com.cd.automationtemplate.suites.tests.login;

import com.cd.automationtemplate.suites.config.Constants;
import com.cd.automationtemplate.suites.tests.BaseWebAutomationTest;
import com.cd.automationtemplate.suites.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseWebAutomationTest {

    @BeforeClass
    public void initialization() {
        //LoginPage loginPage = new LoginPage(driver);
    }

    @Test(priority = 3)
    public void validLoginTest() {
        this.loginPage.login(Constants.Credentials.VALID_USERNAME, Constants.Credentials.VALID_PASSWORD);
        Wait.waitShort();
        Assert.assertTrue(Constants.Urls.DASHBOARD_PAGE.contains(this.loginPage.currentUrl()));
    }

    @Test(priority = 0)
    public void invalidLoginTest() {
        this.loginPage.login(Constants.Credentials.INVALID_USERNAME, Constants.Credentials.INVALID_PASSWORD);
    }



    @Test(priority = 1)
    public void blankUsernameLoginTest() {
        this.loginPage.login(" ", Constants.Credentials.VALID_PASSWORD);
    }

    @Test(priority = 2)
    public void blankPasswordLoginTest() {
        this.loginPage.login(Constants.Credentials.VALID_USERNAME, " ");
    }

    @AfterMethod
    public void clearInputs() {
        this.loginPage.clearInput();
    }

    @AfterClass
    public void tearDown() {
        this.loginPage.close();
    }
}
