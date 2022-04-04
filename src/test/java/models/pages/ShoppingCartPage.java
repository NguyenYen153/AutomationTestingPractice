package models.pages;
import java.util.List;
import models.components.cart.CartItemRowComponent;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public List<CartItemRowComponent> cartItemRowComponents(){
        return findComponents(CartItemRowComponent.class, driver);
    }
}
