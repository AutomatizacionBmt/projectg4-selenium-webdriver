package com.company.cucumber;


import com.company.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@gui")
    public static void setUp(){
        BaseTest.setUpAndLaunchApp();
    }

    @After("@gui")
    public static void tearDown(){
        BaseTest.tearDown();
    }

}
