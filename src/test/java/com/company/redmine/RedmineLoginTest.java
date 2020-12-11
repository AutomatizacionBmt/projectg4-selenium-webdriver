package com.company.redmine;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class RedmineLoginTest extends BaseTest {


    @Test
    public void testLoginRedmine(){

        RedmineLoginPage redmineLoginPage  = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        String expectedUser = "Logged in as user";
        String actualUser = redmineHomePage.getUserLogged();

        Assert.assertEquals("Login Fallido", expectedUser, actualUser);

        System.out.println("Interrupcion....");


    }

}
