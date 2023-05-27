package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathPractice {

    public XpathPractice() {
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("blabla");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("blabla");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("baishwalter@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("9296270397");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("blabla");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        repeatPassword.sendKeys("blabla");

        WebElement newsleter = driver.findElement(By.xpath("//input[@name='newsletter']"));
        newsleter.click();

        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();

        WebElement btn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        btn.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL is Passed");
        } else {
            System.out.println("URL is Failed");
        }


        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Been created!')]"));

        String actualHeader = header.getText().trim();

        String expectedHeader = "Your Account Has Been Created!";

        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        driver.close();
    }
}
