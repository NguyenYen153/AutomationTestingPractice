package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class DriverFactoryEx {
    private WebDriver driver;
    public  WebDriver getChromeDriver(){
        //Using file driver .exe
//        String chromeDriverLocation = null;
//        String currentProjectLocation = System.getProperty("user.dir");
        //System.out.println(currentProjectLocation);
        //chromeDriverLocation = OS.isFamilyMac() ? currentProjectLocation.concat("/src/test/resource/drivers/chromedriver")
                //:currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Chrome Browser option
        if (driver != null){
            return driver;
        }
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--incognito");

        //Start browser session - User WebDriver Management
       // System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        WebDriverManager.chromedriver().setup();
        //Open a webpage
        driver = new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public WebDriver getDriver(String browserName) {
        if (driver != null) {
            return driver;
        } else {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            BrowserType browserType;
            try {
                browserType = BrowserType.valueOf(browserName);
            } catch (Exception e) {
                throw new IllegalArgumentException("The provided browser " + browserName + " is not supported!");
            }

            switch (browserType) {
                case chrome:
                    desiredCapabilities.setBrowserName("chrome");
                    break;
                case firefox:
                    desiredCapabilities.setBrowserName("firefox");
                    break;
                case safari:
                    desiredCapabilities.setBrowserName("safari");
                    break;
                case edge:
                    desiredCapabilities.setBrowserName("edge");
                    break;
            }

            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return driver;
    }
}
