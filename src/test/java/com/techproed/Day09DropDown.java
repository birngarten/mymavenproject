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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Day09DropDown {
    //Bir class oluşturun: DropDown
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void dropDownTest(){
        //****** DropDown icin Select class'i kullanilir  ******

        //DroDown'u id ile locate ettik
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        //Select class'inda obje olusturup, select elementi pass edelim.
        Select options = new Select(selectElement);
        ///Artik olusturtulan objecti dropdown'a ulasmak icin kullanabiliriz.
        ////getFirstSelectedOption(); ===> dropdown'daki default value'yu verir
        String firstOptiron = options.getFirstSelectedOption().getText();
        System.out.println("FIRST SELECTED OPTION : "+ firstOptiron +"\n");

        // ?????? DropDown'da element belirlemenin kac yolu vardir?
        //3 yolu vardir;
        //1. index ile ==> selectByIndex() ---> options.selectByIndex(1);
        //2. value ile ==> selectByValue(" "); ---> options.selectByValue("2");
        //3. Visible Text ile ==> selectByVisibleText(" "); --->  options.selectByVisibleText("Option 1");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin
        // ======== SELECT BY INDEX ==========
        options.selectByIndex(1); //inspect'ten bakiyoruz

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin
        // ======== SELECT BY VALUE ==========
        options.selectByValue("2");// value'yu String olarak alir.

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
        // ======== SELECT BY VisibleText ==========
        options.selectByVisibleText("Option 1"); // Gorunen/secilen metinle kontrol ediliyor

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = options.getOptions();

        for (WebElement element : allOptions){
            System.out.println(element.getText());
        }
        //5. Dropdown’un boyutunu(size) bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int size = allOptions.size();
        Assert.assertFalse(size==4);// ==> (TRUE)
        // => Assert.assertTrue(size==4); yazsak FALSE aliriz


    }
    @After
    public void tearDown(){
//        driver.close();
    }

}
