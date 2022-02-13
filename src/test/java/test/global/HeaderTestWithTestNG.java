package test.global;

import driver.DriverFactory;
import models.components.global.header.HeaderComponent;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import url.Urls;

public class HeaderTestWithTestNG implements Urls {

    @Test
    private void testRegisterPageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        try {
            HomePage homePage = new HomePage(driver);
            HeaderComponent headerComponent = homePage.headerComp();
            headerComponent.searchInputElem().sendKeys("Laptop");
           // System.out.println("All Links: " + headerComponent.allLinksNumber());
            headerComponent.searchInputBtn().click();
            //Navigate to other page ->ERROR
            System.out.println("All Links: " + headerComponent.allLinksNumber());

//            Thread.sleep(3000); // DEBUG PURPOSE ONLY
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void testHomepageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(REGISTER_PAGE));

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.headerComp().searchInputElem().sendKeys("Laptop");
           // System.out.println("All Links: " + registerPage.headerComp().allLinksNumber());
            registerPage.headerComp().searchInputBtn().click();
            //Navigate to other page ->ERROR
            System.out.println("All Links: " + registerPage.headerComp().allLinksNumber());
            Thread.sleep(3000); // DEBUG PURPOSE ONLY
        } catch (Exception ignored){
            ignored.printStackTrace();
        }finally {
            driver.quit();
        }

    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test| HeaderTestWithTestNG");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class| HeaderTestWithTestNG");
    }
}