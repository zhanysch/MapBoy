package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJsPractice {

    @Test
    public  void practiceBoth(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement prev = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        prev.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement prev2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        prev2.click();
        WebElement titl = driver.findElement(By.xpath("//div[contains(@class,'swal-text')]"));
        System.out.println(BrowserUtils.getText(titl));
        WebElement titl2 = driver.findElement(By.xpath("//div[contains(@class,'swal-title')]"));
        System.out.println(BrowserUtils.getText(titl2));

        WebElement button  = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        button.click();





    }
}
