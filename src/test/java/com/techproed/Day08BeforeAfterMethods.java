package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08BeforeAfterMethods {
    // Bir class oluşturun: BeforeAfterMethods
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    // imageTest => Google resmini görüntülenip görüntülenmediğini(isDisplayed()) doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;

    @Before
    public void setup(){
        //@Before annotation'i tekrarlanan kosullar icin kullanilir
        //@Before; driver'i kurmak,browser'i acmak, URL'e gitmek icin kullanilir
        //@Before ve @After kullanarak tekrari engellemis oluruz
        //@Before her @Test methodundan once calisir
        //Eger internetiniz,web sitesi veya browser yavassa testiniz basarisiz olabilir.
        // bunu onlemek icin @Before icine wait ekleyebilirsiniz.
        // ==> driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public  void imageTest(){
        //Google image locate
        // imageTest => Google resmini görüntülenip görüntülenmediğini(isDisplayed()) doğrulayın
        WebElement googleImage = driver.findElement(By.id("hplogo"));
        if(googleImage.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public  void gmailLinkTest(){
        // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini doğrulayın
        WebElement gmailLinkTest = driver.findElement(By.linkText("Gmail"));
        if (gmailLinkTest.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }
    @After //Bunu yazdigimizda diger methodlardaki drive.close'a ihtiyac kalmaz.
            // Her methodun actigi sayfayi kapatir
    public  void tearDown(){

        driver.close();
    }
}
