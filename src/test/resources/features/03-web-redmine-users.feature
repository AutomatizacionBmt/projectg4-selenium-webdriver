# language: es
Característica: Web UI - Redmine - Users
  Como un usuario admin,
  Yo deseo crear un nuevo usuario satisfactoriamente

  @gui @Working
  Escenario: Crear un nuevo usuario satisfactoriamente
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Entonces Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | userName      | user              |
      | firstName     | userFirstName     |
      | lastName      | userLastName      |
      | email         | @mail.com         |
      | language      | Spanish (Español) |
      | administrator | true              |
      | password      | 12345678          |
    Entonces El usuario se registro correctamente
    Y El usuario deberia visualizarce en la lista de usuarios

