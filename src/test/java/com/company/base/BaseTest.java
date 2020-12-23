package com.company.base;

import com.company.pages.RedmineLandingPage;
import com.company.utils.Urls;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp(){

        String browserName = System.getenv("browserName");
        browserName = (browserName == null) ? "chrome" : browserName.toLowerCase();

        switch (browserName){
            case "firefox":
                setFirefoxDriverProperty();
                break;
            case "safari":
                setSafariDriverProperty();
                break;
            case "chrome":
                setChromeDriverProperty();
                break;
            default:
                throw new IllegalStateException("The browserName " +browserName+ " option is not present");
        }

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(Urls.REDMINE_URL_LOCAL);
        driver.manage().window().maximize();

        redmineLandingPage = new RedmineLandingPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    private static void setChromeDriverProperty(){

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");


        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl, capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void setFirefoxDriverProperty(){

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");


        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl, capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void setSafariDriverProperty(){

        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        capabilities.setBrowserName("safari");


        try {
            URL hubUrl = new URL(Urls.SELENIUM_GRID);
            driver = new RemoteWebDriver(hubUrl, capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void recordFailure(String scenarioName){

        String fileName = scenarioName + ".png";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot,
                    new File("resources/screenshots/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
