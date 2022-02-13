package test.global;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import url.Urls;

public class FooterTestWithTestNG implements Urls {

    @Test (dependsOnMethods = {"importantMethod"})
    private void testHomepageFooter() {
        System.out.println("testHomepageFooter");
//        WebDriver driver = DriverFactory.getChromeDriver();
//        driver.get(BASE_URL_2.concat(HOME_PAGE));
//
//        try {
//            HomePage homePage = new HomePage(driver);
//            FooterComponent footerComponent = homePage.footerComponent();
//            InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();
//            CustomerServiceColumnComponent customerServiceColumnComp = footerComponent.customerServiceColumnComp();
//            AccountColumnComponent accountColumnComp = footerComponent.accountColumnComp();
//            FollowUsColumnComponent followUsColumnComponent = footerComponent.followUsColumnComponent();
//
//            GenericTestFlow genericTestFlow = new GenericTestFlow(driver);
//            genericTestFlow.testFooterColumn(informationColumnComp);
//            genericTestFlow.testFooterColumn(customerServiceColumnComp);
//            genericTestFlow.testFooterColumn(accountColumnComp);
//            genericTestFlow.testFooterColumn(followUsColumnComponent);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            driver.quit();
//        }
    }
    @Test (priority = 2)
    private void anotherTestMethod() {
        System.out.println("anotherTestMethod");
    }
    @Test
    private void importantMethod() {
        System.out.println("Important Method");
    }
    @Test(priority = 1)
    private void runByPriorityMethod() {
        System.out.println("runByPriority Method");
    }
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("Before Test| FooterTestWithTestNG");
//    }
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("Before Class| FooterTestWithTestNG");
//    }
//
//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("Before Suite");
//    }
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("After Suite");
//    }
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("Before Method");
//    }
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("After Method");
//    }
}