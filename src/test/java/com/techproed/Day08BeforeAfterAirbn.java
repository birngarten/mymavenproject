package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08BeforeAfterAirbn {
    // Bir class oluşturun: Homework_BeforeAfterAirbnb
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
    // logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
    // helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com/");

    }
    // titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
   @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Airbnb";

       Assert.assertEquals(actualTitle,exceptedTitle);

   }
    // logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
   @Test
    public void logoTest(){
       WebElement airbnbLogoTest = driver.findElement(By.xpath("//body/div[4]/div/div/div/div[1]/div[1]/div/header/div/div[1]/a"));
       if (airbnbLogoTest.isDisplayed()){
           System.out.println("PASS");
       }else {
           System.out.println("FAIL");
       }

   }
    // helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
   @Test
    public void helpLinkTest(){
        WebElement airbnbhelpLinkTest = driver.findElement(By.xpath("//div[.='Help']"));
        if (airbnbhelpLinkTest.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
   }
    // Her testten sonra tarayıcıyı kapatin
   @After
    public void tearDown(){
        driver.close();
   }
}
