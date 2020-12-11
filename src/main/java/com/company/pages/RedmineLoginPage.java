package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineLoginPage extends RedmineLandingPage {


    private By txtUserName = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//*[@id='login-submit']");

    public RedmineLoginPage(WebDriver driver) {
        super(driver);
    }

    public RedmineHomePage login(String userName, String password) {

        driver.findElement(txtUserName).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();

        return new RedmineHomePage(driver);

    }
}
