package ai.iamneo.testing.Testing_Selenium_TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.net.URL;

public class AppTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;

    @BeforeTest
    public void setUp() throws Exception {
        // Set up WebDriverManager to use ChromeDriver on localhost:8080
        WebDriverManager.chromedriver().driverVersion("94.0.4606.61").setup();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.setCapability("port", 8080);

        driver = new RemoteWebDriver(new URL("http://localhost:8080/wd/hub"), chromeOptions);
    }

    @Test
    public void testIamneoPageTitle() throws InterruptedException {
        driver.get("http://iamneo.ai");
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
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
