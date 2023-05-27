package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void succesfullLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Walter");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(3000);

        WebElement actualTitle = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']" ));

        String actual = actualTitle.getText();
        String expectedTitle = "No match for Username and/or Password.";

        Assert.assertEquals(actual,expectedTitle);
        driver.quit();
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(4000);

        WebElement catalog1 = driver.findElement(By.cssSelector(".btn-close"));
        catalog1.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]" ));
        catalog.click();

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']" ));
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isSelected());

    }
    @Test
    public void validateCheckBox() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(4000);

        WebElement catalog1 = driver.findElement(By.cssSelector(".btn-close"));
        catalog1.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]" ));
        catalog.click();

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']" ));
        product.click();


        List<WebElement> box = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i =1; i<box.size(); i++){
            Thread.sleep(100);
            Assert.assertTrue(box.get(i).isDisplayed());
            Assert.assertTrue(box.get(i).isEnabled());
            Assert.assertFalse(box.get(i).isSelected());
            box.get(i).click();
            Thread.sleep(3000);
            box.get(i).isSelected();
            box.get(i).sendKeys(Keys.ARROW_DOWN);


        }
    }
    @Test
    public void validateProductnameFunctionality() throws InterruptedException {

          /*
        test case
        1- you will click the productname button
        2- you should create arraylist
          *one of them wii be actual data
          * another will be expectedData

         3- For (int i =1)
         *store all the names for both of the list

         4- for expected List --> you will use collections.sort(expectedList)
                                 -->Collections.revers(expected)
                                  Assert.equals(actualList,Expectedlist)
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(4000);

        WebElement catalog1 = driver.findElement(By.cssSelector(".btn-close"));
        catalog1.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]" ));
        catalog.click();

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']" ));
        product.click();

        Thread.sleep(3000);

        List <WebElement> allproducts= driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductOrder= new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();




        for (int i =1; i<allproducts.size(); i++){


           actualProductOrder.add(allproducts.get(i).getText().toLowerCase().trim());  //same order same trim
           expectedProductOrder.add(allproducts.get(i).getText().toLowerCase().trim());   //same order same item


        }

        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);



    }
        @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement book = driver.findElement(By.xpath("//button"));
        book.click();

        Thread.sleep(4000);

        WebElement catalog1 = driver.findElement(By.cssSelector(".btn-close"));
        catalog1.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();

        Thread.sleep(3000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();

        Thread.sleep(3000);

        List<WebElement> allproducts = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();


        for (int i = 1; i < allproducts.size(); i++) {


            actualProductOrder.add(allproducts.get(i).getText().toLowerCase().trim());  //same order same trim
            expectedProductOrder.add(allproducts.get(i).getText().toLowerCase().trim());   //same order same item


        }

            Collections.sort(expectedProductOrder);
           Collections.reverse(expectedProductOrder);
            System.out.println(actualProductOrder);
            System.out.println(expectedProductOrder);
            Assert.assertEquals(actualProductOrder,expectedProductOrder);

    }

}
