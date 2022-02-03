package test.order;

import driver.DriverFactory;
import models.components.order.CheapComputerComponent;
import models.components.order.StandardComputerComponent;
import models.pages.ComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class BuyingComputerTest implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(BASE_URL_2.concat("/build-your-cheap-own-computer"));

        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);

        CheapComputerComponent cheapComputerComp =
                computerItemDetailsPage.computerEssentialComp(CheapComputerComponent.class);
        cheapComputerComp.selectProcessorType("ajlfjaf");
        cheapComputerComp.selectRAMType("ajlfjaf");

        StandardComputerComponent standardComputerComp =
                computerItemDetailsPage.computerEssentialComp(StandardComputerComponent.class);
        standardComputerComp.selectProcessorType("ajlfjaf");
        standardComputerComp.selectRAMType("ajlfjaf");


    }
}