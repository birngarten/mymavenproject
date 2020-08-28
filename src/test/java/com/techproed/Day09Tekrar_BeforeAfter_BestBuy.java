package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day09Tekrar_BeforeAfter_BestBuy {
    //Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    //Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // https://www.bestbuy.com/
    // titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    //Her testten sonra tarayıcıyı kapatin
    //@Before ve @After metotlarini kullanarak yapalim.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");

    }
    // titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle ="Best";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }
    //logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    @Test
    public void logoTest(){
        WebElement logoTest = driver.findElement(By.className("logo"));
        if (logoTest.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLinkTest = driver.findElement(By.linkText("Mexico"));
        if (mexicoLinkTest.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
