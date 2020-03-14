package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    // INTERVIEW QUESTION
    public static void main(String[] args) throws InterruptedException, Exception {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver drv = new ChromeDriver();
        drv.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        // how to collect all links from the page?
        List<WebElement> links = drv.findElements(By.tagName("a"));

        for (WebElement link : links) {  // foreach NOT WORKING FOR THIS LOGIC
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();

        }

        for (int i = 1; i < links.size(); i++) { // 1 -- to skip first link
            links.get(i).click();
           // Thread.sleep(2000);
            drv.navigate().back();
            // refresh list
                   links = drv.findElements(By.tagName("a"));
        }


        drv.quit();

    }
}
