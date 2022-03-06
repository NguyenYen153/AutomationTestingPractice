package test.order;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flows.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

public class StandarComputerBuyingTest extends BaseTest implements Urls {
    @Test (dataProvider = "standarCompDataSet")
    public void testStandardComBuying(ComputerDataObject computerDataObject){

        driver.get(BASE_URL_2.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddTocart();

    }
    @DataProvider
    public ComputerDataObject[] standarCompDataSet(){
        String standarCompDataListLocation = "/src/test/resources/test-data/order/StanderComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(standarCompDataListLocation, ComputerDataObject[].class);
    }
}