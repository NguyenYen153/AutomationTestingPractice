package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {//Open target page
            driver.get("https://the-internet.herokuapp.com/");
            //FInd username/password elemant  by using username/password selector
            //WebElement powerByLinkTextElem = driver.findElement(By.linkText("Elemental Selenium"));
            WebElement powerByLinkTextElem = driver.findElement(By.partialLinkText("Elemental"));
            String linkText = powerByLinkTextElem.getText();
            String linkHref = powerByLinkTextElem.getAttribute("href");
            Hyperlink hyperlink = new Hyperlink(linkText, linkHref);
            Thread.sleep(3000);
        }
        finally {
            //Quit driver session
            driver.quit();
        }
    }
    public static class  Hyperlink{
    private String link;
    private String text;

        public Hyperlink(String link, String text) {
            this.link = link;
            this.text = text;
        }

        public String getLink() {
            return link;
        }

        public String getText() {
            return text;
        }
    }
}
