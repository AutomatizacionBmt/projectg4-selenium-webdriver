package com.company.redmine;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRedmineTest {

    @Test
    public void myFirstTest(){

        //Para Windows
        //System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver.exe");

        //Para Linux o MAC OS
        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://2d1240e7414b.ngrok.io");

        //Para fines educativos
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("stop...");
        //Maximizar la ventana
        //driver.manage().window().maximize();

        System.out.println("stop...");
        //Pantalla completa
        //driver.manage().window().fullscreen();

        System.out.println("stop...");
        //Especificando una dimensión , por ejemplo (iPhoneX)
        driver.manage().window().setSize(new Dimension(375, 812));


        ///html/body/div[2]/div[2]/div[1]/div[2]/div/form/input[3]
        ////*[@id="q"]


        System.out.println("stop...");
        driver.quit();
    }

    @Test
    public void loginRedmineTest(){

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8081/");

        WebElement linkLogin = driver.findElement(By.linkText("Iniciar sesión"));
        //WebElement linkLogin = driver.findElement(By.partialLinkText("sesión"));

        System.out.println("Interrupción...");

        linkLogin.click();

        System.out.println("Interrupción...");

        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys("user");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("bitnami1");

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='login-submit']"));
        btnLogin.click();

        System.out.println("Interrupción...");

        WebElement divLogin = driver.findElement(By.id("loggedas"));

        String userExpected = "user";
        String userActual = divLogin.getText();

        Assert.assertEquals("Error Login", "Logged in as "+userExpected, userActual);

        driver.quit();

    }


}
