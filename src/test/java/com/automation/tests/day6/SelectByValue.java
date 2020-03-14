package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();

        drv.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect = new Select(drv.findElement(By.id("state")));

        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();
        if (actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        BrowserUtils.wait(2);
        drv.quit();

    }
}
