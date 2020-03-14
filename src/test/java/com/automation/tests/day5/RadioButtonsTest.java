package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = drv.findElement(By.id("black"));

        // if visible and eligible to click
        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("Clicked on black button");
            blackButton.click();
        }else {
            System.out.println("Failed to click on black button");
        }


        //  verify that button Clicked
        // return true if button clicked
        if (blackButton.isSelected()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }


        drv.quit();


    }
}
