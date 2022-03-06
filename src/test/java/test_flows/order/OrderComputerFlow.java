package test_flows.order;

import models.components.order.ComputerEssentialComponent;
import models.pages.ComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import test_data.ComputerDataObject;

public class OrderComputerFlow <T extends ComputerEssentialComponent>{
    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;
    private final ComputerDataObject computerDataObject;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent, ComputerDataObject computerDataObject) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
        this.computerDataObject = computerDataObject;
    }
    public void buildCompSpecAndAddTocart(){

        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);

        T compEssentialComp = computerItemDetailsPage.computerEssentialComp(computerEssentialComponent);
        compEssentialComp.selectProcessorType(computerDataObject.getProcessorType());
        compEssentialComp.selectRAMType(computerDataObject.getRamType());
        System.out.println(compEssentialComp.productPrice());
        compEssentialComp.setProductQuantity(10);
        compEssentialComp.clickOnAddToCartBtn();
    }
}
