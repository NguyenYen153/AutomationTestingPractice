package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class DynamicControlExplicitWaiting implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(BASE_URL_1.concat(DYNAMIC_CONTROL_PAGE));
            // * FInd the checkbox-example form
//            WebElement checkboxExampleFormElem = driver.findElement(By.id("check-example"));
//
//            // * Find the button in the checkbox-example form
//            WebElement checkboxExampleFormBtnElem = checkboxExampleFormElem.findElement(By.cssSelector("button"));
//
//            // * Click on those buttons
//            checkboxExampleFormBtnElem.click();
//
//             //Get the mess content
//            WebElement checkboxMessElem = wait.until(ExpectedConditions.visibilityOf(checkboxExampleFormElem.findElement(By.id("message"))));
//            System.out.println(checkboxMessElem.getText());
//            //////////////////////////////////
            // * Wait until checkbox disappeared
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
//        //   wait.until(ExpectedConditions.invisibilityOf(checkboxExampleFormElem.findElement(By.tagName("input"))));
//
//            //Wait until mess appeared
            WebElement inputExampleFormElem = driver.findElement(By.id("input-example"));

            WebElement inputExampleFormBtnElem = inputExampleFormElem.findElement(By.cssSelector("button"));
            inputExampleFormBtnElem.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example input")));
            inputExampleFormElem.findElement(By.tagName("input")).sendKeys("Hello");


            //Get CSS value
            System.out.println("Back ground color" + inputExampleFormBtnElem.getCssValue("background-color"));
            System.out.println("Border bottom color " + inputExampleFormBtnElem.getCssValue("border-bottom-color"));

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
