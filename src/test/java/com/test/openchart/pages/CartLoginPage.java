package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartLoginPage {

    public CartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#input-username")
    WebElement login;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(css = "#alert")
    WebElement errorMessage;




    public void loginChart(String login, String password) throws InterruptedException {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        submitButton.click();
        Thread.sleep(2000);
    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
