# Inyección de Dependencia y su utilidad

**¿Qué es una Dependencia?**

Cuando una clase ClassA usa cualquier método de otra claseClassB, podemos decir que ClassB es una dependencia deClassA.

El Principio de inyección de dependencia no es más que poder pasar (inyectar) las dependencias cuando sea necesario en lugar de inicializar las dependencias dentro de la clase receptora.

Desacoplar la construcción de sus clases de la construcción de las dependencias de sus clases.


## Paso 1

Nuestro servicio de impresión depende de otros servicios y quedando las responsabilidades más claras. 

![image](https://user-images.githubusercontent.com/91023374/226204896-f7391f5e-2ea7-4b36-91a2-34beb1b17777.png)


## Paso 2

![image](https://user-images.githubusercontent.com/91023374/226204775-78613d11-5f3e-4302-9a74-b104da1bb582.png)

No es el propio servicio el responsable de definir sus dependencias sino que lo es el programa principal.  
 
Esto abre las puertas a la extensibilidad.
 


## Paso 3

Nosotros podemos cambiar el tipo de dependencia que inyectamos, simplemente extendiendo una de nuestras clases o implementando una interfaz. De esa forma cambiaría el comportamiento.

![image](https://user-images.githubusercontent.com/91023374/226204873-033c8135-2f7c-4592-9e47-f69985139072.png)


Referencia: https://www.arquitecturajava.com/el-patron-de-inyeccion-de-dependencia/
