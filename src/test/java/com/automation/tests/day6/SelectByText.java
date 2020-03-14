package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver drv = new ChromeDriver();
        drv.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        //create a webelement object for drop-down first
        WebElement simpleDropdown = drv.findElement(By.id("dropdown"));
        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text - Option 2
        selectSimpleDropdown.selectByVisibleText("Option 2");
        // option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(drv.findElement(By.id("year")));
        Select selectMonth = new Select(drv.findElement(By.id("month")));
        Select selectDay = new Select(drv.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("25");

        //select all months one by one
        //.getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth : months) {
            //get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            selectDay.selectByVisibleText("25");
            BrowserUtils.wait(1);
        }

        Select stateSelect = new Select(drv.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        // option that currently selected
        // getFirstSelectedOption() -- returns a webelement, that's why we need to call getText
        // getText retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if (selected.equals("District Of Columbia")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement statesOption : states) {
            System.out.println(statesOption.getText()); // will print all states in the consul
        }

        BrowserUtils.wait(3);
        drv.quit();
    }
}
