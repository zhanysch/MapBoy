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

public class AlertIntro {

    @Test
    public void AlertAcceptAndGetText() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText().trim(); // will get the text from pop-up that i cannot inspect
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);

        alert.accept(); // will click Ok Button otherwise you will get Unhandled Alert EXCEPTION

        WebElement result = driver.findElement(By.cssSelector("#result"));

        String acutalMessage = BrowserUtils.getText(result);
        String expectedMessage ="You successfully clicked an alert";
        Assert.assertEquals(acutalMessage,expectedMessage);

    }

    @Test
    public void AlertDismiss() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText().trim(); // will get the text from pop-up that i cannot inspect
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals(actualText,expectedText);

        alert.dismiss(); // will click Ok Button otherwise you will get Unhandled Alert EXCEPTION

        WebElement result = driver.findElement(By.cssSelector("#result"));

        String acutalMessage = BrowserUtils.getText(result);
        String expectedMessage ="You clicked: Cancel";
        Assert.assertEquals(acutalMessage,expectedMessage);
    }

    @Test
    public void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Home work us important");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualText = BrowserUtils.getText(message); // will get the text from pop-up that i cannot inspect
        String expectedText = "You entered: Home work us important";
        Assert.assertEquals(actualText,expectedText);


    }
}
