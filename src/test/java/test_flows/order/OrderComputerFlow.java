package test_flows.order;

import models.components.cart.CartItemRowComponent;
import models.components.order.ComputerEssentialComponent;
import models.pages.ComputerItemDetailsPage;
import models.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.ComputerDataObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class OrderComputerFlow <T extends ComputerEssentialComponent>{
    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;
    private final ComputerDataObject computerDataObject;
    private int itemQuantity;
    private double totalItemPrice;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent, ComputerDataObject computerDataObject) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
        this.computerDataObject = computerDataObject;
    }
    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent, ComputerDataObject computerDataObject, int itemQuantity) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
        this.computerDataObject = computerDataObject;
        this.itemQuantity = itemQuantity;
    }
    public double buildCompSpecAndAddTocart(){

        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);

        T compEssentialComp = computerItemDetailsPage.computerEssentialComp(computerEssentialComponent);
        // Unselect all default option
        compEssentialComp.unselectDefaultOptions();

        String processFullStr = compEssentialComp.selectProcessorType(computerDataObject.getProcessorType());
        double additionalProcessPrice =   extractAdditionalPrice(processFullStr);

        String ramFullStr = compEssentialComp.selectRAMType(computerDataObject.getRamType());
        double additionalRAMPrice = extractAdditionalPrice(ramFullStr);

        if(itemQuantity !=0 ){
            compEssentialComp.setProductQuantity(itemQuantity);
        }
        System.out.println(compEssentialComp.productPrice());
        String hddFullStr = compEssentialComp.selectHDD(computerDataObject.getHdd());
        double additionalHDDPrice = extractAdditionalPrice(hddFullStr);

        double additionalOsPrice = 0;

        if(computerDataObject.getOs() != null){
            String osFullStr = compEssentialComp.selectOsType(computerDataObject.getOs());
            additionalOsPrice = extractAdditionalPrice(osFullStr);
        }
        String softwareFullStr = compEssentialComp.selectSoftware(computerDataObject.getSoftWare());
        double additionalSoftwarePrice = extractAdditionalPrice(softwareFullStr);

        double basePrice = compEssentialComp.productPrice();
        double additionalPrices =
                additionalProcessPrice + additionalRAMPrice + additionalHDDPrice + additionalOsPrice + additionalSoftwarePrice;

        int currentItemQuantity = itemQuantity == 0 ? 1 : itemQuantity;
        totalItemPrice = (basePrice + additionalPrices) * currentItemQuantity;

        compEssentialComp.clickOnAddToCartBtn();
        // Wait until the item added to cart
        compEssentialComp.waitUntilItemAddedToCart();
        // Then navigate to shopping cart
        computerItemDetailsPage.headerComp().clickOnShoppingCartLink();
        return totalItemPrice;
    }
    private double extractAdditionalPrice(String itemStr){
        double price = 0;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(itemStr);
        if(matcher.find()){
            price = Double.parseDouble(matcher.group(1).replaceAll("[-+]", ""));
        }
        return price;
    }
    public void verifyShoppingCart(double allItemPrices){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<CartItemRowComponent> cartItemRowComps = shoppingCartPage.cartItemRowComponents();
        Assert.assertTrue(cartItemRowComps.size() > 0, "[ERR] No item displayed in shopping cart!");

        double currentSubTotals = 0;
        for (CartItemRowComponent cartItemRowComp : cartItemRowComps) {
            currentSubTotals =  currentSubTotals + cartItemRowComp.subTotal();

        }
        Assert.assertEquals(currentSubTotals, allItemPrices, "[ERR] Shopping cart item's subtotal is incorrect!");
    }



}
