package com.company.webapp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectItemTest {

    @Test
    public void usingSelectTest(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg4-selenium-webdriver/webapp/selectitems.html");

        WebElement selectElement = driver.findElement(By.id("select1"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Maybe");
        //select.selectByIndex(0);
        //select.selectByValue("maybe");

        driver.quit();

    }

}
