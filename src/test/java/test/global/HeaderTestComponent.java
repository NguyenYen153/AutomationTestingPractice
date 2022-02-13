package test.global;

import driver.DriverFactory;
import models.components.global.header.HeaderComponent;
import models.pages.CategoryPage;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.HeaderTestFlow;
import url.Urls;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class HeaderTestComponent implements Urls {

    @Test
    public void testRegisterPageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(REGISTER_PAGE));

        try {
            HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
            headerTestFlow.verifyHeaderComponent(RegisterPage.class);
//            Thread.sleep(3000); // DEBUG PURPOSE ONLY
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
    @Test
    public void testHomepageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        try {
            HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
            headerTestFlow.verifyHeaderComponent(HomePage.class);
        } catch (Exception ignored){
            ignored.printStackTrace();
        }finally {
            driver.quit();
        }
    }
        @Test
        public void testCategorypageHeader() {
            WebDriver driver = DriverFactory.getChromeDriver();
            List<String> categorySlugs = Arrays.asList("/books", "/computers", "electronics");
            String randomSlug = categorySlugs.get(new SecureRandom().nextInt(categorySlugs.size()));
            driver.get(BASE_URL_2.concat(randomSlug));

            try {
                HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
                headerTestFlow.verifyHeaderComponent(CategoryPage.class);
            } catch (Exception ignored){
                ignored.printStackTrace();
            }finally {
                driver.quit();
            }
    }
}