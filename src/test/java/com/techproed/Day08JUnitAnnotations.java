package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Day08JUnitAnnotations {
  //Bir JUnit projesinde testi calistirmak icin @Test annotation'i kullanilir.
   //mvnrepository.com/ git ve Junit'i ara

    //"test1" adinda bir void method olusturun

    @Before //Her @Test'ten once calisir.
    public void runBeforeTest(){

        System.out.println("@Before => run before test");
    }

    @Test   // @Test test caseler'i main method() olmadan calistirmamizi saglar
    public void test1(){

        System.out.println("Test1'i yazdir");
    }

    @Before //@Before'u ustune yazdigimiz @Test annotation tum @Test annotation'lardan once yazdirir
            //Class'in herhangi bir yerinde kullanilabilir
    @Test
    public void test2(){

        System.out.println("Test2'yi yazdir");
    }

    @Ignore //kendinden sonraki methodu() gormezden gelir, yazdirmaz.
            //Bu nedenle bu Class'ta test3 methodunu console'da goremeyiz.
    @Test
    public void test3(){

        System.out.println("Test3'u yazdir");
    }

    @After // Her @Test ten sonra calisir.
           // Class'in herhangi bir yerinde kullanilabilir
    public void runAfterTest(){

        System.out.println("@After => run after test"+"\n");
    }
}
