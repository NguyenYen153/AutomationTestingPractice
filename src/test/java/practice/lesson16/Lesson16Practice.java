package practices.lesson16;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class Lesson16Practice implements  Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(MY_TEST_SITE);

            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            // FORM HANDING : Get Username , password for standard user
//                WebElement loginBox = driver.findElement(By.className("login-box"));
            WebElement usernameElem = driver.findElement(By.id("user-name"));
            WebElement passwordElem = driver.findElement(By.id("password"));
            usernameElem.sendKeys("standard_user");
            passwordElem.sendKeys("secret_sauce");

            //Click button Login
            WebElement loginBtnElem = driver.findElement(By.id("login-button"));
            loginBtnElem.click();


            // Get price off this element
            WebElement itemElem = driver.findElement(By.cssSelector(".inventory_item"));
            WebElement priceOfElem = itemElem.findElement(By.cssSelector(".inventory_item_price"));
            System.out.println("Price of first item is: " + priceOfElem.getText());

            //Add a first items to cart
            WebElement addToCartBtnElem = itemElem.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));


            //Wait to see result
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
