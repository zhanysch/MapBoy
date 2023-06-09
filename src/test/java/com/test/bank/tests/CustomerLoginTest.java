package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerLoginTest extends BankTestBase {

    @Test
    public  void validateCustomerFunctionality() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.addCustomerFunctionality(driver,"Ahmet","Baldir","60123","Customer added successfully with customer id");
        customerLoginPage.openAccountFunctionality(driver,"Ahmet Baldir","Dollar","Account created successfully with account Number");
        customerLoginPage.customersFunctionality("Ahmet","Baldir","60123");
        customerLoginPage.addValidateCustomerLogin("Ahmet Baldir","Welcome Ahmet Baldir !!","500","Deposit Successful",
       "300" );


    }
}
