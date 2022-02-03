package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

import java.util.List;

public class DynamicControl implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(BASE_URL_1.concat(DYNAMIC_CONTROL_PAGE));
            // get a list of button on the page
            List<WebElement> btnElems = driver.findElements(By.cssSelector("button"));
            final  int REMOVE_SECTION_BTN_INDEX = 0;
            final  int ENABLE_SECTION_BTN_INDEX = 1;
            btnElems.get(REMOVE_SECTION_BTN_INDEX).click();
            btnElems.get(ENABLE_SECTION_BTN_INDEX).click();


            List<WebElement> notFoundElems = driver.findElements(By.className("NotFound"));
            System.out.println(notFoundElems.isEmpty());
            //Handle false positive
            if (notFoundElems.isEmpty()){
                throw new RuntimeException("The element X is emty");
            }
            for (WebElement notFoundElem : notFoundElems){
                //Verificaion points reelated to notFoundElem
            }
            System.out.println(btnElems.size());
            //How to check an element not in page
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
