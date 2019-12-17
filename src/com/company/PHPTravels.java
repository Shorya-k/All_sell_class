package com.company;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PHPTravels
{
    WebDriver driver;
    String Base;
    String value;
    String date = "20 March 2020";

    @Test
    public void create() throws InterruptedException {
        WebElement Check_in = driver.findElement(By.id("checkin"));
        if (Check_in.isEnabled())
        {
            System.out.println("1. Passed");
            Thread.sleep(2000);
            Check_in.sendKeys(date);
        }
        else
        {
            System.out.println("Test Case Failed ||");
        }
    }
    @Before
    public void setup()
    {
        System.out.println("Initiating the WebDriver Test Suite!");
        System.setProperty("webdriver.chrome.driver", "D:\\\\AutomationProj\\\\chromedriver_win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Base = "https://www.phptravels.net/";
        driver.get(Base);
        options.addArguments("--disable-notifications");
    }
    @After
    public void teardown()
    {
        System.out.println("Closing web-driver!");
        driver.quit();
    }
}
