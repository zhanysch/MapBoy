package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CustomerLoginPage {

    public CustomerLoginPage(WebDriver driver){
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

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement custommerLogin;

    @FindBy(xpath = "//button[.='Login']")
    WebElement customerLoginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeNameHeader;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement buttonDeposit;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement validateDepositSucces;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement  withdrawButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawSubmit;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;
   @FindBy(xpath = "//td[contains(text(),'500')]")// //tr[@id='anchor0']//td[2]
   WebElement firstAmount;
    @FindBy(xpath = "//td[contains(text(),'300')]") // //tr[@id='anchor1']//td[2]
    WebElement secondAmount;

    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backButton;

    @FindBy(xpath = "//strong[contains(text(),'200')]")
    WebElement remainderAmount;

    public void addValidateCustomerLogin(String customerNameLogin,String expectedHeader,String amount,String expectedvalidDepositSucces,String withdrawAmount) throws InterruptedException {
        custommerLogin.click();
        BrowserUtils.selectByMethod(this.customerName,customerNameLogin,"text");
        customerLoginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeNameHeader),expectedHeader);
        buttonDeposit.click();
        this.amount.sendKeys(amount);
        Thread.sleep(3000);
        depositButton.submit();
        Assert.assertEquals(BrowserUtils.getText(validateDepositSucces),expectedvalidDepositSucces);
        withdrawButton.click();
        Thread.sleep(3000);
        this.withdrawAmount.sendKeys(withdrawAmount);
        withdrawSubmit.click();
        Thread.sleep(1000);
        transactionButton.click();
        int w= (Integer.parseInt(BrowserUtils.getText(firstAmount))-Integer.parseInt(BrowserUtils.getText(secondAmount)));
        String totalAmount1 = String.valueOf(w);
        Thread.sleep(3000);
        backButton.click();
        Assert.assertEquals(totalAmount1,BrowserUtils.getText(remainderAmount));


    }

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

        BrowserUtils.selectByMethod(this.customerName,customerName,"text");

        BrowserUtils.selectByMethod(this.currency,currency,"value");

        proccesButton.click();

        Alert alert= driver.switchTo().alert();

        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();


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
