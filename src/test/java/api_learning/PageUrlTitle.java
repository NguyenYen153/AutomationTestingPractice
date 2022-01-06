package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUrlTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {//Open target page
            driver.get("https://the-internet.herokuapp.com/");
            //FInd username/password elemant  by using username/password selector
            //WebElement powerByLinkTextElem = driver.findElement(By.linkText("Elemental Selenium"));
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

            Thread.sleep(3000);
        }
        finally {
            //Quit driver session
            driver.quit();
        }
    }
}
