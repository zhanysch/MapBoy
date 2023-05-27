package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement name = driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("John");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("john@gmail.com");
        WebElement adres = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        adres.sendKeys("501 Ocean ave Brooklyn");
        WebElement permanent = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanent.sendKeys(" 1456 Della driver Hoffman-Estates");

        Thread.sleep(4000);

        WebElement btn = driver.findElement(By.xpath("//button[@id='submit']"));
        btn.click();

        Thread.sleep(10000);

        driver.quit();



        WebElement nameHeader = driver.findElement(By.xpath("//p[@id='name']"));
        String expecteNamedHeader = "John";
        System.out.println(nameHeader.equals(expecteNamedHeader) ? "Passed" : "Failed");

        WebElement emailHEader = driver.findElement(By.xpath("//p[@id='email']"));
        String expecteEmailHeader = "john@gmail.com";
        System.out.println(emailHEader.equals(expecteEmailHeader) ? "Passed" : "Failed");

        WebElement adresHEader = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String expecteAdresHeader = "501 Ocean ave Brooklyn";
        System.out.println(adresHEader.equals(expecteAdresHeader) ? "Passed" : "Failed");




    }
}
