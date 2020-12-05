package com.company.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesTest {

    @Test
    public void selectingCheckbox(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/projectg4-selenium-webdriver/webapp/checkboxes.html");

        //Para Windows por ejemplo
        //driver.get("file:///D:/Users/jhumbertoh/Proyectos/Publicos/projectg4-selenium-webdriver/webapp/checkboxes.html");

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));
        checkbox.click();
        checkbox.click();
        checkbox.click();

        //Assert.assertEquals("El checkbox no esta seleccionado",true,checkbox.isSelected());
        Assert.assertTrue("El checkbox no esta seleccionado", checkbox.isSelected());
        System.out.println("La prueba pasó...");

        driver.quit();
    }


}
