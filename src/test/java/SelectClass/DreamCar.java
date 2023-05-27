package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DreamCar {

     /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

    @Test
    public void HeadersOfTheCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement newCar = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectByMethod(newCar,"new","value");

        WebElement makePart = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectByMethod(makePart,"lexus","value");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectByMethod(model,"lexus-rx_350","value");

        WebElement maxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select maxPriceoption = new Select(maxPrice);
        String actualDefaultOption = BrowserUtils.getText(maxPriceoption.getFirstSelectedOption());
        String expectedOption = "No max price";
        Assert.assertEquals(actualDefaultOption,expectedOption);

        WebElement chooseDistance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectByMethod(chooseDistance,"40","value");

        WebElement chooseZipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        chooseZipCode.clear();
        Thread.sleep(3000);
        chooseZipCode.sendKeys("11235");

        WebElement button = driver.findElement(By.xpath("//button[@class='sds-button']"));
        button.click();

        WebElement newLex = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualMessage = BrowserUtils.getText(newLex);
        String expectedMessage = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualMessage,expectedMessage);




        WebElement sort = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(3000);
        BrowserUtils.selectByMethod(sort,"list_price","value");
        Thread.sleep(3000);

        List<WebElement> title = driver.findElements(By.xpath("//h2[@class='title']"));


        for (WebElement titles : title) {


           Assert.assertTrue(BrowserUtils.getText(titles).contains("Lexus RX 350"));

            System.out.println(BrowserUtils.getText(titles));

        }

        List<WebElement> allprice = driver.findElements(By.xpath("//span[@class='primary-price']"));

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for (int i = 0; i<allprice.size(); i++){

            String valid = BrowserUtils.getText(allprice.get(i)).replace("$","").replace(",","");

            actual.add(Integer.parseInt(valid));
            expected.add(Integer.parseInt(valid));
        }
;
       Collections.sort(expected);
        Assert.assertEquals(actual,expected);

        System.out.println(expected);

    }


}
