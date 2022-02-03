package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

import java.util.List;

public class DynamicControlElemInScope implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(BASE_URL_1.concat(DYNAMIC_CONTROL_PAGE));
            // FInd the checkbox-example form
            WebElement checkboxExampleFormElem = driver.findElement(By.id("check-example"));

            //Find the button in the checkbox-example form
            WebElement checkboxExampleFormBtnElem = checkboxExampleFormElem.findElement(By.cssSelector("button"));
            //Find the input-example form
            WebElement inputExampleFormElem = driver.findElement(By.id("input-example"));

            // Find the button in the input-example form
            WebElement inputExampleFormBtnElem = inputExampleFormElem.findElement(By.cssSelector("button"));

            //Click on those buttons
            checkboxExampleFormBtnElem.click();
            inputExampleFormBtnElem.click();

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
