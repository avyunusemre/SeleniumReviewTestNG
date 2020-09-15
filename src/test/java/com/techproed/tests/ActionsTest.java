package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void rightClick() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);

        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform();
        //Actions class'ı kullanırken her işlemden sonra perform() kullanmak zorundayız.
    }

    @Test
    public void doubleClick() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);

        WebElement doubleClickMe = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClickMe).perform();
    }

    @Test
    public void hoverOver() {//mouse'u herhangi bir webelementin üstüne götürme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountLists).perform();
    }

    @Test
    public void asagiYukariGitme() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);

        //sayfanın en altına gitmek icin
        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        //web sayfasında yukarı cıkmak icin
        //1. Yol
        actions.sendKeys(Keys.PAGE_UP).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        //2.Yol
        actions.sendKeys(Keys.ARROW_UP).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        //Sayfada aşağı inme
        //1. Yol
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        //2. Yol
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    @Test
    public void keyUpKeyDown() {
        driver.get("http://google.com");
        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.name("q"));
        actions.moveToElement(searchBox)
                .click()
                .keyUp(Keys.SHIFT)
                .sendKeys("merhaba")
                .keyDown(Keys.SHIFT)
                .sendKeys(" nasılsınız")
                .perform();
    }

    @Test
    public void ikiTusaAyniAndaBasma() {
        driver.get("http://google.com ");
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();
    }

}
