package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import javax.security.auth.login.Configuration;
import java.io.IOException;

public abstract class AbstractTestBase {

    protected WebDriverWait wait; // create object
    protected Actions actions; // create object

    protected ExtentReports report; // create object
    protected ExtentHtmlReporter htmlReporter; // create object
    protected ExtentTest test; // create object

    @BeforeTest
    public void setupTest() {
        report = new ExtentReports();
        String reportPath = "";
        // location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        // is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        // add it to the report
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Result");
    }

    @AfterTest
    public void afterTest() {
        report.flush(); // to release a report
    }

    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());

    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        // ITestResult class describes the result of the test
        // if test failed , take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // screenshot will have a name of the test
            BrowserUtils.getScreenshot(iTestResult.getName());

            String screenshotPath= BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshotPath, "Failed"); // attache screenshot
            BrowserUtils.wait(1);
            test.fail(iTestResult.getName()); // attach test name that failed
            test.fail(iTestResult.getThrowable()); // attach console output
        }

        Driver.closeDriver();

    }

}
