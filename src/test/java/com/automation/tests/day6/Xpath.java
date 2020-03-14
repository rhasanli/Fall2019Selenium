package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);
        //value can be inside '' or ""
        //if you don't know the tag name, or want to skip tag name, use *
        //for example //*[@onclick='button1()']  | * means any tag name
        WebElement btn1 = drv.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();
        BrowserUtils.wait(2);

        WebElement result = drv.findElement(By.id("result"));
        System.out.println(result.getText());

        WebElement btn2 = drv.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());
        BrowserUtils.wait(2);

        WebElement btn3 = drv.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = drv.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        btn4.click();
        System.out.println(result.getText());
        BrowserUtils.wait(2);

        WebElement btn5 = drv.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();
        System.out.println(result.getText());
        BrowserUtils.wait(2);


        BrowserUtils.wait(2);
        drv.quit();
    }
}
