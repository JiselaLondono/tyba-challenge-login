#language: es
#Autor: Jisela Londoño Herrera

Característica: Login en API Restful-Booker
  Como consumidor del API Restful-Booker
  Quiero realizar la autenticación
  Para obtener un token y poder consumir los demás endpoints del API

  Escenario: Login exitoso en endpoint Auth
    Cuando Jisela ingresa un usuario y contraseña correctos en el endpoint de autenticación
      | username | admin       |
      | password | password123 |
    Entonces ella debería ver que el código de respuesta del servicio es 200
    Y ella debería ver un token de autenticación en la respuesta del servicio

