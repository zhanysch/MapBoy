package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/User/Downloads/Techtorial.html");

        WebElement optionBOX = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(optionBOX);
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedOption = "UNITED STATES";
        Assert.assertEquals(actualDefaultOption,expectedOption);

    }

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/User/Downloads/Techtorial.html");


        WebElement optionBOX = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(optionBOX);
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedOption = "UNITED STATES";
        Assert.assertEquals(actualDefaultOption,expectedOption);




        List<WebElement> list = choice.getOptions();
        int count = 0;

        for (WebElement w :list){
            System.out.println(w.getText().trim());
            count++;
        }
        System.out.println(count);

        choice.selectByVisibleText("KYRGYZSTAN");
        Thread.sleep(3000);
        choice.selectByValue("242");
        Thread.sleep(3000);
        choice.selectByIndex(15);


    }
}
