package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver drv = DriverFactory.createADriver("chrome");
        drv.get("http://practice.cybertekschool.com/checkboxes");
        drv.manage().window().maximize();
        BrowserUtils.wait(2);

        // verify that 1st check box is not selected and 2nd is selected
        List<WebElement> checkBoxes = drv.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

//        if (checkBoxes.get(1).isSelected()) {
//            System.out.println("Selected");
//        } else {
//            System.out.println("Not Selected");
//        }
        BrowserUtils.wait(2);
        // let's click on the first checkbox  and verify it's clicked

        WebElement checkBox1= checkBoxes.get(0); // to get 1st checkbox
        checkBox1.click();
        if (checkBox1.isSelected()){
            System.out.println("PASSED");
            System.out.println("CheckBox 1 is selected");
        }else {
            System.out.println("NOT PASSED");
            System.out.println("CheckBox 1 is not selected");
        }




        drv.quit();
    }
}
