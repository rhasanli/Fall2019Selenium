package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);
        List<WebElement> buttons = drv.findElements(By.tagName("button"));

        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(2);
        // to get the text from popup message
        String popupText = drv.switchTo().alert().getText();
        drv.switchTo().alert().accept(); // to click Ok

        System.out.println(popupText);
        String expectedText = "You successfully clicked an alert";
        String actualText = drv.findElement(By.id("result")).getText();
        if (expectedText.equals(actualText)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expectedText);
            System.out.println("Actual: " + actualText);
        }
        BrowserUtils.wait(2);
        System.out.println("----------------------");

        buttons.get(1).click(); // click 2nd button
        BrowserUtils.wait(2);

        String popupText1 = drv.switchTo().alert().getText();
        System.out.println(popupText1);
        // to click cancel
        drv.switchTo().alert().dismiss();
        String expectedText1 = "You clicked: Cancel";
        String actualText1 = drv.findElement(By.id("result")).getText();
        if (expectedText1.equals(actualText1)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expectedText1);
            System.out.println("Actual: " + actualText1);
        }
        BrowserUtils.wait(2);

        // click on button 3 then enter some text
        buttons.get(2).click();
        BrowserUtils.wait(2);
        String popupText2 = drv.switchTo().alert().getText();
        System.out.println(popupText2);

//        drv.switchTo().alert().sendKeys("Hello Word");
//        drv.switchTo().alert().accept();

        Alert alert = drv.switchTo().alert();
        alert.sendKeys("Hello Word");
        BrowserUtils.wait(2);
        alert.accept();

        String expectedText2 = "You entered: Hello Word";
        String actualText2 = drv.findElement(By.id("result")).getText();

        if (expectedText2.equals(actualText2)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expectedText2);
            System.out.println("Actual: " + actualText2);
        }
        BrowserUtils.wait(2);


        BrowserUtils.wait(2);
        drv.quit();
    }
}
