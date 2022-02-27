package test.order;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flows.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

public class CheapComputerBuyingTest extends BaseTest implements Urls {
    @Test (dataProvider = "cheapComDataSet")
    public void testCheapComBuying(ComputerDataObject computerDataObject){

        driver.get(BASE_URL_2.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddTocart();

    }
    @DataProvider
    public ComputerDataObject[] cheapCompDataSet(){
        String cheapCompDataListLocation = "/src/test/resources/test-data/order/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }
}