package com.examly.springapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestNGAssignment {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up the Chrome browser
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testScenario() {
        // Step 1: Maximize the browser window
        driver.manage().window().maximize();

        // Step 2: Navigate to "http://iamneo.ai"
        driver.get("http://iamneo.ai");

        // Step 3: Check if the title of the page matches with "We are Hiring!"
        String actualTitle = driver.getTitle();
        String expectedTitle = "We are Hiring!";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match. Test failed.");

        // Step 4: Navigate to "https://www.facebook.com"
        driver.navigate().to("https://www.facebook.com");

        // Step 5: Navigate back to the "iamneo.ai" website
        driver.navigate().back();

        // Step 6: Print the URL of the current page
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Step 7: Navigate forward
        driver.navigate().forward();

        // Step 8: Reload the page
        driver.navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        // Step 9: Close the browser
        driver.quit();
    }
}
