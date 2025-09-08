# Mi primera aplicación Web JDBC

Vamos a migrar la aplicación JDBC de consola ( https://github.com/profeMelola/Programacion_2022-23/tree/main/PROYECTO_INTEGRADO_WEB/JDBC/1_ConsolaJDBC ) a un entorno web.

![image](https://user-images.githubusercontent.com/91023374/235315191-8c9bdb4b-7446-4e20-be7d-557546fdb3a8.png)

## Pasos

- Montar un proyecto web (Dynamic Web Project) en Eclipse.

- Convertirlo a Maven y añadir la dependencia al driver MySQL.

- La misma lógica que implementamos en el método main de la aplicación JDBC de consola lo migramos al Servlet.

- Creamos una página html sencilla para llamar al servlet.

## Objetivos

- Trabajar con un proyecto integrado donde se aplican conocimientos de dos módulos: 
**Lenguajes de Marcas:** para la parte cliente.
**Programación:** para la parte servidor.
- Además, lógicamente se trabaja con contenidos básicos adquiridos en el módulo de Bases de Datos.
- Comprobar la diferencia de entorno y las implicaciones que tiene trabajar en el entorno WEB (nuevo tipo de proyecto, su configuración, uso del servidor Tomcat integrado para desplegar las aplicaciones...)
- Adquirir conocimientos básicos sobre el entorno en el que van trabajar en 2º y en el que van a desarrollar su vida profesional.


## Parte cliente: HTML + CSS

![image](https://user-images.githubusercontent.com/91023374/235315488-fa3deb3d-276c-45a0-b3cf-2c1a012ee7b4.png)

## Parte servidor: Java

Hemos pasado de tener la lógica en el método **main**:

![image](https://user-images.githubusercontent.com/91023374/235315663-7c234d62-0f65-40dc-a7e1-a5f759e388bd.png)

___

A tener la lógica en el método correspondiente del servlet *doGet*:

![image](https://user-images.githubusercontent.com/91023374/235315592-d162ad1d-6082-4c06-a122-e48ae27392f3.png)


### Resultado 

![image](https://user-images.githubusercontent.com/91023374/235315505-c1fed8ac-d3cc-4ad8-98f4-d07f545e8464.png)


