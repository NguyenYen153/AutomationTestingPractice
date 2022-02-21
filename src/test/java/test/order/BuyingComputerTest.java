package test.order;

import driver.DriverFactory;
import models.components.order.CheapComputerComponent;
import models.components.order.StandardComputerComponent;
import models.pages.ComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.BaseTest;
import url.Urls;

public class BuyingComputerTest extends BaseTest implements Urls {
    @Test
    public void testCheapComBuying() throws InterruptedException {

        driver.get(BASE_URL_2.concat("/build-your-cheap-own-computer"));

        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);

        CheapComputerComponent cheapComputerComp = computerItemDetailsPage.computerEssentialComp(CheapComputerComponent.class);
        cheapComputerComp.selectProcessorType("Fast");
        Thread.sleep(2000);//FoR DEBUG
        cheapComputerComp.selectRAMType("4 GB");
        Thread.sleep(2000);//FoR DEBUG
        System.out.println(cheapComputerComp.productPrice());
        cheapComputerComp.setProductQuantity(10);
        Thread.sleep(2000);
        cheapComputerComp.clickOnAddToCartBtn();
    }
    @Test
    public void testStandardComBuying() throws InterruptedException {

        driver.get(BASE_URL_2.concat("/build-your-own-computer"));


        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);
        StandardComputerComponent standarComputerComp = computerItemDetailsPage.computerEssentialComp(StandardComputerComponent.class);
        standarComputerComp.selectProcessorType("2.5GHz");
        Thread.sleep(2000);//FoR DEBUG
        standarComputerComp.selectRAMType("8GB");
        Thread.sleep(2000);//FoR DEBUG
        System.out.println(standarComputerComp.productPrice());
        standarComputerComp.setProductQuantity(15);
        Thread.sleep(2000);
        standarComputerComp.clickOnAddToCartBtn();
    }
}