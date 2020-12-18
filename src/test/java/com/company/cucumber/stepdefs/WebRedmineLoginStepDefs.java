package com.company.cucumber.stepdefs;

import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLoginPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

public class WebRedmineLoginStepDefs {

    BaseStepDefs baseStepDefs;
    RedmineLoginPage redmineLoginPage;
    RedmineHomePage redmineHomePage;

    public WebRedmineLoginStepDefs(BaseStepDefs baseStepDefs){
        this.baseStepDefs = baseStepDefs;
    }

    @Dado("Yo voy a la pagina de login de Redmine")
    public void yoVoyALaPaginaDeLoginDeRedmine() {

        System.out.println("Yo voy a la pagina de login de Redmine");
        redmineLoginPage = baseStepDefs.currentPage.clickLinkLogin();
        baseStepDefs.currentPage = redmineLoginPage;

    }

    @Cuando("Yo inicio sesion con mis credenciales usuario {string} y password {string}")
    public void yoInicioSesionConMisCredencialesUsuarioYPassword(String user, String password) {

        System.out.println("Yo inicio sesion con mis credenciales usuario {string} y password {string}");
        redmineHomePage = redmineLoginPage.login(user, password);
        baseStepDefs.currentPage = redmineHomePage;

    }

    @Entonces("Yo deberia visualizar en la pagina de inicio mi usuario {string}")
    public void yoDeberiaVisualizarEnLaPaginaDeInicioMiUsuario(String user) {

        System.out.println("Yo deberia visualizar en la pagina de inicio mi usuario {string}");
        String expectedUser = "Logged in as "+user;
        String actualUser = redmineHomePage.getUserLogged();

        Assert.assertEquals("Inicio de sesión incorrecto: ", expectedUser, actualUser);
    }

    @Cuando("Yo inicio sesion con mis credenciales usuario {string} y password {string} presionando enter")
    public void yoInicioSesionConMisCredencialesUsuarioYPasswordPresionandoEnter(String userName, String password) {

        System.out.println("Yo inicio sesion con mis credenciales usuario {string} y password {string} presionando enter");
        redmineHomePage = redmineLoginPage.loginWithEnter(userName, password);
        baseStepDefs.currentPage = redmineHomePage;
    }
}
