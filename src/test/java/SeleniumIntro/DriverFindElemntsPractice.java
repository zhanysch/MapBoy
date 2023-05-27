package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElemntsPractice {

    public static void main(String[] args) {


        /*

         */

        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait times
        driver.get("https://the-internet.herokuapp.com/"); //url

        List<WebElement> allBoxes = driver.findElements(By.tagName("li"));

        int count=0;


        for (WebElement bol : allBoxes){
            System.out.println(bol.getText());;
           count++;

        }
        System.out.println(count);
        driver.quit();



        int count2=0;
        for (WebElement bol : allBoxes){

            if (bol.getText().length()>=12){
                System.out.println(bol.getText());
                count2++;
            }
        }
        System.out.println(count2);
        driver.quit();



    }
}
