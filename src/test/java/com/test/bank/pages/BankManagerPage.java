package com.test.bank.pages;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement proccesButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    public void addCustomerFunctionality(WebDriver driver ,String firstName,String lastname, String postCode,String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastname);
        this.postCode.sendKeys(postCode);
        submitAddCustomerButton.submit();

        Alert alert =driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void openAccountFunctionality(WebDriver driver , String customerName, String currency,String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        Thread.sleep(2000);
        BrowserUtils.selectByMethod(this.customerName,customerName,"text");
        Thread.sleep(2000);
        BrowserUtils.selectByMethod(this.currency,currency,"value");
        Thread.sleep(2000);
        proccesButton.click();
        Thread.sleep(2000);
        Alert alert= driver.switchTo().alert();

        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
        Thread.sleep(2000);

    }

    public void customersFunctionality(String customerName,String lastName, String postCode) throws InterruptedException {
        customerButton.click();
        searchBox.sendKeys(customerName);

        List<String> expectedNames = Arrays.asList(customerName,lastName,postCode);
        for (int i =0; i<allInformation.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));
        }

        Thread.sleep(3000);
        homeButton.click();

    }
}


