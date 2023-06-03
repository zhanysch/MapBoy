package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/User/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "False");
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement actualHeaSel = driver.findElement(By.tagName("p"));
        String actualheadeSel = actualHeaSel.getText().trim();
        String expectedHead = "What you do with that power is entirely up to you.";
        System.out.println(actualheadeSel.equals(expectedHead) ? "Correct Selen" : "Wrong Selenium");
        driver.navigate().back();


        WebElement cucumbLink = driver.findElement(By.linkText("Cucumber"));
        cucumbLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualheader = header.getText().trim();
        String expectedHeadCucu = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualheader.equals(expectedHeadCucu) ? "Correct Cucumb" : "Wrong Cucumb");
        driver.navigate().back();

        WebElement ngLink = driver.findElement(By.linkText("TestNG"));
        ngLink.click();
        WebElement headerNg = driver.findElement(By.tagName("h2"));
        String actualheaderng = headerNg.getText().trim();
        String expectedHeadNG = "TestNG";
        System.out.println(actualheaderng.equals(expectedHeadNG) ? "Correct NG" : "Wrong NG");
        driver.navigate().back();

        WebElement restApi = driver.findElement(By.linkText("Rest Api"));
        restApi.click();
        WebElement headerReastApi = driver.findElement(By.tagName("p"));
        String actualheaderApi= headerReastApi.getText();
        String expectedHeadRestApi = "Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy. REST Assured brings the simplicity of using these\n" +
                "languages into the Java domain. For example, if your HTTP server returns the following ";
        System.out.println(actualheaderApi.equals(expectedHeadRestApi) ? "Correct Api" : "Wrong Api");
        driver.navigate().back();

        //LOCATOR PARTIALLINKTEXT:

        WebElement resteApi = driver.findElement(By.partialLinkText("Rest"));
        resteApi.click();
        System.out.println(driver.getTitle());


    }
}
