package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {

    @Test
    public void isFileExist() {

        //şu anda bulunduğumuz klasörün dosya yolunu verir.(String olarak)
        System.out.println(System.getProperty("user.dir"));

        //kullanıcının ana klasorünün yolunu verir
        System.out.println(System.getProperty("user.home"));

        //Java ile belirtilen adreste, aradığınmız dosyanın var olup olmadığını
        //aşağıdaki kod ile yapabiliyoruz.

        //eğer dosya varsa, TRUE - Eğer dosya yoksa, FALSE
        boolean isExist = Files.exists(Paths.get("C:\\Users\\deuav\\IdeaProjects\\SeleniumReviewTestNG\\pom.xml"));
        //boolean varM = Files.exists(Paths.get(System.getProperty("user.dir") +"\\pom.xml")); ==> şeklinde de yapabilirdik.
        Assert.assertTrue(isExist);
    }

    @Test
    public void fileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\deuav\\Desktop\\img1.jpg");

        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
    }
    
    @Test
    public void fileDownload() {

        driver.get("http://the-internet.herokuapp.com/download");

        WebElement logo = driver.findElement(By.xpath("//*[.='logo.jpg']"));
        logo.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        boolean isLogoExist = Files.exists(Paths.get("C:\\Users\\deuav\\Downloads\\logo.jpg"));
        Assert.assertTrue(isLogoExist);

    }
    
}
