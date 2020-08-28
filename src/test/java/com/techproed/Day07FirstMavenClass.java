package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day07FirstMavenClass {

    // !!!!! ***** JAVA COMPILER sag ust kosede search boxa bas ve "java compiler" yaz
    //target bytecode version 8 yapiyoruz***** !!!!

    public static void main(String[] args) {

        //Maven projesinde System.setProperty("",""); kullanmayiz.
        // Bunun yerine WebDriverManager kullaniriz.

        //chrome driver icin;
        WebDriverManager.chromedriver().setup(); //kirmizi olmasinin sebebi eksik dependency lerin olmasindandir.
        //Dependency ler nereden alinir???  https://mvnrepository.com/ git ve WebDriverManager'i ara

        WebDriver driver = new ChromeDriver();  //https://mvnrepository.com/ git ve "selenium java" ara
        driver.get("https://www.google.com");

        //Fake data nasil olusturulur?
        //Face data olusturmak icin "JavaFaker" denilen bir dependency gerekir.

        //searchBox elementini locate ettik
        WebElement searchBox = driver.findElement(By.name("q"));

        // faker objesini olusturduk
        Faker faker = new Faker();

        //Searchboxa fake data gonder ve ENTER tusuna bas!
        searchBox.sendKeys(faker.country().capital()+ Keys.ENTER);//google.com searche
                                                                                //herhangi bir baskent yazar
        //+Keys.ENTER ile  searchBox.submit(); ayni isi yapiyor.

        System.out.println(faker.country().flag()); //sout ile consolde yazariz.
    }
}
