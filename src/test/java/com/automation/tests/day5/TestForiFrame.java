package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        driver.switchTo().frame("mce_0_ifr");

        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());
        BrowserUtils.wait(2);

        textInput.clear();
        textInput.sendKeys("HELLO WORD");


        BrowserUtils.wait(2);

        driver.switchTo().defaultContent();
        WebElement heading =driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        driver.quit();
    }
}
