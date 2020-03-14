package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver createADriver(String browserName){

        /**
         * This method return webdriver object based on btowser type
         * if you want to use chrome browser, just provide chrome as a parameter
         * @param browserName
         * @return webdriver object
         */


        if (browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().version("79.0").setup(); // chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

    }
}
