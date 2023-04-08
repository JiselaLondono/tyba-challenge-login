# tyba-challenge-login

El proyecto tyba-challenge-login contiene en la actualidad la automatización del login sobre el sistema web **Swag Labs** y la automatización del login de uno del los endpoints del playground **API Restful Booker** . A nivel general, para ambos sistemas, se tienen establecidos escenarios automaizados de login exitoso y login no exitoso contando en este último con varios casos alternos.

### **Detalles de la implementación y estrategia**

Para el desarrollo de este proyecto, se utilizaron las siguientes herramientas:
+ IDE: Intellij IDEA Community Edition 2022.3
+ Automatizador de tareas y manejo de dependencias: Gradle v7.6.1
+ Lenguaje de programación: Java / JDK v11.0.17
+ Sistema de Control de Versiones: Git
+ Navegador: Google Chrome v112
+ Frameworks: SerenityBDD 
+ Herramienta BDD: Cucumber (Cucumber for Java plugin en el IDE)
+ Lenguaje de definición de escenarios: Gherkin

Como parte de la estrategia de automatización de este proyecto, el patrón de diseño utilizado es **Screenplay**. Este patrón se presenta como una mejora al patrón Page Object Model, ya que al usar POM, un automatizador construye código basado en la interfaz de usuario y no en las interacciones que tiene el usuario con el sistema. Screenplay es un gran ejemplo de la aplicación de los principios SOLID, sobre todo en el principio de Responsabilidad única y Abierto-Cerrado.

Implementar Screenplay permite escribir código en un lenguaje mucho más cercano al lenguaje natural y esto es evidenciado en los reportes. Obliga a pensar en términos de roles, objetivos y acciones para lograr esos objetivos. Para tener mayor información de este patrón, visita la página https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals

En el apartado anterior se hizo mención del uso del framework de SerenityBDD. Dicho framework ayuda a escribir pruebas de aceptación automatizadas de mayor calidad y más rápidas, y se caracteriza por escribir test flexibles y fáciles de mantener, generar informes ilustrativos sobre las pruebas, entre otros. Para tener un mayor conocimiento de este framework, visita la página https://serenity-bdd.github.io/docs/guide/user_guide_intro 

### **Estructura del proyecto**
La estructura completa del proyecto es la siguiente:

* ```src/main/java```
``` 
+ com.tyba.challenge.exceptions
    Clases que capturan excepciones personalizadas cuando falla la automatización.

+ com.tyba.challenge.questions
    Clases con las que se hacen preguntas al sistema para luego ser verificadas en los stepdefinitions (asserts).  

+ com.tyba.challenge.tasks
    Clases que representan las tareas que realiza el actor a nivel de proceso de negocio    

+ com.tyba.challenge.userinterfaces
    Clases donde se mapean los elementos de la interfaz de usuario y a su vez para la interaccion con cada uno de estos elementos.

+ com.tyba.challenge.utils
    Clases que contienen la utilería o funcionalidades en común, enums, constantes manejadas en el proyecto, etc.
``` 
* ```src/test/java```
``` 
+ com.tyba.challenge.runners
    Runners para ejecutar la automatizacion con los escenarios indicados en el feature.
    
+ com.tyba.challenge.stepdefinitions
    Clases que son el punto de entrada del feature para la ejecución de la automatización.
``` 
* ```src/test/resources```
```

+ features
    Representación de los escenarios de prueba en lenguaje Gherkin a través de archivos cucumber.

Dentro de resources tenemos el archivo de configuración de Serenity, el cual tenemos definido el path en donde se descargaría el binario del driver de manera automática, de acuerdo al entorno en el cual se ejecutaría la prueba (SO y versión del navegador. La autodescarga se realiza en el momento de ejecución de las pruebas). Por otro lado, como en este caso se definió que las pruebas se ejecutarían en el navegador Chrome, se tiene configurados sus capabilities con los argumentos o propiedades requeridas para la ejecución de la prueba en dicho navegador.     
```

### **Requisitos para la ejecución**

Tener instalado y configurado el funcionamiento de lo siguiente:

+ Java JDK 1.8 o superior (variables de entorno configuradas)
+ IDE de desarrollo, preferiblemente Intellij IDEA Community Edition v2020.3.1 o superior.
  + En el IDE tener instalado el plugin Cucumber for Java y Gherkin
+ Gradle v7.6.1 o superior (variables de entorno configuradas)
+ Git
+ Navegador Google Chrome v112

### **Comandos para la ejecución de los escenarios**

Para la ejecución de los escenarios de prueba desde la Terminal:

+ Se puede usar el comando: `gradlew test`, el cual ejecuta todos los tests.

+ O tenemos la siguiente instrucción, la cual permite ejecutar todos los test, brindando información en la consola sobre la ejecución: `gradle clean test --tests com.tyba.challenge.runners* --info aggregate`


### **Reportes de resultados de las pruebas**

+ Dado que SerenityBDD se caracteriza por generar reportes detallados que indican el estado funcional de la aplicación o servicios, y que sirven también como documentación viva, una vez que se ejecutan los tests, se genera un archivo html llamado index.html, el cual contiene el detalle de la ejecución. Este reporte se presenta en la ruta del proyecto `./target/site/serenity/index.html`. Hay que tener en cuenta que esta ruta se genera cuando se ha presentado la primera ejecución de los test.

+ Por otro lado tenemos el Serenity Summary Report. Este es un informe de resumen html autónomo de una sola página, que contiene una descripción general de los resultados de la prueba. Para generarlo, se debe ejecutar el comando `gradle reports` y éste se genera en la ruta del proyecto `./target/site/serenity/serenity-summary.html`
