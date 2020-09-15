package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ornek_HotelRoomCreation extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void test() {
        WebElement idHotelDropDown = driver.findElement(By.id("IDHotel"));
        WebElement codeBox = driver.findElement(By.id("Code"));
        WebElement nameBox = driver.findElement(By.id("Name"));
        WebElement locationBox = driver.findElement(By.id("Location"));
        WebElement descritionBox = driver.findElement(By.xpath("(//textarea)[2]"));
        WebElement priceBox = driver.findElement(By.id("Price"));
        WebElement price500 = driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement roomDropDown = driver.findElement(By.id("IDGroupRoomType"));
        WebElement adultCountBox = driver.findElement(By.id("MaxAdultCount"));
        WebElement childCountBox = driver.findElement(By.id("MaxChildCount"));
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));

        Select hotelDropDowm = new Select(idHotelDropDown);
        hotelDropDowm.selectByIndex(2);

        codeBox.sendKeys("1234");
        nameBox.sendKeys("Yılmaz");
        locationBox.sendKeys("Selamlar");
        descritionBox.sendKeys("Review derslerinde yapıldı");


        //dragAndDrop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(price500,priceBox);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }


        Select roomTypeDropDown = new Select(roomDropDown);
        roomTypeDropDown.selectByIndex(3);

        adultCountBox.sendKeys("2");
        childCountBox.sendKeys("3");

        saveButton.click();

    }
}
