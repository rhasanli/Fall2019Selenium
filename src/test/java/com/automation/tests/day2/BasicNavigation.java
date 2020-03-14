package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup(); // class
        ChromeDriver driver = new ChromeDriver(); // class to create webdriver object

        // WebDriver drv = new FirefoxDriver();

        //In selenium, everything starts from WebDriver interface'
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://www.google.com"); // to open website
        driver.manage().window().maximize(); // to maximize browser

        String title = driver.getTitle(); //returns <title>Some title</title> text
        String expectedTitle = "Google";
        System.out.println("Title is ..." + title);

        if (expectedTitle.equalsIgnoreCase(title)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        Thread.sleep(2000); //for demo, wait 2 seconds before next step

        // go to another website
        driver.navigate().to("http://amazon.com");
        Thread.sleep(2000); //for demo, wait 2 seconds before next step
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("Ok");
        } else {
            System.out.println("Not Ok");
        }

        // go back to google
        // getTitle() returns page Title
        driver.navigate().back();
        Thread.sleep(2000); //for demo, wait 2 seconds before next step
        verifyEquals(driver.getTitle(), "Google");
        driver.navigate().forward();
        Thread.sleep(2000); //for demo, wait 2 seconds before next step
        System.out.println("Title : "+driver.getTitle());
        System.out.println("URL : "+driver.getCurrentUrl());
        driver.navigate().refresh();
        Thread.sleep(2000); //for demo, wait 2 seconds before next step

        driver.close(); // to close website

}

    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equalsIgnoreCase(arg2)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
    }
}
