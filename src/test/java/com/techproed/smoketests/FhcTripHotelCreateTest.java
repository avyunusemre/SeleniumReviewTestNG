package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test public void test() {
        // Tüm webelementlere veri göndermeniz gerekiyor.
        // Save butonuna tıklamanız gerekiyor
        //Assert işlemi ile "Hotel was inserted successfully" yazısımı doğrulayın

        FhcTripHotelCreatePage createPage = new FhcTripHotelCreatePage(driver);

        createPage.codeBox.sendKeys("1223");
        createPage.nameBox.sendKeys("Yunus Emre");
        createPage.addressBox.sendKeys("Deutschland");
        createPage.emailBox.sendKeys("yemre92@hotmail.com");
        createPage.phoneBox.sendKeys("05127312712");

        Select select = new Select(createPage.idGroupDropDown);
        select.selectByIndex(1);

        createPage.saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean message = wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(message);



    }
}
