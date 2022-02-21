package models.components.order;

import models.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailsComponent extends Component {

    private  final By productPriceSel = By.cssSelector(".product-price");
    private  final By productQuantityInputSel = By.cssSelector(".qty-input");
    private  final By addToCartBtnSel = By.cssSelector(".add-to-cart-button");
    public BaseItemDetailsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice(){
        String productPriceText = component.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }
    public void setProductQuantity(int quantity){
        WebElement productQuantityElem = component.findElement(productQuantityInputSel);
        productQuantityElem.clear();
        productQuantityElem.sendKeys(String.valueOf(quantity));
    }
    public void clickOnAddToCartBtn(){
        component.findElement(addToCartBtnSel).click();
        
    }
}
