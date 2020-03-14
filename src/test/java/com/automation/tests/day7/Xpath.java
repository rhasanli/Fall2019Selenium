package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";

    public static String userPassword = "//label[text()='Password']/following-sibling::input";

    public static String clickLogin ="//button[contains(text(), 'Login')]";

    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        drv.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");


        drv.findElement(By.xpath(userPassword)).sendKeys("SuperSecretPassword");

        drv.findElement(By.xpath(clickLogin)).click();




        BrowserUtils.wait(3);
        drv.quit();


    }
}
