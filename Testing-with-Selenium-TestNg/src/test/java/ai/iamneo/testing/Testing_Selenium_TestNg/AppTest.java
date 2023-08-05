package ai.iamneo.testing.Testing_Selenium_TestNg;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.List;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class AppTest {
	WebDriver driver = null;
	ChromeOptions options = new ChromeOptions();
	@BeforeTest
	public void beforeTest() throws IOException{
		System.setProperty("webdriver.chrome.driver", "/home/coder/project/workspace/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:8080"), options);
	}
	@Test(priority = 1)
    public void testTitle() {
        driver.get("http://iamneo.ai");
        String pageTitle = driver.getTitle();
        String expectedTitle = "We are Hiring!";
        Assert.assertEquals(pageTitle, expectedTitle, "Fail");
    }

    @Test(priority = 2)
    public void testNavigation() {
        driver.get("https://www.facebook.com");
        driver.navigate().back();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
        driver.navigate().forward();
        driver.navigate().refresh();
    }

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}

