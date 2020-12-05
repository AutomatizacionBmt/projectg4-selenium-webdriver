package com.company.redmine;

import com.company.base.BaseTest;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import org.junit.Test;

public class RedmineLoginTest extends BaseTest {


    @Test
    public void testLoginRedmine(){

        RedmineLoginPage redmineLoginPage  = redmineLandingPage.clickLinkLogin();
        redmineLoginPage.login("user", "bitnami1");


        System.out.println("Interrupcion....");


    }

}
