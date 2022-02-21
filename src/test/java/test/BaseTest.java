package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    protected WebDriver driver;
    public void initDriver (){
        driver = DriverFactory.getChromeDriver();
    }
    @BeforeTest (alwaysRun = true)
    public void beforeTesst(){
        initDriver();
    }
    @AfterTest (alwaysRun = true)
    public void afterTest(){
        driver.quit();
    }
    @AfterMethod (alwaysRun = true)
    public void afterMethod(ITestResult result){
        // Only CAPTURE SCREENSHOT when test is failed
        if (result.getStatus() == ITestResult.FAILURE){
            //Name of screenshot: methodName_yyyy_đ_hh-mm-ss.png
            String methodName = result.getName();
            Calendar calendar = new GregorianCalendar();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; //Start from 0
            int day = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            String tekenDate = year + "-" + month + "-" + day + "-" + hr + "-" + min+ "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + tekenDate + ".png";
            //Take screen shot
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Attach into allure report
            try{
                //Save
                FileUtils.copyFile(screenshot, new File(fileLocation));
                Path filePath = Paths.get(fileLocation);
                //Attach to Allure
                try (InputStream is = Files.newInputStream(filePath)){
                    Allure.addAttachment(methodName, is);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }
    }
}
