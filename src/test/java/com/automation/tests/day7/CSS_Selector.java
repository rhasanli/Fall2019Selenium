package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_Selector {
    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        WebElement heading = drv.findElement(By.cssSelector(".h3"));
        WebElement home = drv.findElement(By.cssSelector(".nav-link"));
        WebElement btn1 = drv.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement btn2 = drv.findElement(By.cssSelector("[name='button2']"));
        WebElement btn3 = drv.findElement(By.cssSelector("[id^='button_']"));
        WebElement btn4 = drv.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement btn5 = drv.findElement(By.cssSelector("[id='unity']"));
        WebElement btn6 = drv.findElement(By.cssSelector("#disappearing_button")); // id
        btn1.click();
        BrowserUtils.wait(1);
        btn2.click();
        BrowserUtils.wait(1);
        btn3.click();
        BrowserUtils.wait(1);
        btn4.click();
        BrowserUtils.wait(1);
        btn5.click();
        BrowserUtils.wait(1);
        btn6.click();


        BrowserUtils.wait(3);
        drv.quit();

    }
}
