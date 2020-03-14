package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();
        drv.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        drv.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        List<WebElement> link = drv.findElements(By.id("disappearing_button"));
        if (link.size() == 0) { // drv.findElements(By.id("disappearing_button")).size() == 0
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        Thread.sleep(2000);

        // to find all buttons
        List<WebElement> buttons = drv.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            button.click(); // click on every button
            Thread.sleep(2000);

        }


        drv.quit();


    }
}
