package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableTest {

    @Test
    public void gettingTableData(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg4-selenium-webdriver/webapp/table.html");

        //List<WebElement> tables = driver.findElements(By.tagName("table"));
        //WebElement table3 = tables.get(2);

        WebElement outerTable = driver.findElement(By.tagName("table"));
        WebElement innerTable = outerTable.findElement(By.tagName("table"));

        /*List<WebElement> listWebElementsTd = innerTable.findElements(By.tagName("td"));
        WebElement td1 = listWebElementsTd.get(1);*/

        WebElement td1 = innerTable.findElements(By.tagName("td")).get(1);

        System.out.println("El texto obtenido es: "+ td1.getText());
        Assert.assertEquals("Table 2 Row 2", td1.getText());

        driver.quit();
    }
}
