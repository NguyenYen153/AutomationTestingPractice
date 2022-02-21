package test.global;

import driver.DriverFactory;
import models.pages.CategoryPage;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.HeaderTestFlow;
import url.Urls;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class HeaderTestWithBaseTest extends BaseTest implements Urls {

    @Test
    public void testRegisterPageHeader() {
        driver.get(BASE_URL_2.concat(REGISTER_PAGE));

            HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
            headerTestFlow.verifyHeaderComponent(RegisterPage.class);
    }
    @Test
    public void testHomepageHeader() {
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
        headerTestFlow.verifyHeaderComponent(HomePage.class);
    }
        @Test
        public void testCategorypageHeader() {
            List<String> categorySlugs = Arrays.asList("/books", "/computers", "/electronics");
            String randomSlug = categorySlugs.get(new SecureRandom().nextInt(categorySlugs.size()));
            driver.get(BASE_URL_2.concat(randomSlug));
            // CAPTURE screenshot
            //Assert.fail();
            HeaderTestFlow headerTestFlow = new HeaderTestFlow(driver);
            headerTestFlow.verifyHeaderComponent(CategoryPage.class);
    }
}