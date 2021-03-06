package test.order;

import io.qameta.allure.Description;
import models.components.order.StandardComputerComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.ComputerDataObject;
import test_data.CreditCardType;
import test_data.PaymentMethod;
import test_flows.order.OrderComputerFlow;
import url.Urls;
import utils.data.DataObjectBuilder;

import java.security.SecureRandom;

public class StandardComputerBuyingTest extends BaseTest implements Urls {
    private double allItemPrices = 0;
    @Description("Buying  Standard Computer with data set")
    @Test (dataProvider = "standarCompDataSet",description = "Buying standard computer")
    public void testStandardComBuying(ComputerDataObject computerDataObject){
        WebDriver driver = getDriver();
        driver.get(BASE_URL_2.concat("/build-your-own-computer"));
        int itemQuantity = new SecureRandom().nextInt(100) + 1;
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerDataObject);
        allItemPrices = allItemPrices + orderComputerFlow.buildCompSpecAndAddTocart();
        orderComputerFlow.verifyShoppingCart(allItemPrices);
        orderComputerFlow.agreeTosAndCheckoutAsGuest();
        orderComputerFlow.inputBillingAddress();
        orderComputerFlow.inputShippingAddress();
        orderComputerFlow.selectShippingMethod();
        orderComputerFlow.selectPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderComputerFlow.inputPaymentInfo(CreditCardType.VISA);
        orderComputerFlow.confirmOrder();
        allItemPrices = 0;

    }
    @DataProvider
    public ComputerDataObject[] standarCompDataSet(){
        String standarCompDataListLocation = "/src/test/resources/test-data/order/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(standarCompDataListLocation, ComputerDataObject[].class);
    }
}