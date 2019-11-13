package com.cd.automationtemplate.suites.tests.login;

import com.cd.automationtemplate.suites.config.Constants;
import com.cd.automationtemplate.suites.tests.BaseWebAutomationTest;
import com.cd.automationtemplate.suites.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseWebAutomationTest {

    @BeforeClass
    public void initialization() {
        //LoginPage loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        this.loginPage.login();
        Wait.waitShort();
        Assert.assertTrue(Constants.Urls.DASHBOARD_PAGE.contains(this.loginPage.currentUrl()));
    }

    @AfterClass
    public void tearDown() {
        this.loginPage.close();
    }
}
