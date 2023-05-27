package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class YoutubeRealInterviewQuestion {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        /*

        Thread.sleep(200)
        song.sendKeys(Keys.ARROW_DOWN) --> put this inside of loop
         */

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("breaking habbit");
        search.sendKeys(Keys.ENTER);

        WebElement findBut = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        findBut.click();
        Thread.sleep(3000);

        List<WebElement> video = driver.findElements(By.xpath("//a[@id='video-title']"));


        Thread.sleep(3000);
        for (WebElement box : video){
            box.sendKeys(Keys.ARROW_DOWN);
            if (box.getAttribute("title").contains("09 Linkin Park - Breaking The Habit")){
                box.click();
                break;
            }
        }
    }
}
