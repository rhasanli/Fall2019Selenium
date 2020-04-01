package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Template {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    String username = "storemanager85";
    String password = "UserUser123";

    private By fleetBy = By.cssSelector("[class='dropdown dropdown-level-1']");
    private By subtitleBy = By.className("oro-subtitle");

    @Test(description = "navigate to Fleet --> Vehicles and verify that page subtitle is equals to \"All Cars\"")
    public void VehiclesPageTests() {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        driver.findElement(fleetBy).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);
        WebElement subtitleElement=driver.findElement(subtitleBy);
        System.out.println(subtitleElement.getText());



    }


    @BeforeMethod

    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }

    }
}