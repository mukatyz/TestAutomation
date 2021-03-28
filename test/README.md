# Introduccion 

La automatización se compone de 2 tipos de prueba:
* Automatizacion End-to-End para la experiencia web con "Automation practice". La experiencia consiste en una tienda virtual
* Automatización del servicio reqres. Este servicio permite la gestion ge usuarios a través de sus diferentes funcionalidades (CRUD)

# Pre-requisitos

* Java Version 1.8 o superior y JDK (variables de entorno configuradas) 
* IntelliJ IDEA V2020.1.2 
* Cucumber
* Gestor de proyectos Gradle 
* Chromedriver version ChromeDriver 89.0.4389.23
* GOOGLE CHROME version 89.0.4389.90

# Instalacion 

* Para clonar este repositorio localmente, se debe ejecutar el siguiente comando: 
git clone https://github.com/mukatyz/TestAutomation.git
* Importar el proyecto desde Eclipse o IntelliJ IDE bajo la estructura de un proyecto Gradle existente
* Importar descargar todas las dependencias.

	
# Navegadores Web 
La automatizacion actualmente se ejecuta en los siguientes navegadores:
Google Chrome Version 89.0.4389.23 


# Construido con Herramienta 
La automatizacion fue desarrollada con:

* BDD - Estrategia de desarrollo
* Screenplay 
* Gradle - Manejador de dependencias
* Selenium Web Driver - Herramienta para automatizar acciones en navegadores web
* Cucumber - Framework para automatizar pruebas BDD
* Serenity BDD - Biblioteca de codigo abierto para la generacion de reportes
* Gherkin - Lenguaje Business Readable DSL (Lenguaje especifico de dominio legible por el negocio)
   
# Versionado 
Se uso GIT para el control de versiones.


# Repositorio 

https://github.com/mukatyz/TestAutomation

## Para ejecutar los runners por consola:
	clean test --tests *Cart* aggregate --info
   clean test --tests *CheckoutScreen* aggregate --info
   clean test --tests *VerifyService* aggregate --info
	 
	 
# Autores

* Yulieth Katerine Muñoz Zapata
