package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelRoomCreationPage {

    WebDriver driver;
    public FhcTripHotelRoomCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropDown;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Location")
    public WebElement locationBox;

    @FindBy(xpath = "(//textarea)[2]")
    public WebElement descritionBox;

    @FindBy(id = "Price")
    public WebElement priceBox;

    @FindBy(xpath = "//li[@data-id='500']")
    public WebElement price500;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomDropDown;

    @FindBy(id = "MaxAdultCount")
    public WebElement adultCountBox;

    @FindBy(id = "MaxChildCount")
    public WebElement childCountBox;


}
