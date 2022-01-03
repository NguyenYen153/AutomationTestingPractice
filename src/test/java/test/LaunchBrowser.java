package test;


import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) throws  InterruptedException {
        //Location of Webdriver
        String chromeDriverLocation = null;
        String currentProjectLocation = System.getProperty("user.dir");
        System.out.println(currentProjectLocation);
        chromeDriverLocation = OS.isFamilyMac() ? currentProjectLocation.concat("/AutomationTestingPractice/src/test/resource/drivers/chromedriver")
        :currentProjectLocation.concat("\\AutomationTestingPractice\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Chrome Browser option
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--incognito");

        //Start browser session
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        //Open a webpage
        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
