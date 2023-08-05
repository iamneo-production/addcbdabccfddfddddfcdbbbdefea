package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScenario {
    private WebDriver driver;
    private final String iamneoUrl = "http://iamneo.ai";
    private final String facebookUrl = "https://www.facebook.com";
    private final String expectedTitle = "We are Hiring!";

    @BeforeTest
    public void setUp() {
        // Set up the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testIamneoPageTitle() {
        // Open the iamneo.ai website
        driver.get(iamneoUrl);
        // Maximize the window
        driver.manage().window().maximize();

        // Verify the page title and print the result
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS: Page title matches - " + actualTitle);
        } else {
            System.out.println("FAIL: Page title does not match - Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }
    }

    @Test(priority = 2)
    public void testFacebookNavigation() {
        // Navigate to Facebook
        driver.get(facebookUrl);
        // Navigate back to iamneo.ai website
        driver.navigate().back();

        // Print the URL of the current page
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);

        // Navigate forward
        driver.navigate().forward();

        // Reload the page
        driver.navigate().refresh();
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
