package com.company.redmine;

import com.company.base.BaseTest;
import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import com.company.pages.RedmineProjectsPage;
import com.company.utils.AppUtil;
import org.junit.Assert;
import org.junit.Test;

public class RedmineProjectTest extends BaseTest {

    @Test
    public void testCreateProject() {

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();
        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        Assert.assertEquals("Login Fallido", "Logged in as user",
                redmineHomePage.getUserLogged());

        RedmineProjectsPage redmineProjectsPage = redmineHomePage.clickOnMenu("PROJECTS");
        redmineProjectsPage.clickNewProject();

        String randomNumber = AppUtil.generateRandomNumber();

        RedmineProject project = new RedmineProject();
        project.setName("RedmineProject" + randomNumber);
        project.setDescription("Esta es una descripcion " + randomNumber);
        project.setHomePage("RedmineProject" + randomNumber);
        project.setPublic(true);

        redmineProjectsPage.createProject(project);

        Assert.assertEquals("Ocurrió un error", "Successful creation.",
                redmineProjectsPage.getUIMessage());

        System.out.println("Interrupción....");
    }
}
