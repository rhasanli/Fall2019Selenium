package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOption {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();
        drv.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select languagesSelect = new Select(drv.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple); // --> if it's true, we can select more than one option
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        // lets get all selected option
        List<WebElement> selectedLangs = languagesSelect.getAllSelectedOptions();
        for (WebElement selectedLang : selectedLangs) {
            System.out.println(selectedLang.getText());

        }
        BrowserUtils.wait(3);

        languagesSelect.deselectByVisibleText("Java"); // to deselect
        BrowserUtils.wait(3);

        languagesSelect.deselectAll();

        BrowserUtils.wait(3);
        drv.quit();
    }
}
