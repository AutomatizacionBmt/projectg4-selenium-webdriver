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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        driver = new ChromeDriver();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.getenv("navegador");



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
