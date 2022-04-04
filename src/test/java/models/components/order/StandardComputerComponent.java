package models.components.order;

import io.qameta.allure.Step;
import models.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {
    public static final By productAttibuteSel = By.xpath("//select[contains(@id, 'product_attribute')]");
    public static final int PROCESSOR_DROPDOWN_INDEX = 0;
    public static final int RAM_DROPDOWN_INDEX = 1;

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    @Step("Select processor type as {prefixValue}")
    public String selectProcessorType(String prefixValue) {
        WebElement processorDropdownElem = component.findElements(productAttibuteSel).get(PROCESSOR_DROPDOWN_INDEX);
        return selectOption(processorDropdownElem, prefixValue);
        //System.out.println("selectProcessorType | StandardComputerComponent");
    }

    @Override
    @Step("Select RAM type as {prefixValue}")
    public String selectRAMType(String prefixValue) {
        WebElement ramDropdownElem = component.findElements(productAttibuteSel).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownElem, prefixValue);
        //System.out.println("selectRAMType | StandardComputerComponent");
    }
    private String selectOption(WebElement dropdownElem, String prefixValue){
        Select select = new Select(dropdownElem);
        //Get all options
        List<WebElement> allOptions = select.getOptions();
        String fullStrOption = null;
        for (WebElement option : allOptions) {
            String currenOptionText = option.getText();
            String optionText = currenOptionText.trim().replaceAll(" ","");
            if (optionText.startsWith(prefixValue)){
                fullStrOption = currenOptionText;
                break;
            }
        }
        if (fullStrOption == null){
            throw new IllegalArgumentException("[ERR] The option " + prefixValue + " is not in the dropdown");
        }
        select.selectByVisibleText(fullStrOption);
        return fullStrOption;
    }
}