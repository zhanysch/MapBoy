package ActionClass;

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

public class PracticeActions {

    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement titleTag = driver.findElement(By.xpath("//div[@id='droppable']//p[.='Drop here']"));
        String actualBeforeTitl = BrowserUtils.getText(titleTag);
        String expectedBeforeTitl = "Drop here";
        Assert.assertEquals(actualBeforeTitl, expectedBeforeTitl);


        WebElement Box = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(Box).release().perform();
        String actualBackGroundColor = Box.getCssValue("background-color");
        String expectedBackGroundColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);

        Box = driver.findElement(By.xpath("//div[@id='droppable']"));
        String actualAfterDragAndDrop = BrowserUtils.getText(Box);
        String expectedAfterDragAndDrop = "Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop, expectedAfterDragAndDrop);
    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.xpath("//a[.='Accept']"));
        acceptButton.click();

        WebElement bucket = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div[@id='droppable']"));

        WebElement draggableBox = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(draggableBox).moveToElement(bucket).release().perform();

        WebElement NotAcceptableMessage = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String expectedMessage = "Not Acceptable";
        Assert.assertEquals(BrowserUtils.getText(NotAcceptableMessage),expectedMessage);

        WebElement actualMessageAfter = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//p[.='Drop here']"));
        String expectedMessageAfter = "Drop here";
        Assert.assertEquals(BrowserUtils.getText(actualMessageAfter),expectedMessageAfter);

    }
}
