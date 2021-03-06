package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

import static url.Urls.BASE_URL_1;

public class JSAlert implements Urls {
    private static final By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
    private static final By jsConfirmSel = By.cssSelector("[onclick='jsConfirm()']");
    private static final By jsPromptSel = By.cssSelector("[onclick='jsPrompt()']");
    private static final By resultSel = By.id("result");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to the test page
            driver.get(BASE_URL_1.concat(JAVASCRIPT_ALERTS));
            WebElement resultElem = driver.findElement(resultSel);

            // JS alert - Only on button
            driver.findElement(jsAlertSel).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Js Alert content: " + jsAlert.getText());
            Thread.sleep(1000);
            jsAlert.accept();
            System.out.println(resultElem.getText());
            Thread.sleep(1000);
            System.out.println("====================");
            //Reload page (ERROR: stale element reference -> Find element again)
            //driver.navigate().refresh();

            // JS confirm - 2 button Yes/No
            driver.findElement(jsConfirmSel).click();
            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Js Confirm content: " + jsConfirm.getText());
            Thread.sleep(1000);
            jsAlert.dismiss();
            System.out.println(resultElem.getText());
            Thread.sleep(1000);
            System.out.println("====================");

            // JS prompt - Include input text
            driver.findElement(jsPromptSel).click();
            Alert jsPrompt = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Js Prompt content: " + jsPrompt.getText());
            Thread.sleep(1000);
            jsPrompt.sendKeys("Hello World!");
            Thread.sleep(1000);
            jsPrompt.accept();
            System.out.println(resultElem.getText());
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
