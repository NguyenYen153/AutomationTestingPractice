package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public  static WebDriver getChromeDriver(){
        String chromeDriverLocation = null;
        String currentProjectLocation = System.getProperty("user.dir");
        System.out.println(currentProjectLocation);
        chromeDriverLocation = OS.isFamilyMac() ? currentProjectLocation.concat("/src/test/resource/drivers/chromedriver")
                :currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Chrome Browser option
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--incognito");

        //Start browser session
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        //Open a webpage
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
