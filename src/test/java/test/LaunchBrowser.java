package test;

import org.apache.commons.exec.OS;

public class LaunchBrowser {
    public static void main(String[] args) {
        //Location of Webdriver
        String chromeDriverLocation = null;
        String currentProjectLocation = System.getProperty("user.dir");
        chromeDriverLocation = OS.isFamilyMac() ? currentProjectLocation.concat("/src/test/resource/drivers/chromedriver") :currentProjectLocation.concat("");


        //Start browser session
        //Open a webpage
    }
}
