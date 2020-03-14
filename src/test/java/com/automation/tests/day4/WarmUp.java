package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {

    static WebDriver drv;

    public static void main(String[] args) throws Exception {

        ebay();
        amazon();
        wikiTest();

    }

    /**
     * Go to ebay
     * enter search term
     * click on search button
     * print number of results
     */
    public static void ebay() throws InterruptedException {
        drv = DriverFactory.createADriver("chrome");
        drv.get("http://ebay.com");
        drv.findElement(By.id("gh-ac")).sendKeys("java book"); // enter search term
        drv.findElement(By.id("gh-btn")).click(); //click on search button
        WebElement searchResult = drv.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText().split(" ")[0]); // print number of results
        Thread.sleep(3000);

        drv.quit();
    }

    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazon() throws InterruptedException {
        drv = DriverFactory.createADriver("chrome");
        drv.get("http://amazon.com");
        // enter text and click ENTER
        drv.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER); //enter search term and click on search button
        String title = drv.getTitle(); // verify title contains search term
        if (title.contains("java book")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        Thread.sleep(3000);

//        WebElement searchResult1 = drv.findElement(By.tagName("a-section a-spacing-small a-spacing-top-small"));
//        System.out.println(searchResult1.getText().split(" ")[0]); // print number of results


        drv.close();
    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wikiTest() throws Exception {
        drv = DriverFactory.createADriver("chrome");
        drv.get("https://en.wikipedia.org/wiki/Main_Page");

        drv.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        drv.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = drv.getCurrentUrl(); // to get link as a String

        if (link.endsWith("Selenium_(software)")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        drv.quit();
    }


}
