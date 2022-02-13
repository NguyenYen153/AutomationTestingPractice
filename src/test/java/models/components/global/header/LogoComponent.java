package models.components.global.header;
import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header-logo")
public class LogoComponent extends Component {

    private static final By logoLinkSel = By.cssSelector("a");
    private static final By logoLinkImgSel = By.cssSelector("a img");


    public LogoComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement logoLinkElem(){
        return this.component.findElement(logoLinkSel);
    }

    public WebElement logoImgElem(){
        return this.component.findElement(logoLinkImgSel);
    }

}