package test.global;

import driver.DriverFactory;
import models.pages.CategoryPage;
import models.pages.HomePage;
import models.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.FooterTestFlow;
import url.Urls;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class FooterTestWithBasePage extends BaseTest implements Urls {

    @Test
    public void testHomepageFooter() {
        WebDriver driver = getDriver();
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent(HomePage.class);
    }
    @Test
    public void testRegisterFooter() {
        WebDriver driver = getDriver();
        driver.get(BASE_URL_2.concat(REGISTER_PAGE));

        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent(RegisterPage.class);
    }
    @Test
    public void testCategoryPageFooter() {
        WebDriver driver = getDriver();
        List<String> categorySlugs = Arrays.asList("/books", "/computers", "/electronics");
        String randomSlug = categorySlugs.get(new SecureRandom().nextInt(categorySlugs.size()));
        System.out.println("RandomSlug " + randomSlug);
        driver.get(BASE_URL_2.concat(randomSlug));
        // CAPTURE screenshot
        Assert.fail();
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent(CategoryPage.class);
    }
}