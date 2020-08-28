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

public class Day09Assertions {
    // Bir class oluşturun: Assertions
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // "https://www.google.com/" adresine gidin
    // titleTest => Sayfa başlığının “Google” oldugunu assertion kullanarak doğrulayın
    // imageTest => Google resmini görüntülenip görüntülenmediğini(isDisplayed()) assertion kullanarak doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed())assertion kullanarak doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Normalde her methodun icinde yukardaki 3 satir yazilmasi gerekirken en usttte @Before ile
        //inheritance yaptik ve methodlarin icinde artik yazmaya ihtiyac kalmadi. Bu durumda;
        // methodlarin icindeki driver'in kirmiziligi gecmesi icin en ustte " WebDriver driver;" yazariz

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //SECONDS=Saniye ==> 10 saniye
        //internet yavas oldugunda implicitlyWait() kullaniyoruz. Normalde ihtiyac yok

    }

    @Test
    public void titleTest(){
        // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
        String actualTitle=driver.getTitle();
        String expectedTitle = "Google";

        //Assert class'i JUnit'ten gelir.
        //assert.Equals(); iki tane String alir ve birbirlerine esit olup olmadiklarini kontrol eder
        //Iki String birbirine esit ise PASS, degilse FAIL verir.
        Assert.assertEquals(expectedTitle,actualTitle); //Bu satir asagidaki if() else satirlarinin yaptigini yapiyor.
//        if (actualTitle.equals(expectedTitle)){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAIL");
//        }
    }

    @Test
    public  void imageTest(){
        //Google image locate
        // imageTest => Google resmini görüntülenip görüntülenmediğini(isDisplayed()) doğrulayın
        WebElement googleImage = driver.findElement(By.id("hplogo"));
        //assertTrue() ==> googleImage.isDisplayed() true ise test PASS; false ise test FAIL olur.
        //assertTrue() kullandigimizda neticenin True olmasini bekliyoruz
        Assert.assertTrue(googleImage.isDisplayed());

        //assertFalse() kullandigimizda neticenin False olmasini bekliyoruz
        //googleImage.isDisplayed() ifadesi True oldugundan test FAIL olur.
        //Assert.assertFalse(googleImage.isDisplayed());

    }

    @Test
    public  void gmailLinkTest(){
        // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
        WebElement gmailLinkTest = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmailLinkTest.isDisplayed());

    }
    @After //Bunu yazdigimizda diger methodlardaki drive.close'a ihtiyac kalmaz.
    // Her methodun actigi sayfayi kapatir
    public  void tearDown(){

        driver.close();
    }
}
