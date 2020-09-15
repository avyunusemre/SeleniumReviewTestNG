package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String anaSayfaWindowHandle = driver.getWindowHandle();
        System.out.println(anaSayfaWindowHandle);
        WebElement link = driver.findElement(By.xpath("//a[@target='_blank']"));
        link.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //windowhandle kullanarak istedigimiz sayfaya bu şekilde gecebiliyoruz.
        driver.switchTo().window(anaSayfaWindowHandle);

        //Açık olan tüm sayfaların window handle'ını almak
        Set<String> allWindowHandles = driver.getWindowHandles();

        String ikinciSayfaWindowHandle = "";
        for(String handle: allWindowHandles) {
            if (!handle.equals(anaSayfaWindowHandle)) {
                ikinciSayfaWindowHandle = handle;
            }
            System.out.println(handle);
        }

        System.out.println("ikinci sayfa window handle : " + ikinciSayfaWindowHandle);


        ///////////////////////Set<String> i Array'e cevirme ///////////////////
        Object[] windowHandleDegerleri = allWindowHandles.toArray();
        System.out.println(windowHandleDegerleri[0].toString());
        System.out.println(windowHandleDegerleri[1].toString());


    }

}
