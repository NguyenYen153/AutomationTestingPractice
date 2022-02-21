package test_flows.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import url.Urls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow implements Urls {
    private WebDriver driver;
    public  FooterTestFlow(WebDriver driver){
        this.driver = driver;
    }
    public void verifyFooterComponent(Class<? extends  BasePage> pageClass){
        BasePage page = null;
        try{
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        FooterComponent footerComponent = page.footerComponent();
        verifyInformationColumn(footerComponent);
        verifyCustomerColumn(footerComponent);
        verifyMyAccountColumn(footerComponent);
        //HANDLE DIFFERENT FLOW ON PAGES
        if( page instanceof HomePage){
            System.out.println("TEST  Home Page | verifyFollowUsColumn");
            verifyFollowUsColumn(footerComponent);
        }

    }
    private void verifyInformationColumn(FooterComponent footerComponent) {
        InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();
        String actualColumTitle = informationColumnComp.headerElem().getText().trim();
        String expectedTitle = "INFORMATION";
        Assert.assertEquals(actualColumTitle, expectedTitle,"[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice",
                "Conditions of Use", "About us", "Contact us");
        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns", "/privacy-policy",
                "/conditions-of-use", "/about-us", "/contactus");
        //VERIFICATION
        verifyColumnData(informationColumnComp, expectedLinkTexts, expectedLinkHrefs);
    }
    private void verifyCustomerColumn(FooterComponent footerComponent) {
        CustomerServiceColumnComponent customerServiceColumnComponent = footerComponent.customerServiceColumnComp();
        String actualColumnTitle = customerServiceColumnComponent.headerElem().getText().trim();
        String expectedTitle = "CUSTOMER SERVICE";
        Assert.assertEquals(actualColumnTitle, expectedTitle,"[ERR] Column Title is incorrect!");


        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog",
                "Recently viewed products", "Compare products list", "New products");
        List<String> expectedLinkHrefs = Arrays.asList("/search",
                "/news", "/blog", "/recentlyviewedproducts", "/compareproducts", "/newproducts");

        //VERIFICATION
        verifyColumnData(customerServiceColumnComponent, expectedLinkTexts, expectedLinkHrefs);

    }

    private void verifyMyAccountColumn(FooterComponent footerComponent) {
        AccountColumnComponent myAccountColumnComp = footerComponent.accountColumnComp();
        String actualColumTitle = myAccountColumnComp.headerElem().getText().trim();
        String expectedTitle = "MY ACCOUNT";
        Assert.assertEquals(actualColumTitle, expectedTitle,"[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList("My account", "Orders", "Addresses",
                "Shopping cart", "Wishlist");
        List<String> expectedLinkHrefs = Arrays.asList("/customer/info",
                "/customer/orders", "/customer/addresses", "/cart", "/wishlist");

        //VERIFICATION
        verifyColumnData(myAccountColumnComp, expectedLinkTexts, expectedLinkHrefs);

    }
    private void verifyFollowUsColumn(FooterComponent footerComponent) {
        FollowUsColumnComponent followUsColumnComp = footerComponent.followUsColumnComponent();
        String actualColumTitle = followUsColumnComp.headerElem().getText().trim();
        String expectedTitle = "FOLLOW US";
        Assert.assertEquals(actualColumTitle, expectedTitle,"[ERR] Column Title is incorrect!");

        List<String> expectedLinkTexts = Arrays.asList("Facebook", "Twitter", "RSS",
                "YouTube", "Google+");
        List<String> expectedLinkHrefs = Arrays.asList("http://www.facebook.com/nopCommerce", "https://twitter.com/nopCommerce",
                "http://demowebshop.tricentis.com/news/rss/1",
                "http://www.youtube.com/user/nopCommerce", "https://plus.google.com/+nopcommerce");
        //VERIFICATION
        verifyColumnData(followUsColumnComp, expectedLinkTexts, expectedLinkHrefs);

    }
    private  void verifyColumnData (FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedLinkHrefs){
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();
        for (WebElement link : footerColumnComp.linkElems()){
            actualLinkTexts.add(link.getText().trim());
            actualLinkHrefs.add(link.getAttribute("href"));

        }
        if (actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty()){
            Assert.fail("[ERR] Texts or HyperLinks is empty");
        }
        //SIZE is equal, each element inside is EQUAL
        Assert.assertTrue(actualLinkTexts.size() == expectedLinkTexts.size(),
                "[ERR] Size of linktext in footer column is incorrect");
        for (String actualLinkText : actualLinkTexts){
            //System.out.println("Linktext " + actualLinkText);
            Assert.assertTrue(expectedLinkTexts.contains(actualLinkText), "[ERR] Link text " + actualLinkText + " is incorrect");
        }

        for (String actualLinkHref : actualLinkHrefs) {
            //System.out.println("Hyperlink " + actualLinkHref);
            if (actualLinkHref.contains(BASE_URL_2))
                Assert.assertTrue(expectedLinkHrefs.contains(actualLinkHref.substring(BASE_URL_2.length())),
                        "[ERR] Hyperlink " + actualLinkHref + " is incorrect value!");
            else
                Assert.assertTrue(expectedLinkHrefs.contains(actualLinkHref),
                        "[ERR] Hyperlink " + actualLinkHref + " is incorrect value!");
        }
    }
}
