package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {

    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle() {
        // test --> ExtentTest object
        // we must add to every test at the beginning
        // test = report.createTest ("Test name")
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        // like system.out , but it goes to report as well
        test.info("Login as store manager"); // log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        System.out.println(Driver.getDriver().getTitle());
        // if assertion passed, it will print message
        test.pass("Page title Dashboard was verified");

    }

    /**
     * Login with wrong credentials
     */
    @Test
    public void verifyWarningMessage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        // take a screenshot
        BrowserUtils.getScreenshot("loginPage");

    }
}

