package test;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestsFirefox {
    WebDriver driver;
//    SoftAssert softAssert = new SoftAssert();
//    WebDriverWait wait;
//Wait<WebDriver> wait;

    @BeforeMethod
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(720, 480));
        driver.manage().window().setPosition(new Point(0, 0));
    }

    /**
     * Test Case 4: Verify DuckDuckGo Search Results
     * Steps:
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */

    @Test
    public void tc4()
    {
//        driver = new FirefoxDriver();
//        driver.manage().window().setSize(new Dimension(720,480));
//        driver.manage().window().setPosition(new Point(0,0));
        driver.get("https://duckduckgo.com/");
//        By searchBox = By.id("//input[@id='searchbox_input']");
//        driver.findElement(searchBox).sendKeys("TestNG");
        driver.findElement(By.xpath("//input[@id='searchbox_input']")).sendKeys("TestNG");

//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("1294723603"))));
        Wait<WebDriver> wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
        ; // custom explicit wait

        wait.until(d -> {
            d.findElement(By.xpath("//*[@id='1294723603']"));
            return true;
        });
        String actualResult= driver.findElement(By.xpath("//*[@id='1294723603']")).getText();
        String expectedResult ="TestNG Tutorial";
//        softAssert.assertTrue(actualResult.contains(expectedResult), " the text of the fourth result is not [TestNG Tutorial]");
//        softAssert.assertAll();
        Assert.assertEquals(actualResult, expectedResult, " the text of the fourth result is not [TestNG Tutorial]");
    }

    @AfterMethod
    public void tearDown()
    {
        // will always run even if assertion fails
        driver.quit();
        System.out.println("test continues here...");
    }
}
