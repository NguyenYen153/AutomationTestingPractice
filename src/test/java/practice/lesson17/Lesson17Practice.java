package practice.lesson17;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

import javax.swing.plaf.ActionMapUIResource;
import java.util.ArrayList;
import java.util.List;

public class Lesson17Practice implements Urls {
    private static final By figureSel = By.cssSelector(".figure");
    private static final By figureImgSel = By.tagName("img");
    private static final By figureDescSel = By.tagName("h5");
    private static final By figureLinkSel = By.tagName("a");
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            //DROPDOWN
            driver.get(BASE_URL_2.concat("/desktops"));
            WebElement dropdownSortBy = driver.findElement(By.id("products-orderby"));
            Select select = new Select(dropdownSortBy);
            select.selectByIndex(1);
            select.selectByValue("http://demowebshop.tricentis.com/desktops?orderby=5");
            select.selectByVisibleText("Position");

            //MOUSE HOVER
            //
            List<WebElement> figureElems = driver.findElements(figureSel);
            List<FigureData> figureDataList = new ArrayList<>();

            Actions actions = new Actions(driver);
            if (figureElems.isEmpty()){
                throw new RuntimeException("[ERR] The is no figure on these page");
            }
            else {
                for (WebElement figureElem : figureElems){
                    //Mouse hover
                    actions.moveToElement(figureElem).perform();
                    //Get figure data
                    WebElement figureImgElem = figureElem.findElement(figureImgSel);
                    WebElement figureDescElem = figureElem.findElement(figureDescSel);
                    WebElement figureImgLinkElem = figureElem.findElement(figureLinkSel);

                    String figureImgScr = figureImgElem.getAttribute("scr");
                    String figureImgDesc = figureDescElem.getText();
                    String figureLink = figureImgLinkElem.getAttribute("href");
                    // Out to figureData list
                    FigureData figureData = new FigureData(figureImgScr, figureImgDesc, figureLink);
                    figureDataList.add(figureData);

                }
                for (FigureData figureData : figureDataList){
                    System.out.println(figureData);
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
    public static class FigureData{
        private String imgScr;
        private String imgDesc;
        private String imgLink;

        public FigureData(String imgScr, String imgDesc, String imgLink) {
            this.imgScr = imgScr;
            this.imgDesc = imgDesc;
            this.imgLink = imgLink;
        }

        public String getImgScr() {
            return imgScr;
        }

        public String getImgDesc() {
            return imgDesc;
        }

        public String getImgLink() {
            return imgLink;
        }

        @Override
        public String toString() {
            return "FigureData{" +
                    "imgScr='" + imgScr + '\'' +
                    ", imgDesc='" + imgDesc + '\'' +
                    ", imgLink='" + imgLink + '\'' +
                    '}';
        }
    }
}
