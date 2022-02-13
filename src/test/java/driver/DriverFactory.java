package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.exec.OS;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public  static WebDriver getChromeDriver(){
        //Using file driver .exe
//        String chromeDriverLocation = null;
//        String currentProjectLocation = System.getProperty("user.dir");
        //System.out.println(currentProjectLocation);
        //chromeDriverLocation = OS.isFamilyMac() ? currentProjectLocation.concat("/src/test/resource/drivers/chromedriver")
                //:currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Chrome Browser option

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--incognito");

        //Start browser session - User WebDriver Management
       // System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        WebDriverManager.chromedriver().setup();
        //Open a webpage
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
