package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions optins = new ChromeOptions();
        optins.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(optins);
        driver.get("https://irokez.io/");
        System.out.println(driver.getTitle());

        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "IROKEZ";

       String title1 = actualTitle1.equals(expectedTitle1) ? "Irokez title is passed" : "Irokez title is failed";
        System.out.println(title1);
        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl2 = "https://irokez.io/";

        String title2 = actualUrl1.equals(expectedUrl2) ? "Irokez url is passed" : "Irokez url is failed";
        System.out.println(title2);
        driver.close();


        //Codewars
       driver = new ChromeDriver(optins);

        driver.get("https://github.com/");
        System.out.println(driver.getTitle());
        String codewarTitle = driver.getTitle();
        String expectCodewar = "GitHub: Let’s build from here · GitHub";

        String codewarsTitle1 = codewarTitle.equals(expectCodewar) ? "GithubGithub title is passed" : "Github title is failed";
        System.out.println(codewarsTitle1);

        String codewarActualUrl = driver.getCurrentUrl();
        String expectedCodewarUrl = "https://github.com/";

        String checkUrlCodewars = codewarActualUrl.equals(expectedCodewarUrl) ? "Github url is passed" : "Github url is failed";
        System.out.println(checkUrlCodewars);
        driver.close();


        driver = new ChromeDriver(optins);
        driver.get("https://www.facebook.com/");

        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "Facebook - log in or sign up";

        String title3 = actualTitle3.equals(expectedTitle3) ? "Facebook title is passed" : "Facebook title failed";
        System.out.println(title3);

        String actualUrl3 = driver.getCurrentUrl();
        String expectedUrl3= "https://www.facebook.com/";

        String url3 = actualUrl3.equals(expectedUrl3) ? "Facebook URl is passed " : "Facebook url is failed";
        System.out.println(url3);
        driver.close();



    }
}
