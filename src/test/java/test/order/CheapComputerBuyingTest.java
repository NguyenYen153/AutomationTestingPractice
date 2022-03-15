package test.order;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import models.components.order.CheapComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_flows.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

public class CheapComputerBuyingTest extends BaseTest implements Urls {
    @Description("Buying Cheap Computer with data set")
    @Test (dataProvider = "cheapCompDataSet", description = "Buying cheap computer")
    //Them variable in pom.file
    @TmsLink("TC_001")//TmsLinks({@TmsLink("TC_001"), @TmsLink("TC_002")})
    @TmsLink("TC_002")
    public void testCheapComBuying(ComputerDataObject computerDataObject){
        WebDriver driver = getDriver();
        driver.get(BASE_URL_2.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerDataObject);
        orderComputerFlow.buildCompSpecAndAddTocart();

    }
    //When method have a bug
    @Ignore
    @Issue("JIRA_link")
    @Test
    public void testSomething(){
        System.out.println("Test something");
    }
    @DataProvider
    public ComputerDataObject[] cheapCompDataSet(){
        String cheapCompDataListLocation = "/src/test/resources/test-data/order/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(cheapCompDataListLocation, ComputerDataObject[].class);
    }
}