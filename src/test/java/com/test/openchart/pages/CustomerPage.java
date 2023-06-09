package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='float-end']//a")
    WebElement addCusttomerSign;

    @FindBy(css = "#input-firstname")
    WebElement inputFirstName;

    @FindBy(css = "#input-lastname")
    WebElement inputLastName;

    @FindBy(css = "#input-email")
    WebElement inputEmail;

    @FindBy(css = "#input-password")
    WebElement inputPassword;

    @FindBy(css = "#input-confirm")
    WebElement inputConfirm;

    @FindBy(css = "#input-newsletter")
    WebElement newsLetter;

    @FindBy(css = "#input-status")
    WebElement status;

    @FindBy(css = "#input-safe")
    WebElement safe;
    @FindBy(xpath = "//div[@class='float-end']//button")
    WebElement saveButton;

    @FindBy(xpath = "//div[@id='alert']")
    WebElement errorMessage;


    public void filleInfo(WebDriver driver,String inputFirstName,String inputLastName,
                          String inputEmail,
                          String inputPassword,String inputConfirm) throws InterruptedException {
        addCusttomerSign.click();
        this.inputFirstName.sendKeys(inputFirstName);
        this.inputLastName.sendKeys(inputLastName);
        this.inputEmail.sendKeys(inputEmail);
        this.inputPassword.sendKeys(inputPassword);
        this.inputConfirm.sendKeys(inputConfirm);
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (newsLetter.isDisplayed() && newsLetter.isEnabled() &&  !newsLetter.isSelected())
            js.executeScript("arguments[0].click()",newsLetter);

        if (status.isDisplayed() && status.isEnabled() &&  !status.isSelected())
            js.executeScript("arguments[0].click()",status);

        if (safe.isDisplayed() && safe.isEnabled() &&  !safe.isSelected())
            js.executeScript("arguments[0].click()",safe);

        Thread.sleep(3000);
        if (saveButton.isDisplayed() && saveButton.isEnabled() &&  !saveButton.isSelected())
            js.executeScript("arguments[0].click()",saveButton);


    }

    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
