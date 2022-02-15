package test_flows.global;

import models.components.global.header.HeaderComponent;
import models.components.global.header.LogoComponent;
import models.pages.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderTestFlow {
    private WebDriver driver;

    public HeaderTestFlow(WebDriver driver) {
        this.driver = driver;
    }
    public  void verifyHeaderComponent(Class<? extends BasePage> pageClass){
        BasePage page = null;
        try{
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HeaderComponent headerComponent = page.headerComp();
        verifyLogoImg(headerComponent);
        verifySearchBox(headerComponent);
        verifyHeaderLinkWapper(headerComponent);
    }
    private void verifyLogoImg(HeaderComponent headerComponent){
        LogoComponent logoComp = headerComponent.logoComp();
        System.out.println("Logo link: " + logoComp.logoLinkElem().getAttribute("href"));
        System.out.println("Logo img src: " + logoComp.logoImgElem().getAttribute("src"));

        Dimension logoSize = logoComp.logoImgElem().getSize();
        int logoWidth = logoSize.getWidth();
        int logoHeight = logoSize.getHeight();
        boolean isImgBroken = logoWidth < 300 || logoHeight < 40;
        Assert.assertTrue(logoComp.logoImgElem().isDisplayed(), "[ERR] Logo is invisible!");
        Assert.assertFalse(isImgBroken, "[ERR] Logo img is broken!");
    }
    private void verifyHeaderLinkWapper(HeaderComponent headerComponent){
        int expectedLinkSize = 4;
        int actualLinkSize = headerComponent.allLinksNumber();
        List<String> expectedHyperlinkWrappers = Arrays.asList("http://demowebshop.tricentis.com/register", "http://demowebshop.tricentis.com/login",
                "http://demowebshop.tricentis.com/cart", "http://demowebshop.tricentis.com/wishlist");
        List<String> expectedLinkWrapperText = Arrays.asList("Register", "Log in", "Shopping cart\n(0)", "Wishlist\n(0)");

        List<String> actualLinkWrapperTexts = new ArrayList<>();
        List<String> actualHyperLinkWrappers = new ArrayList<>();
        for (WebElement link : headerComponent.allLinkHrefsWrapper()){
            actualHyperLinkWrappers.add(link.getAttribute("href"));
            actualLinkWrapperTexts.add(link.getText().trim());

        }
        if (actualHyperLinkWrappers.isEmpty() || actualLinkWrapperTexts.isEmpty()){
            Assert.fail("[ERR] Texts or HyperLinks WRAPPER  is empty");
        }
        //One link of logo img
        Assert.assertTrue(expectedLinkSize == (actualLinkSize - 1) ,
                "[ERR] Size of link wrapper " + actualLinkSize+  "is incorrect!");
        for (String actualLinkText : actualLinkWrapperTexts){
            System.out.println("Linktext " + actualLinkText);
            Assert.assertTrue(expectedLinkWrapperText.contains(actualLinkText), "[ERR] Link text WRAPPER " + actualLinkText + " is incorrect");
        }

        for (String actualLinkHref : actualHyperLinkWrappers) {
            System.out.println("Hyperlink " + actualLinkHref);
            Assert.assertTrue(expectedHyperlinkWrappers.contains(actualLinkHref), "[ERR] Hyperlink WRAPPER " + actualLinkHref + " is incorrect");
        }
    }
    private void verifySearchBox(HeaderComponent headerComponent){

    }
}
