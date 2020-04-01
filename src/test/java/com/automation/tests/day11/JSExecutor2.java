package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle() {
        String expectedTitle = "Practice";
        // we created JavaScript Executor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // executeScript - this method executes javascript code
        //we provide js code as a string

        // casting from Object to String
        // String actual = (String) js.executeScript("return document.title");

        // .toString() to avoid additional casting from Object to String
        String actual = js.executeScript("return document.title").toString();
        // return document.title --> JS code
        // document represents HTML page

        Assert.assertEquals(actual, expectedTitle);
    }

    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));

        //        disable this click action ,to perform it with js executor
        //        link.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after ,
        //use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        //from left - to right

        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void textInputText() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to get text from input box - read attribute "value"
        // to enter text - set attribute "value"
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

        BrowserUtils.wait(2);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = js.executeScript("return document.getElementByClassName('subheader')[0].textContent").toString();
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void scrollToElementTest() {
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);

    } @Test
    public void scrollTextTest() {
        //navigate().to() method calls get method, =>  within same window to go another url
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll"); // similar to get
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i <15 ; i++) {
            js.executeScript("window.scrollBy(0, 1000)"); // scroll 1000 pixels

        }


    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

}
