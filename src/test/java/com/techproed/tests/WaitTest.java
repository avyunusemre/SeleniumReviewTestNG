package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWait() {
        //implicitly wait : sayfadaki findElement işlemi gerçekleşirken ,
        //                  belirlediğimiz max. süreye kadar beklemek için kullanılır.
        //                  Eğer max. süreden önce web element bulunursa beklemez, devam eder.

        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.id("q"));
    }

    @Test
    public void explicitlyWait() {
        //WebDriverWait class'ında nesne üretmek zorundayız!
        //imlicitlyWait'ten en önemli farkı, burada herhangi bir webelement için
        //özel bir bekleme işlemi gerçekleştiriyoruz.

        //Explicit Wait içinde en önemli fark, burada bir koşul belirtiyoruz

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String messageText = message.getText();

        Assert.assertEquals(messageText,"It's gone!" );
    }
}
