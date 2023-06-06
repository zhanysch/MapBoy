package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {


    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        chooseFile.sendKeys("C:\\Users\\User\\OneDrive\\Рабочий стол\\USA.png");

        WebElement uploadButton  = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();

        WebElement title = driver.findElement(By.cssSelector("#uploaded-files"));

        String w = BrowserUtils.getText(title);
        String n = "USA.png";

        Assert.assertEquals(w,n);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");


        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadfile_0"));

        chooseFile.sendKeys("C:\\Users\\User\\OneDrive\\Рабочий стол\\USA.png");

        WebElement titleUpload = driver.findElement(By.xpath("//b[.='Select file to send(max 196.45 MB)']"));

        String w = BrowserUtils.getText(titleUpload);
        String n = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(w,n);

        WebElement checkBox = driver.findElement(By.cssSelector("#terms"));

        if (checkBox.isEnabled() && !checkBox.isSelected() && checkBox.isDisplayed()){
            checkBox.click();
        }


        WebElement submit = driver.findElement(By.xpath("//button[@type='button']"));
        submit.click();

        Thread.sleep(3000);

        WebElement title2 = driver.findElement(By.xpath("//div//h3"));
        String ww= BrowserUtils.getText(title2);

        String nnn= "1 file\n" +
                "has been successfully uploaded.";

        Assert.assertEquals(ww,nnn);
    }
}
