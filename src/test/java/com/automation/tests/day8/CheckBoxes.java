package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes {
    private WebDriver driver;

    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void forgotPassword() {
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);
        // locator for specific checkbox, xpath: //input[1], cssSelector: input:nth-of-type(1)
        // collect all boxes

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(3);
        checkboxes.get(0).click();
        BrowserUtils.wait(3);
        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected");

        // another way
//        driver.findElements(By.xpath("//input[@type='checkbox'][1]")).get(0).click();
//        driver.findElements(By.xpath("//input[@type='checkbox'][1]")).get(0).isSelected();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}