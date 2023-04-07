#language: es
#Autor: Jisela Londoño Herrera

Característica: Login en sistema Swag Labs
  Como usuario del portal Swag Labs
  Quiero iniciar sesión dentro del sistema
  Para interactuar con las demás funciones del portal


  Esquema del escenario: Login exitoso en el sistema Swag Labs
    Dado que Jisela quiere iniciar sesión en Swag Labs
    Cuando ella ingresa un usuario y contraseña correctos en el sistema
      | usuario    | <usuario>    |
      | contrasena | <contrasena> |
    Entonces ella debería ingresar al portal de manera exitosa, en donde visualice el inventario de productos

    Ejemplos:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Esquema del escenario: Login no exitoso en el sistema Swag Labs
    Dado que Jisela quiere iniciar sesión en Swag Labs
    Cuando ella ingresa un usuario o contraseña incorrectos en el sistema
      | usuario    | <usuario>    |
      | contrasena | <contrasena> |
    Entonces ella debería ver el siguiente mensaje en pantalla '<mensaje>'

    Ejemplos:
      | usuario        | contrasena    | mensaje                                                     |
      | standard_usere | secret_sauce  | Username and password do not match any user in this service |
      | problem_user   | secret_saucee | Username and password do not match any user in this service |
      | standard_user  |               | Password is required                                        |
      |                | secret_sauce  | Username is required                                        |
      |                |               | Username is required                                        |