# language: es

Característica: Web UI Redmine Login
  Como usuario,
  Yo deseo iniciar sesión en la aplicación de Redmine

  @gui @Working
  Escenario: Iniciar sesión satisfactoriamente en Redmine
    Dado Yo voy a la pagina de login de Redmine
    Cuando Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Entonces Yo deberia visualizar en la pagina de inicio mi usuario "user"