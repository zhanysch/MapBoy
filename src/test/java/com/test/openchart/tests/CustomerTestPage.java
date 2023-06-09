package com.test.openchart.tests;

import com.test.openchart.pages.CartLoginPage;
import com.test.openchart.pages.CustomerPage;
import com.test.openchart.pages.HomeCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTestPage extends  OpenChartTestBase{

    @Test
    public  void validateMain() throws InterruptedException {
        CartLoginPage cartLoginPage = new CartLoginPage(driver);
        cartLoginPage.loginChart("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        HomeCartPage homeCartPage = new HomeCartPage(driver);
        homeCartPage.buttonClicker();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.filleInfo(driver,"walter","walter","walter@email.com",
                "walter","walter");
       Assert.assertEquals(customerPage.errorMessage(),"Warning: You do not have permission to modify customers!");
    }
}
