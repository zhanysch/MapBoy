package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void multiplePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");


        String mainPageId = driver.getWindowHandle();
        Set<String> allpagesId= driver.getWindowHandles();
        for (String id: allpagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }

        }

        BrowserUtils.switchByTitle(driver,"Contact us");System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Kickstart Your Tech Career with Our Top-Rated Coding Bootcamp");System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void realTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement header  = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJs(driver,header);
        header.click();

        BrowserUtils.switchByTitle(driver,
                "Basic Controls");
        WebElement name  = driver.findElement(By.cssSelector("#firstName"));
        name.sendKeys("Walter");
        WebElement lastName  = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Walter");

        WebElement english  = driver.findElement(By.cssSelector("#englishchbx"));
        english.click();
        WebElement email  = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("Walter@gmail.com");
        WebElement password  = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Walter12345");
        WebElement btn  = driver.findElement(By.cssSelector("#registerbtn"));
        btn.click();
        WebElement tit  = driver.findElement(By.cssSelector("#msg"));
        String actualFirst = tit.getText().trim();
        String expectedFirst = "Registration is Successful";
        Assert.assertEquals(actualFirst,expectedFirst);
        BrowserUtils.switchByTitle(driver,"Window Handles");
        WebElement headers = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeade =BrowserUtils.getText(headers);
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeade,expectedHeader);

        Thread.sleep(3000);

        BrowserUtils.switchByTitle(driver,
                "AlertsDemo");
        BrowserUtils.switchByTitle(driver,"AlertsDemo");System.out.println(driver.getTitle());

        WebElement buttonSecond  = driver.findElement(By.cssSelector("#promptBox"));
        buttonSecond.click();
        driver.quit();
    }

}
