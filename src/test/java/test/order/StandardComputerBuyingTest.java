package test.order;

import io.qameta.allure.Description;
import models.components.order.StandardComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flows.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

public class StandardComputerBuyingTest extends BaseTest implements Urls {
    @Description("Buying  Standard Computer with data set")
    @Test (dataProvider = "standarCompDataSet",description = "Buying standard computer")
    public void testStandardComBuying(ComputerDataObject computerDataObject){
        WebDriver driver = getDriver();
        driver.get(BASE_URL_2.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddTocart();

    }
    @DataProvider
    public ComputerDataObject[] standarCompDataSet(){
        String standarCompDataListLocation = "/src/test/resources/test-data/order/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(standarCompDataListLocation, ComputerDataObject[].class);
    }
}