# Precio del alquiler de vehículos

Se pretende desarrollar una aplicación que permita **calcular los precios de alquiler de una empresa de alquiler de vehículos.**

Cada vehículo se identifica unívocamente por medio de su matrícula. 

La empresa alquila distintos tipos de vehículos, tanto para transporte de personas como de carga. En la actualidad los vehículos alquilados por la empresa son:
- coches
- microbuses
- furgonetas de carga
- camiones

**El precio del alquiler de cualquier vehículo tiene una componente base que depende de los días de alquiler a razón de 50 €/día.**

## Coche

En el caso de un coche, al precio base se le suma la cantidad de 1.5€ por plaza y día. 

## Microbuses

El precio de alquiler de los microbuses añade una cantidad de 3€ por plaza al precio base, independientemente de los días de alquiler. 

## Vehículos de carga (furgonetas y camiones)

El precio de los vehículos de carga es el precio base más 20€ * PMA (PMA = peso máximo autorizado en toneladas)

Además, en el caso de los camiones, al precio se suma un fijo de 40 € independientemente de los días de alquiler. 


**La interacción del empleado con la aplicación deberá realizarse a través de la consola.**

**Decide el diseño de las clases con sus atributos y métodos correspondientes**

## JERARQUÍA DISEÑADA EN CLASE POR CONSENSO

![IMG-20230203-WA0000](https://user-images.githubusercontent.com/91023374/216658512-9ce5a4b3-a4ad-4674-b624-25e54ad0f7d5.jpg)


## CASOS DE USO

1. Añade vehículo  

2. Marca un vehículo como alquilado y  obtiene precio de alquiler

3. Muestra todos los vehículos 

4. Muestra todos los vehículos NO alquilados

5. Muestra todos los vehículos alquilados

0. SALIR 



**Opción 1:**

el empleado selecciona la opción "añade vehículo"

la aplicación pide los datos del vehículo

la aplicación añade el vehículo a la lista de vehículos de empresa (pondremos que como máximo puede tener 10)


**Opción 2:**

La aplicación pide la matrícula del vehículo y los días que va a durar el alquiler

la aplicación muestra el precio previsto y marca el vehículo como alquilado


**Opción 3:**

Muestra una lista con todos los detalles de los vehículos alquilados


**Opción 4:**

Muestra una lista con todos los detalles de los vehículos NO  alquilados


**Opción 5:**

La aplicación pide la matrícula del vehículo, muestra el precio del alquiler y marca el vehículo como no alquilado. 
