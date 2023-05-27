package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WarmUpTech {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Janysh");

        WebElement last = driver.findElement(By.name("lastname"));
        last.sendKeys("Msfasfsa");

        //sex-0



        WebElement male = driver.findElement(By.id("sex-0"));
        if (male.isDisplayed() && !male.isSelected()) {
            male.click();
        }

        WebElement expirience = driver.findElement(By.id("exp-5"));
        if (expirience.isDisplayed() && !expirience.isSelected()) {
            expirience.click();
        }

        Thread.sleep(3000);
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("08/04/2023");

        /*WebElement test1 = driver.findElement(By.id("profession-1"));
        test1.click();*/
        WebElement test1 = driver.findElement(By.id("profession-1"));
        test1.click();

        WebElement test2 = driver.findElement(By.id("profession-0"));
        test2.click();

        WebElement tools = driver.findElement(By.id("tool-0"));
        tools.click();

        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Australia");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        String techlists = driver.getCurrentUrl();
        String expectedCodewarUrl = "https://www.techlistic.com/p/selenium-practice-form.html";

        String checkUrlCodewars = techlists.equals(expectedCodewarUrl) ? " url is passed" : " url is failed";
        System.out.println(checkUrlCodewars);

        Thread.sleep(3000);
        driver.close();



    }
}
