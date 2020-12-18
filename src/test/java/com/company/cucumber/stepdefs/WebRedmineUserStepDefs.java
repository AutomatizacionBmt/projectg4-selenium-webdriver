package com.company.cucumber.stepdefs;

import com.company.models.RedmineUser;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineUserPage;
import com.company.utils.AppUtil;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

import java.util.Map;

public class WebRedmineUserStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineHomePage redmineHomePage;
    RedmineUserPage redmineUserPage;
    RedmineUser redmineUser;

    public WebRedmineUserStepDefs(BaseStepDefs baseStepDefs) {
        this.baseStepDefs = baseStepDefs;
    }

    @Cuando("Yo registro un usuario")
    public void yoRegistroUnUsuario(Map<String, String> userData) {

        redmineHomePage = (RedmineHomePage) baseStepDefs.currentPage;
        redmineUserPage = (RedmineUserPage) redmineHomePage.clickOnMenu("ADMINISTRATION");

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickOnLinkNewUsers();

        String number = AppUtil.generateRandomNumber();

        redmineUser = new RedmineUser();
        redmineUser.setUserName(userData.get("userName") + number);
        redmineUser.setFirstName(userData.get("firstName") + number);
        redmineUser.setLastName(userData.get("lastName") + number);
        redmineUser.setEmail(redmineUser.getUserName() + userData.get("email"));
        redmineUser.setLanguage(userData.get("language"));
        redmineUser.setAdministrator(Boolean.parseBoolean(userData.get("administrator")));
        redmineUser.setPassword(userData.get("password"));

        redmineUserPage.createNewUser(redmineUser);
    }


    @Entonces("El usuario se registro correctamente")
    public void elUsuarioSeRegistroCorrectamente() {

        Assert.assertEquals("No se registró correctamente el usuario",
                "User " + redmineUser.getUserName() + " created.",
                redmineUserPage.getUIMessageCreateUser());

        System.out.println("Se registró correctamente el usuario: " + redmineUser.getUserName());
    }


    @Y("El usuario deberia visualizarce en la lista de usuarios")
    public void elUsuarioDeberiaVisualizarceEnLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        Assert.assertTrue(redmineUserPage.userIsOnList(redmineUser.getUserName()));
    }

    @Cuando("Yo elimino el usuario de la lista de usuarios")
    public void yoEliminoElUsuarioDeLaListaDeUsuarios() {

        redmineUserPage.clickOnLinkUsers();
        redmineUserPage.clickLinkDeleteUser(redmineUser.getUserName());
        redmineUserPage.removeUser();
    }


    @Entonces("El usuario no deberia visualizarce en la lista de usuarios")
    public void elUsuarioNoDeberiaVisualizarceEnLaListaDeUsuarios() {

        Boolean userExist = redmineUserPage.userIsOnList(redmineUser.getUserName());
        System.out.println("¿Existe en la lista el usuario? -> " + userExist);
        Assert.assertFalse(userExist);
    }
}
