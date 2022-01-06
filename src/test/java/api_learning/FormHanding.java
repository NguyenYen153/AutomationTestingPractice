package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHanding {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {//Open target page
            driver.get("https://the-internet.herokuapp.com/login");
            //FInd username/password elemant  by using username/password selector
            WebElement usernameElem = driver.findElement(By.id("username"));
            WebElement passwordElem = driver.findElement(By.cssSelector("#password"));

            //Input username and password

            usernameElem.sendKeys("Nguyen Yen");
            usernameElem.clear();
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("12345678");
            passwordElem.clear();
            passwordElem.sendKeys("SuperSecretPassword!");
            WebElement loginBtnElem = driver.findElement(By.cssSelector("#login button[type='submit']"));
            loginBtnElem.click();
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(3000);
        }
        finally {
            //Quit driver session
            driver.quit();
        }


    }
}
