package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineLandingPage {

    protected WebDriver driver;

    private By linkLogin = By.cssSelector("a.login");

    public RedmineLandingPage(WebDriver driver){
        this.driver = driver;
    }

    public RedmineLoginPage clickLinkLogin(){
        //WebElement login = driver.findElement(By.cssSelector("a.login"));
        //login.click();

        driver.findElement(linkLogin).click();
        return new RedmineLoginPage(driver);
    }

}
