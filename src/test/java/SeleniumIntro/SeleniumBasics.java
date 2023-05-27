package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {


    /*

    first step seting up your automation

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions optins = new ChromeOptions();
        optins.addArguments("--remote-allow-origins=*");

        // Then create your driver to start automation
        WebDriver driver = new ChromeDriver(optins);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle= "Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "https://www.amazon.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url is passed");
        }else {
            System.out.println("Url is Failed");
        }

        driver.close();

    }
}
