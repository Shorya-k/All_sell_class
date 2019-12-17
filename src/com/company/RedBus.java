package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class RedBus
{
    WebDriver driver;
    String Base;
    String Month = "January";
    String value;
    @Test
    public void UseCase()
    {
        System.out.println("Setting up the Environment || Running the Test Suite!");

        // 1. Declaring all variable/Elements and their type
        WebElement From = driver.findElement(By.id("src"));
        WebElement TO = driver.findElement(By.id("dest"));
        //WebElement Onward_Date = driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/div/label"));
        while(true)
        {
            value = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")).getText();
            if (value.equals(Month))
            {
                break;
            }
            else
            {
                driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
            }
        }
        //Onward_Date.sendKeys("13-Dec-2019");
        //WebElement Return_Date = driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[4]/span"));
        //Return_Date.sendKeys("14-Dec-2019");
        if (From.isEnabled())
        {
            From.sendKeys("Meerut");
            System.out.println("1.) Test Case Passed "+From);
        }
        if (TO.isEnabled())
        {
            TO.sendKeys("Noida");
            System.out.println("2.) Test Case Passed "+TO);
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
        Base = "https://www.redbus.in/";
        driver.get(Base);
        options.addArguments("--disable-notifications");
    }
    @After
    public void tearDown()
    {
        System.out.println("Closing the WebDriver Test Suite!");
        driver.quit();
        System.exit(10);
    }
}