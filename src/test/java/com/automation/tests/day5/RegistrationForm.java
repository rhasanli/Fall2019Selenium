package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();

        drv.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);

        drv.findElement(By.name("firstname")).sendKeys("Ramil");
        drv.findElement(By.name("lastname")).sendKeys("Hasan");
        drv.findElement(By.name("username")).sendKeys("RamilH");
        drv.findElement(By.name("email")).sendKeys("9161290m@gmail.com");
        drv.findElement(By.name("password")).sendKeys("secretpassword");
        drv.findElement(By.name("phone")).sendKeys("100-123-4567");

        List<WebElement> genders = drv.findElements(By.name("gender"));
        genders.get(0).click();

        drv.findElement(By.name("birthday")).sendKeys("01/01/2007");
        drv.findElement(By.id("inlineCheckbox2")).click();

        drv.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(5);

        drv.quit();


    }
}
