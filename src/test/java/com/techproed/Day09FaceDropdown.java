package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day09FaceDropdown {
    //   Create class : FaceDropdown
    //    // Create method : Birthday
    //    // https://www.facebook.com adresine gidin
    //    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    //    // Tarayiciyi kapatin.
    WebDriver driver;


    @Test
    public void birthday() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        WebElement createNewAccount = driver.findElement(By.id("u_0_2"));
        createNewAccount.click();

        Thread.sleep(3000);
        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Rothen");

        WebElement lastName = driver.findElement(By.id("u_2_d"));
        lastName.sendKeys("Kathe");


        WebElement phone = driver.findElement(By.id("u_2_g"));
        phone.sendKeys("rothen.kati25@gmail.com");

        Thread.sleep(1000);
        WebElement phoneT = driver.findElement(By.id("u_2_j"));
        phoneT.sendKeys("rothen.kati25@gmail.com");

        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("Laster.47589");


        //Day
        WebElement dayDropDown = driver.findElement(By.id("day"));
        Select optionBirthday = new Select(dayDropDown);
        optionBirthday.selectByValue("25");

        //Month
        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select optionBirthMonth = new Select(monthDropDown);
        optionBirthMonth.selectByValue("4");

        //Year
        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select optionBirthYear = new Select(yearDropDown);
        optionBirthYear.selectByValue("1999");

        WebElement gender = driver.findElement(By.xpath("//label[@for='u_2_5']"));
        gender.click();

        WebElement signUpButon = driver.findElement(By.id("u_2_s"));
        signUpButon.click();

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
