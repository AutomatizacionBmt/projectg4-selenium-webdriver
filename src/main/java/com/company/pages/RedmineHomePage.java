package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage extends RedmineLandingPage{

    private By menuMyPage = By.xpath("//a[@href='/my/page']");
    private By menuMyProjects = By.xpath("//a[@href='/projects']");
    private By menuAdmin = By.xpath("//a[@href='/admin']");
    private By menuHelp = By.xpath("//a[@href='https://www.redmine.org/guide']");

    private By lblUserLogged = By.id("loggedas");

    public RedmineHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUserLogged(){
        return driver.findElement(lblUserLogged).getText();
    }

    public RedmineLandingPage clickOnMenu(String option){

        switch (option.toLowerCase()){
            case "my page":
                driver.findElement(menuMyPage).click();
                return new RedmineLandingPage(driver);
            case "projects":
                driver.findElement(menuMyProjects).click();
                return new RedmineProjectsPage(driver);
            case "administration":
                driver.findElement(menuAdmin).click();
                return new RedmineUserPage(driver);
            case "help":
                driver.findElement(menuHelp).click();
                return new RedmineLandingPage(driver);
            default:
                throw new IllegalStateException("The option: " +option.toLowerCase() + "is not present");
        }

    }
}
