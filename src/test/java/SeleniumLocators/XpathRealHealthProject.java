package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathRealHealthProject {

    public static void main(String[] args) throws InterruptedException {
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");



        /*WebElement btn = driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        btn.click();*/
        WebElement makeApointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeApointment.click();

        WebElement login = driver.findElement(By.xpath("//input[@id='txt-username']"));
        login.sendKeys("John Doe");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@id='txt-password']"));
        repeatPassword.sendKeys("ThisIsNotAPassword");


        WebElement btnLog = driver.findElement(By.xpath("//button[@id='btn-login']"));
        btnLog.click();

        WebElement choose = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        choose.sendKeys("Seoul CURA Healthcare Center");


        WebElement checkBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        checkBox.click();

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        checkBox2.click();


        WebElement input= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        input.sendKeys("10/05/2023");

        WebElement input2= driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        input2.sendKeys("10/05/2023");

        Thread.sleep(2000);


        /*WebElement book = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        book.click();*/

        WebElement book = driver.findElement(By.cssSelector(".btn-default"));
        book.click();







        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        WebElement title = driver.findElement(By.xpath("//p[contains(text(),'booked as following:')]"));
        System.out.println(title.getText());

        WebElement goHomePage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        goHomePage.click();

        Thread.sleep(4000);

        driver.close();



    }
}
