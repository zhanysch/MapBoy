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

public class Practice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement ClickMe1= driver.findElement(By.cssSelector("#alertBox"));
        ClickMe1.click();


        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText().trim();
        String expectedText = "I am an alert box!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();

        WebElement output1 = driver.findElement(By.cssSelector("#output"));
       String actualClick1 = BrowserUtils.getText(output1);
       String expectedClick1 = "You selected alert popup";

       Assert.assertEquals(actualClick1,expectedClick1);

        WebElement ClickMe2= driver.findElement(By.cssSelector("#confirmBox"));
        ClickMe2.click();
        alert.dismiss();

        WebElement output2 = driver.findElement(By.cssSelector("#output"));
        String actualClick2 = BrowserUtils.getText(output2);
        String expectedClick2 = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualClick2,expectedClick2);

        WebElement ClickMe3= driver.findElement(By.cssSelector("#promptBox"));
        ClickMe3.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Janysh");
        alert3.accept();

        WebElement output3 = driver.findElement(By.cssSelector("#output"));
        String actualClick3 = BrowserUtils.getText(output3);
        String expectedClick3 = "You entered text Janysh in prompt popup";  //there is a bug here
        Assert.assertEquals(actualClick3,expectedClick3);
    }
}
