package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        WebDriver webDriver = new ChromeDriver();
        MainPage page = new MainPage(webDriver);
        page.getTemperature();
        page.exit();
    }
}
