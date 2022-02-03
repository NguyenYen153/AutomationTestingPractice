package test.global;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class FooterTest implements Urls {

    public static void main(String[] args) {
        testHomepageFooter();
    }

    private static void testHomepageFooter() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat(HOME_PAGE));

        try {
            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComponent();
            InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();
            CustomerServiceColumnComponent customerServiceColumnComp = footerComponent.customerServiceColumnComp();
            AccountColumnComponent accountColumnComp = footerComponent.accountColumnComp();
            FollowUsColumnComponent followUsColumnComponent = footerComponent.followUsColumnComponent();

            GenericTestFlow genericTestFlow = new GenericTestFlow(driver);
            genericTestFlow.testFooterColumn(informationColumnComp);
            genericTestFlow.testFooterColumn(customerServiceColumnComp);
            genericTestFlow.testFooterColumn(accountColumnComp);
            genericTestFlow.testFooterColumn(followUsColumnComponent);

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}