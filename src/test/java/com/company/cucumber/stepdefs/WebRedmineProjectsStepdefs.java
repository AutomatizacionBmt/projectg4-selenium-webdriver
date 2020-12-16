package com.company.cucumber.stepdefs;

import com.company.models.RedmineProject;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineProjectsPage;
import com.company.utils.AppUtil;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineProjectsStepdefs {

    BaseStepDefs baseStepDefs;
    RedmineProjectsPage redmineProjectsPage;

    public WebRedmineProjectsStepdefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }

    @Cuando("Yo registro un proyecto")
    public void yoRegistroUnProyecto(Map<String, String> projectData) {

        RedmineHomePage redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineProjectsPage = redmineHomePage.clickOnMenu("PROJECTS");

        redmineProjectsPage.clickNewProject();

        String randomNumber = AppUtil.generateRandomNumber();

        RedmineProject project = new RedmineProject();
        project.setName(projectData.get("name") + randomNumber);
        project.setDescription(projectData.get("description") + randomNumber);
        project.setHomePage(projectData.get("homepage") + randomNumber);
        project.setPublic(Boolean.parseBoolean(projectData.get("public")));

        redmineProjectsPage.createProject(project);

    }

    @Entonces("El proyecto fue registrado satisfactoriamente y muestra el mensaje {string}")
    public void elProyectoFueRegistradoSatisfactoriamenteYMuestraElMensaje(String message) {

        Assert.assertEquals("El proyecto no se registró correctamente: ",
                message, redmineProjectsPage.getUIMessage());
    }
}
