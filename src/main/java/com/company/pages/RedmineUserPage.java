package com.company.pages;

import com.company.models.RedmineUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RedmineUserPage extends RedmineLandingPage {

    private By linkUsers = By.xpath("//a[@href='/users']");
    private By linkNewUsers = By.xpath("//*[@id='content']/div[1]/a");

    private By txtUserName = By.xpath("//*[@id=\"user_login\"]");
    private By txtFirstName = By.xpath("//*[@id=\"user_firstname\"]");
    private By txtLastName = By.xpath("//*[@id=\"user_lastname\"]");
    private By txtEmail = By.xpath("//*[@id=\"user_mail\"]");
    private By cbxLanguage = By.xpath("//*[@id=\"user_language\"]");
    private By chbxAdministrator = By.xpath("//*[@id=\"user_admin\"]");
    private By txtPassword = By.xpath("//*[@id=\"user_password\"]");
    private By txtPasswordConfirmation = By.xpath("//*[@id=\"user_password_confirmation\"]");

    private By btnCreateUser = By.xpath("//*[@id=\"new_user\"]/p/input[1]");
    private By lblUIMessage = By.xpath("//*[@id=\"flash_notice\"]");


    public RedmineUserPage(WebDriver driver) {
        super(driver);
    }

    public void createNewUser(RedmineUser user) {

        driver.findElement(txtUserName).sendKeys(user.getUserName());
        driver.findElement(txtFirstName).sendKeys(user.getFirstName());
        driver.findElement(txtLastName).sendKeys(user.getLastName());
        driver.findElement(txtEmail).sendKeys(user.getEmail());

        WebElement webElementselectLanguage = driver.findElement(cbxLanguage);
        ;
        Select selectLanguage = new Select(webElementselectLanguage);
        selectLanguage.selectByVisibleText(user.getLanguage());

        driver.findElement(chbxAdministrator).click();

        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(txtPasswordConfirmation).sendKeys(user.getPassword());
        driver.findElement(btnCreateUser).click();
    }

    public String getUIMessageCreateUser() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(lblUIMessage));
        return driver.findElement(lblUIMessage).getText();
    }

    public void clickOnLinkUsers() {
        driver.findElement(linkUsers).click();
    }

    public void clickOnLinkNewUsers() {
        driver.findElement(linkNewUsers).click();
    }

    public Boolean userIsOnList(String userName) {

        List<WebElement> userList = driver.findElement(By.tagName("table"))
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        for (WebElement userRow : userList) {
            if (userName.equals(userRow.findElements(By.tagName("td")).get(0).getText()))
                return true;
        }
        return false;

        //Implementación con Java 8 , by Alex
        /*      return fila.stream()
                .map(webElement -> webElement.findElements(By.tagName("td")))
                .collect(Collectors.toList())
                .stream()
                .anyMatch(webElements -> webElements.get(0).getText().equalsIgnoreCase(userName));*/
    }
}
