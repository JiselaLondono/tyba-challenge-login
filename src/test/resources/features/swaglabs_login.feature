#language: es
#Autor: Jisela Londoño Herrera

Característica: Login en sistema Swag Labs
  Como usuario del portal Swag Labs
  Quiero iniciar sesión dentro del sistema
  Para interactuar con las demás funciones del portal

  Esquema del escenario: Login exitoso en el sistema Swag Labs
    Dado que Jisela quiere iniciar sesión en el sistema
    Cuando ingresa un usuario <usuario> y contraseña <contrasena> correctos
    Entonces ella debería ingresar al portal de manera exitosa, en donde visualice el inventario de productos

    Ejemplos:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

