
![image](https://user-images.githubusercontent.com/91023374/228243369-95ed5aea-634c-49fa-8a27-7bf9d783a5ac.png)

![image](https://user-images.githubusercontent.com/91023374/228243591-4902beff-3c56-4b3f-b6dd-e3ccb3981e07.png)


## Gson (JSON) en Java, con ejemplos

En clase hemos hecho el programa **DemoGSON.**

Para ello hemos creado un proyecto Maven en Netbeans.

### Pasos para montar DemoGSON con Maven

#### Crear el proyecto Maven
![image](https://user-images.githubusercontent.com/91023374/228503078-28b520ee-e07d-48a9-8da5-e0590fec9b5a.png)

![image](https://user-images.githubusercontent.com/91023374/228503200-c20d2e90-810d-42c7-bc0f-e96201e49a9e.png)

### Añadir en **pom.xml** la dependencia de la librería de GSON.

La hemos obtenido del Repositorio Maven. Yo os he dicho la versión a utilizar y hemos compiado el xml que nos proporciona:

![image](https://user-images.githubusercontent.com/91023374/228503920-76983036-5c6f-414f-8000-d73fb2eb8e45.png)


```
    <dependencies>
        <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.9.0</version>
        </dependency>
    </dependencies>
```

#### Actualizar el proyecto Maven en Netbeans

Menú derecho sobre el proyecto y recargar el POM (opción Reload POM).

En el caso de que el proyecto aparezca con un icono indicando que hay un problema, en el menú derecho del proyecto aparecerá una opción para RESOLVER PROBLEMAS.


### Otros ejemplos:
https://jarroba.com/gson-json-java-ejemplos/

## Java JSON con Jackson

https://www.arquitecturajava.com/java-json-con-jackson/
