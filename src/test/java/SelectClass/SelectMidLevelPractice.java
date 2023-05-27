package SelectClass;
import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {

    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement checkbox = driver.findElement(By.xpath("//input[@value='oneway']"));
        checkbox.click();

        WebElement optionBOXPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select choicePassenger = new Select(optionBOXPass);
        choicePassenger.selectByIndex(3);
        Thread.sleep(3000);
        WebElement optionCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choice = new Select(optionCity);
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedOption = "Acapulco";
        Assert.assertEquals(actualDefaultOption,expectedOption);
        choice.selectByValue("Paris");
        WebElement pickDepartDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select chossedate = new Select(pickDepartDay);
        chossedate.selectByValue("15");
        WebElement pickDepartMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select chosseMonth = new Select(pickDepartMonth);
        chosseMonth.selectByVisibleText("August");
        WebElement arrivCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select choiceArrCity = new Select(arrivCity);
        choiceArrCity.selectByValue("San Francisco");
        Thread.sleep(3000);
        WebElement arriveDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select chossearriveDate = new Select(arriveDate);
        chossearriveDate.selectByVisibleText("December");
        WebElement pickArriveDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select chosseArriveDay = new Select(pickArriveDay);
        chosseArriveDay.selectByValue("15");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='First']"));
        checkbox1.click();
        WebElement optionBOX = driver.findElement(By.xpath("//select[@name='airline']"));
        Select validateList = new Select(optionBOX);
        List<WebElement> actualOptions = validateList.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i =0; i<actualOptions.size();i++){
            Assert.assertEquals(actualOptions.get(i).getText().trim(), expectedOptions.get(i).trim());
        }
        validateList.selectByVisibleText("Unified Airlines");
        WebElement continueBut = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBut.click();
        WebElement confirmMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = confirmMessage.getText().trim();
        String expectedMessage = "";
        Assert.assertEquals(actualMessage,expectedMessage);






    }


    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement checkbox = driver.findElement(By.xpath("//input[@value='oneway']"));
        checkbox.click();

        WebElement optionBOXPass = driver.findElement(By.xpath("//select[@name='passCount']"));

        BrowserUtils.selectByMethod(optionBOXPass,"4","value");
        Thread.sleep(3000);
        WebElement optionCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choice = new Select(optionCity);
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedOption = "Acapulco";
        Assert.assertEquals(actualDefaultOption,expectedOption);
        /*choice.selectByValue("Paris");*/
        BrowserUtils.selectByMethod(optionCity,"Paris","text");


        WebElement pickDepartDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select chossedate = new Select(pickDepartDay);
        chossedate.selectByValue("15");
        BrowserUtils.selectByMethod(pickDepartDay,"3","value");

        WebElement pickDepartMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
     /*   Select chosseMonth = new Select(pickDepartMonth);
        chosseMonth.selectByVisibleText("August");*/

        BrowserUtils.selectByMethod(pickDepartMonth,"August","text");

        WebElement arrivCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectByMethod(arrivCity,"San Francisco","value");

        Thread.sleep(3000);
        WebElement arriveDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectByMethod(arriveDate,"December","text");
        WebElement pickArriveDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectByMethod(pickArriveDay,"15","value");

        /*Select chosseArriveDay = new Select(pickArriveDay);
        chosseArriveDay.selectByValue("15");*/
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='First']"));
        checkbox1.click();
        WebElement optionBOX = driver.findElement(By.xpath("//select[@name='airline']"));
        Select validateList = new Select(optionBOX);
        List<WebElement> actualOptions = validateList.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i =0; i<actualOptions.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualOptions.get(i)), expectedOptions.get(i).trim());
        }
        validateList.selectByVisibleText("Unified Airlines");
        WebElement continueBut = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBut.click();
        WebElement confirmMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = BrowserUtils.getText(confirmMessage);
        String expectedMessage = "";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
