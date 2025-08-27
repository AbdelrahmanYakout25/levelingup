package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class TestClass {
//    WebDriver driver = new ChromeDriver();
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait;

    @Test
    public void tc1()
    {
//        SoftAssert softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        String actualResult = driver.getTitle();
//        String expectedResult = "Google";
        softAssert.assertTrue(actualResult.contains("Google"), "URL does not contain duckduckgo");
        softAssert.assertAll();   //for collect all assertions
    }

    @Test
    public void tc2()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
//        boolean valid =driver.findElement(By.xpath("(//img)[2]")).isDisplayed();
        softAssert.assertTrue(driver.findElement(By.xpath("(//img)[1]")).isDisplayed());
//        driver.quit();
        softAssert.assertAll();   //for collect all assertions
    }

    @Test
    public void tc3()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//input[@id='searchbox_input']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualResult = driver.findElement(By.xpath("//*[@data-testid='result-title-a'][1]")).getAttribute("href");
        String expectedResult = "https://www.selenium.dev/documentation/webdriver/";
        assertEquals(actualResult,expectedResult);
//        driver.quit();
    }
    @Test
    public void tc4()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//input[@id='searchbox_input']")).sendKeys("TestNG Tutorial");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("1294723603"))));
        String actualResult= driver.findElement(By.id("1294723603")).getText();
        String expectedResult ="TestNG Tutorial";
        softAssert.assertTrue(actualResult.contains(expectedResult), " the text of the fourth result is not [TestNG Tutorial]");
        softAssert.assertAll();
    }
    @Test
    public void tc5()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//input[@id='searchbox_input']")).sendKeys("Cucumber IO");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualResult = driver.findElement(By.xpath("(//*[@data-testid='result-title-a'])[2]")).getAttribute("href");
        String expectedResult = "https://www.linkedin.com";
        softAssert.assertTrue(actualResult.contains(expectedResult),"The link does not contain " + expectedResult);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        // will always run even if assertion fails
        driver.quit();
        System.out.println("test continues here...");
    }
}
