# AMPLIACIÓN DEL EJERCICIO DE PROGRAMADORES EN EL QUE TRABAJAMOS LA CLASE ENUM

Partimos del ejercicio https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Enumerados

![image](https://user-images.githubusercontent.com/91023374/219032719-05533a03-de51-445a-950f-5840667ba012.png)

**Vamos a hacer una copia del proyecto y ampliarlo en base a las siguientes especificaciones.**

## Tratar adecuadamente la excepción IllegalArgumentException

Al dar de alta un programador en la consultora convertimos el nombre del lenguaje que conoce a un tipo enumerado:

```
Lenguajes.valueOf(sc.nextLine());
```

Si introducimos un lenguaje que no existe, esa instrucción produce una excepción que hace que el programa termine de forma inesperada.

Reproduce el error y gestiona de forma adecuada ese fallo para que el programa avise pero no termine su ejecución. 

Asigna un lenguaje por defecto. Añade a la lista de lenguajes uno que sea UNDEFINED, de esta manera podrá consultarse por aquellos programadores dados de alta con un lenguaje de programación no apto para la compañía.

Añade al menú una opción para poder consultar por dichos programadores.

## Crear una excepción checked propia

Cuando se da de alta un programador en la consultora hay que especificar la edad del mismo.

Si dicha edad está comprendida entre los 18 y 22 años (incluidos), por cuestiones de política de la empresa, dicho programador no entra en la compañía porque previamente debe realizar unos cursos.

Para controlar dicha "situación particular" debes crear una excepción propia:
- que guarde información del empleado (su nif, edad y lenguaje de programación) 
- cuyo mensaje sea "El programador con nif XXXX es menor de 23 años y debe realizar el curso formativo previo".

Estas situaciones o incidencias deben quedar registradas para poder ser consultadas a posteriori, para ello, añade al menú una opción para consultar dichas incidencias y que se muestren ordenadas por edad ascendente.
