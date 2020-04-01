package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionsTest {

    private WebDriver driver;
    private Actions actions;
    private Actions actions1;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        // build() is needed when you have couple of actions
        // always end with perform()
        // pause(1000) - like Thread.sleep(1000)
        actions.moveToElement(img1).pause(1000).moveToElement(img2).
                pause(1000).moveToElement(img3).build().perform();

//        List<WebElement> images = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath("(//img)[1]")),
//                driver.findElement(By.xpath("(//img)[2]")),
//                driver.findElement(By.xpath("(//img)[3]"))));
//        for (WebElement each : images) {
//            actions.moveToElement(each).pause(1000).build().perform();
//        }

        // hover on the first image verify that "name: user" is displayed
        // hover over the image to make text visible

//        List<WebElement> imgText = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath("(//h5)[1]")),
//                driver.findElement(By.xpath("(//h5)[2]")),
//                driver.findElement(By.xpath("(//h5)[3]"))));
//
//        for (WebElement userN : imgText) {
//            actions.moveToElement(userN).pause(1000).build().perform();
//        }
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

        actions.moveToElement(img3).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());

    }

    @Test
    public void jqueryMenuTest() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        // hover on "enabled"
        // hover on "downloads"
        // click on PDF
        WebElement enabled = driver.findElement(By.cssSelector("#ui-id-3"));
        WebElement download = driver.findElement(By.cssSelector("#ui-id-4"));
        WebElement pdf = driver.findElement(By.cssSelector("#ui-id-5"));
        actions.moveToElement(enabled).pause(1000).
                moveToElement(download).pause(1000).
                click(pdf).build().perform();


    }

    @Test
    public void dragAndDropTest() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon, earth).perform();
        BrowserUtils.wait(2);

        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(expected, actual);
        System.out.println("Expected \"" + expected + "\" vs " + " Actual \""+ actual+"\"" );


    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
