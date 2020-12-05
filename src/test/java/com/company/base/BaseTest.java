package com.company.base;

import com.company.pages.RedmineLandingPage;
import com.company.utils.Urls;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver driver;
    protected static RedmineLandingPage redmineLandingPage;

    @BeforeClass
    public static void setUpAndLaunchApp(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        driver = new ChromeDriver();

        driver.get(Urls.REDMINE_URL);
        driver.manage().window().maximize();

        redmineLandingPage = new RedmineLandingPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
