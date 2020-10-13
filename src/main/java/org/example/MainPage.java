package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class MainPage {
    private WebDriver webDriver;

    private final int countDay = 7;
    private final String URI = "https://yandex.ru/pogoda/izhevsk";

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);

        PageFactory.initElements(webDriver, this);


    }

    public void getTemperature() {
        List<WebElement> webElements = webDriver.findElements(By.xpath("//div[@class='card']"));
        List<WebElement> weathers;
        for (int i = 0; i < countDay; i++) {
            System.out.println(webElements.get(i).findElement(By.xpath(".//h2/strong")).getText()
                    + " "
                    + webElements.get(i).findElement(By.xpath(".//h2/small/span[@class='forecast-details__day-month']")).getText());

            weathers = webElements.get(i).findElements(By.xpath(".//tr[@class='weather-table__row']"));
            for (WebElement el : weathers) {
                System.out.println(el.findElement(By.xpath(".//div[@class='weather-table__daypart']")).getText()
                        + " " + el.findElements(By.xpath(".//span[@class='temp__value']")).get(0).getText()
                        + " " + el.findElements(By.xpath(".//span[@class='temp__value']")).get(1).getText()
                );
            }

            System.out.println();
        }
    }

    public void exit() {
        webDriver.close();
    }
}
