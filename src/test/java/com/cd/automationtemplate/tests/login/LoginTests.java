package com.cd.automationtemplate.tests.login;

import com.cd.automationtemplate.config.Constants;
import com.cd.automationtemplate.tests.BaseWebAutomationTest;
import com.cd.automationtemplate.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseWebAutomationTest {

    @Test(priority = 3)
    public void validLoginTest() {
        this.loginPage.login(Constants.Credentials.VALID_USERNAME, Constants.Credentials.VALID_PASSWORD);
        Wait.waitShort();
        Assert.assertTrue(Constants.Urls.DASHBOARD_PAGE.contains(this.loginPage.currentUrl()));
    }

    @Test(priority = 0)
    public void invalidLoginTest() {
        this.loginPage.login(Constants.Credentials.INVALID_USERNAME, Constants.Credentials.INVALID_PASSWORD);
        Wait.waitShort();
        Assert.assertEquals(this.loginPage.errorMessageDisplayed(), "Invalid username or password.");
        this.loginPage.clearInput();
    }



    @Test(priority = 1)
    public void blankUsernameLoginTest() {
        this.loginPage.login(" ", Constants.Credentials.VALID_PASSWORD);
        Wait.waitShort();
        Assert.assertEquals(this.loginPage.errorMessageDisplayed(), "Invalid username or password.");
        this.loginPage.clearInput();
    }

    @Test(priority = 2)
    public void blankPasswordLoginTest() {
        this.loginPage.login(Constants.Credentials.VALID_USERNAME, " ");
        Wait.waitShort();
        Assert.assertEquals(this.loginPage.errorMessageDisplayed(), "Invalid username or password.");
        this.loginPage.clearInput();
    }
}
