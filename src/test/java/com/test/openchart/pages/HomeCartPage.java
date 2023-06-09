package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeCartPage {

    public HomeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".btn-close")
    WebElement btnClosAlertDialog;

    @FindBy(linkText = "Customers")
    WebElement customersTogle;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement toglerLink;

    public void buttonClicker() throws InterruptedException {
        btnClosAlertDialog.click();
        Thread.sleep(3000);
        customersTogle.click();
        Thread.sleep(3000);
        toglerLink.click();
    }
}
