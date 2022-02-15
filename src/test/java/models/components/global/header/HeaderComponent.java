package models.components.global.header;
import models.Component;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {

    private static final By searchInputSel = By.cssSelector("form input");
    private static final By searchInputBtnSel = By.cssSelector(".search-box-button");
    private static final By allLinksSel = By.tagName("a");
    private static final By allLinksWrapperSel = By.cssSelector("li a");
    private static final By cartQtySel = By.id("topcartlink");

    public HeaderComponent(WebDriver driver, WebElement element) {
        super(driver, element);
        this.driver = driver;
    }
    public LogoComponent logoComp(){
        return findComponent(LogoComponent.class, driver);
    }

    public WebElement searchInputElem(){
        return this.component.findElement(searchInputSel);
    }

    public WebElement searchInputBtn(){
        return this.component.findElement(searchInputBtnSel);
    }

    public int allLinksNumber(){
        return this.component.findElements(allLinksSel).size();
    }
    public List<WebElement> allLinkHrefsWrapper(){
        return this.component.findElements(allLinksWrapperSel);
    }
    public WebElement cartQtyItem (){
        return this.component.findElement(cartQtySel);
    }
}