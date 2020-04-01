package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert.*;

import java.util.List;


public class VehiclesTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    String username = "storemanager85";
    String password = "UserUser123";

    private By fleetBy = By.cssSelector("[class='dropdown dropdown-level-1']");
    private By subtitleBy = By.className("oro-subtitle");

    @Test(description = "navigate to Fleet --> Vehicles and verify that page subtitle is equals to \"All Cars\"")
    public void verifyPageSubTitle() {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(fleetBy).click();
        Actions actions = new Actions(driver);
        // move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform -- to execute command
        // every action should end with perform()
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        WebElement subtitleElement = driver.findElement(subtitleBy);
        System.out.println(subtitleElement.getText());

        String expected = "All Cars";
        String actual = subtitleElement.getText();
        Assert.assertEquals(actual, expected, "Not visible");

    }

    @Test(description = "get into fleet")
    public void flee() {
        List<WebElement> modules = driver.findElements(By.className("title title-level-1"));
        modules.get(0).click();
        List<WebElement> list = driver.findElements(By.className("dropdown-menu-wrapper dropdown-menu-wrapper__scrollable"));
        list.get(0).click();
        String Expected = "All Cars";
        String Actual = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(Actual, Expected, "is not same");}

        @Test (description = "verifies that page number is equals to 1")
        public void verifyPageNumber(){
            driver.findElement(By.xpath("//label[text()='Page:']/..//input"));

        }

        @BeforeMethod

        public void setup () {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.get(URL);
            driver.manage().window().maximize();

            // login
            driver.findElement(usernameBy).sendKeys(username);
            driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
            BrowserUtils.wait(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(fleetBy)).perform();
            BrowserUtils.wait(3);
            driver.findElement(By.linkText("Vehicles")).click();
            BrowserUtils.wait(5);
        }

        @AfterMethod
        public void teardown () {
            //if webdriver object alive
            if (driver != null) {
                //close browser, close session
                driver.quit();
                //destroy webdriver object for sure
                driver = null;
            }

        }
    }