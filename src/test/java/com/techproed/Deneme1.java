package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Deneme1 {
    //   Create class : FaceDropdown
    //    // Create method : Birthday
    //    // https://www.facebook.com adresine gidin
    //    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    //    // Tarayiciyi kapatin.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

    }

    @Test
    public void birthday(){
        // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
        WebElement monat = driver.findElement(By.id("month"));
        Select mon = new Select(monat);
        mon.selectByIndex(4);


        WebElement tag = driver.findElement(By.id("day"));
        Select tg = new Select(tag);
        tg.selectByValue("14");
        WebElement jahre = driver.findElement(By.id("year"));
        Select jahr = new Select(jahre);
        jahr.selectByVisibleText("1982");


    }
}
