package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestClass {
    WebDriver driver = new ChromeDriver();
    @Test
    public void tc1()
    {
        SoftAssert softAssert = new SoftAssert();
//        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        String actualResult = driver.getTitle();
//        String expectedResult = "Google";
        softAssert.assertTrue(actualResult.contains("Google"), "URL does not contain duckduckgo");
    }
    @AfterTest
    public void tearDown() {
        // will always run even if assertion fails
        driver.quit();
        System.out.println("test continues here...");
    }

    @Test
    public void tc2()
    {
//        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        Boolean valid =driver.findElement(By.xpath("(//img)[2]")).isDisplayed();
        assertTrue(valid);
        driver.quit();
    }

    @Test
    public void tc3()
    {
//        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.xpath("//input[@id='searchbox_input']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://www.selenium.dev/documentation/webdriver/";
        assertFalse(actualResult.contains(expectedResult));
        driver.quit();

    }
}
