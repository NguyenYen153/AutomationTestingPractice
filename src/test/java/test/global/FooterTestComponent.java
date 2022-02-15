package test.global;

import driver.DriverFactory;
import models.pages.CategoryPage;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import url.Urls;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class FooterTestComponent implements Urls {


    @Test
    public void testHomepageFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(HomePage.class);

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
    @Test
    public void testRegisterFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(REGISTER_PAGE));

        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(RegisterPage.class);

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
    @Test
    public void testCategoryPageFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        List<String> categorySlugs = Arrays.asList("/books", "/computers", "/electronics");
        String randomSlug = categorySlugs.get(new SecureRandom().nextInt(categorySlugs.size()));
        System.out.println(randomSlug);
        driver.get(BASE_URL_2.concat(randomSlug));

        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent(CategoryPage.class);

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}