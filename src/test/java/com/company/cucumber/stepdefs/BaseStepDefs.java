package com.company.cucumber.stepdefs;

import com.company.base.BaseTest;
import com.company.pages.RedmineLandingPage;

public class BaseStepDefs {

    protected RedmineLandingPage currentPage;

    public BaseStepDefs(){
        currentPage = new RedmineLandingPage(BaseTest.getDriver());
    }

}
