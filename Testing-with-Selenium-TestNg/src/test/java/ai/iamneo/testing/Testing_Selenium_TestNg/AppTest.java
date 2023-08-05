package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception {
        // Set up the Chrome WebDriver
        chromeOptions.setCapability("browserName", "chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:8080"), chromeOptions);
    }

    @Test
    public void testIamneoPageTitle() throws InterruptedException {
        driver.get("http://iamneo.ai:8080");
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "We are Hiring!";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testFacebookNavigation() throws InterruptedException {
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);

        driver.navigate().back();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);

        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @AfterTest
    public void afterTest() {
        // Close the browser
        driver.quit();
    }
}
