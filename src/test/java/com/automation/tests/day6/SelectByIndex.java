package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();

        drv.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect = new Select(drv.findElement(By.id("state")));
        // index starts from 0
        stateSelect.selectByIndex(9); // should be DC

        List<WebElement> stateLst = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {
            count++;
            System.out.println( count + " = " +eachState.getText());
        }

        BrowserUtils.wait(2);
        drv.quit();
    }
}
