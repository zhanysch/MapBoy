package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FramePractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement title = driver.findElement(By.tagName("h3"));

        System.out.println(BrowserUtils.getText(title));
        driver.switchTo().frame("mce_0_ifr");


        WebElement input = driver.findElement(By.cssSelector("#tinymce"));
        input.clear();
        input.sendKeys("I love selenium");
        driver.switchTo().parentFrame();
        title = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(title));




    }

    @Test public  void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");



        WebElement button = driver.findElement(By.xpath("//a[.='Pavilion']"));
        button.click();


        String mainPageId = driver.getWindowHandle();
        Set<String> allpagesId= driver.getWindowHandles();

        for (String id: allpagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }

        }
        WebElement bucket = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));

        Actions actions = new Actions(driver);
        WebElement hoverOver=driver.findElement(By.xpath("//span//span[.='Selenium-Python']"));

        actions.contextClick(bucket).click(hoverOver).release().perform();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actual = BrowserUtils.getText(header);
        String expected = "Selenium-Python Tutorial";
        Assert.assertEquals(actual,expected);

        System.out.println(actual);

        List<WebElement> list = driver.findElements(By.xpath("//p//a"));
        for (int i = 0; i<list.size(); i++){
            System.out.println(BrowserUtils.getText(list.get(i)));
        }

        BrowserUtils.switchByTitle(driver,"iframes");
         driver.switchTo().frame("Frame1");
        WebElement click = driver.findElement(By.xpath("//a[.='Category1']"));
        click.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement header1 = driver.findElement(By.tagName("h1"));
        String actualTwo = BrowserUtils.getText(header1);
        String expectedTwo = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualTwo,expectedTwo);


        List<WebElement> list2 = driver.findElements(By.xpath("//h3"));
        for (int i = 0; i<list2.size(); i++){
            System.out.println(BrowserUtils.getText(list2.get(i)));
        }

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement text1 = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text1));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement click2 = driver.findElement(By.xpath("//a[.='Category3']"));
        click2.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement title3 = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(title3));

    }
}
