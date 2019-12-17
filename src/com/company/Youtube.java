package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube
{
    public static void main(String[] args)
    {
        WebDriver driver;
        String base = "https://www.youtube.com/";
        System.setProperty("webdriver.chrome.driver", "D:\\\\AutomationProj\\\\chromedriver_win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(base);

        WebElement Sign_In = driver.findElement(By.xpath("//*[@id=\"text\"]"));
        if (Sign_In.isEnabled())
        {
            Sign_In.click();
        }
    }
}
