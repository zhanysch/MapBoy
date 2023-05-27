package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTesting.click();

        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'A/B Test')]"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(p.getText());

        WebElement elementSelenium = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        elementSelenium.click();
    }
}
