package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {

    //Locators --> is a way to locate(find) element and manipulate on it

    public static void main(String[] args) throws InterruptedException {
        // ID LOCATOR:

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/User/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); // it gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "WRONG");

        WebElement header1 = driver.findElement(By.id("details2"));
        String actualHeader1 = header1.getText().trim();
        System.out.println(actualHeader1);

        //NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");

        WebElement lastname = driver.findElement(By.name("lastName"));

        lastname.sendKeys("Gul");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("929-627-0397");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("walter@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("501 Brigh Brooklyn");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("New-York");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("New-York");


        WebElement zipCode = driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("11235");


        //ClassLocatior

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "SELECTED" : "Not SELECTED");

        WebElement javaBox1 = driver.findElement(By.id("cond3"));
        if (javaBox1.isDisplayed() && !javaBox1.isSelected()) {
            javaBox1.click();
        }

        System.out.println(javaBox1.isSelected() ? "SELECTED" : "Not SELECTED");

        WebElement javaBox2 = driver.findElement(By.id("cond4"));
        if (javaBox2.isDisplayed() && !javaBox2.isSelected()) {
            javaBox2.click();
        }

        System.out.println(javaBox2.isSelected() ? "SELECTED" : "Not SELECTED");


        //TagName Locator:
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());


        WebElement tag = driver.findElement(By.tagName("u"));
        System.out.println(tag.getText());


        Thread.sleep(3000);
        driver.quit();

    }
}
