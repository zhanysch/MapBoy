package com.test.openchart.tests;

import com.test.openchart.pages.CartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest  extends OpenChartTestBase{

    @Test
    public  void validateLogin() throws InterruptedException {
        CartLoginPage cartLoginPage = new CartLoginPage(driver);
        cartLoginPage.loginChart("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
    }
    @Test
    void validateNegativeLogin() throws InterruptedException {
        CartLoginPage cartLoginPage = new CartLoginPage(driver);
        cartLoginPage.loginChart("demo","wrongdemo");
        Assert.assertEquals(cartLoginPage.errorMessage(),"No match for Username and/or Password.");

    }
}
