package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement check = driver.findElement(By.cssSelector("#yesRadio"));
       // check.click();
       /* Actions actions = new Actions(driver);
        actions.click(check).perform();*/



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", check);

        WebElement mesage = driver.findElement(By.cssSelector(".mt-3"));
        String actualMesage = BrowserUtils.getText(mesage);
        String expectesMessage = "You have selected Yes";
        Assert.assertEquals(actualMesage,expectesMessage);

        WebElement noRadioButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());
    }

    @Test
    public void ScrollIntoViewMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", findOutCourse);
        Thread.sleep(3000);
        findOutCourse.click();
    }

    @Test
    public void Practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement blabla = driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", blabla);

        Thread.sleep(3000);
        String actualMesage = BrowserUtils.getText(blabla);
        String expectesMessage = "Copyright © 2023";
        Assert.assertEquals(actualMesage,expectesMessage);

        WebElement blabla2 = driver.findElement(By.xpath("//strong[contains(text(),'APPLY NOW')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", blabla2);
        blabla2.click();

        List<WebElement> allTitle =  driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> acutalTitle = new ArrayList<>();
        List<String> expedtedNames = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");


        for (int i = 0; i<allTitle.size();i++){

            acutalTitle.add(BrowserUtils.getText(allTitle.get(i)));
            Assert.assertEquals(BrowserUtils.getText(allTitle.get(i)),expedtedNames.get(i));
        }




    }

    @Test
    public void Practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyRightText= driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("arguments[0].scrollIntoView(true)",copyRightText);
        BrowserUtils.scrollWithJs(driver,copyRightText);
        Thread.sleep(2000);
        String actualText=BrowserUtils.getText(copyRightText);
        String expectedText = "Copyright © 2023";
        Assert.assertEquals(actualText,expectedText);

        WebElement topText = driver.findElement(By.xpath("//b[contains(text(),'NEW TECH')]"));
        BrowserUtils.scrollWithJs(driver,topText);
        Thread.sleep(2000);
        WebElement applyNowButton = driver.findElement(By.xpath("//span[.='Apply Now']"));
//js.executeScript("arguments[0].click()",applyNowButton);
        BrowserUtils.clickWithJs(driver,applyNowButton);
        Thread.sleep(2000);

//js.executeScript("return document.title");
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle ="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);

        List<WebElement> actualList = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedList = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");


        for(int i = 0; i<actualList.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(actualList.get(i)),expectedList.get(i));
        }
    }
}
