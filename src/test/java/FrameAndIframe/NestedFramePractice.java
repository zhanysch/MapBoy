package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFramePractice {

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        //name or ID iframe
        driver.switchTo().frame("frame-top");

        //webElemnt iframe
        WebElement iframeLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        driver.switchTo().parentFrame();
        WebElement iframeMiddle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(iframeMiddle);

        WebElement middle = driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));


        driver.switchTo().parentFrame();


        WebElement iframeRight = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        driver.switchTo().frame(iframeRight);

        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

        /*
        print out BOTTOM
         */

       /* driver.switchTo().parentFrame(); TOP FRAME
        driver.switchTo().parentFrame(); MAIN HTML
*/
       driver.switchTo().defaultContent(); //it goes main html no matter what
        WebElement iframebottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(iframebottom);

        WebElement bottomm = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomm));



    }
}
