# EJERCICIOS PARA PRACTICAR CON FUNCIONES

Empezaremos por el ejercicio 3 que es más fácil. 

Después haremos el ejercicio 4.

Luego haremos el ejercicio 1.

En el ejercicio 2 reutilizaremos la función de esPrimo para calcular el número de divisores primos.

He añadido el ejercicio 5 para rematar la práctica de funciones.

## EJERCICIO 1: esPrimo
Diseñar una función con el siguiente prototipo:
boolean esPrimo(int n)

**Nota:**

![image](https://user-images.githubusercontent.com/91023374/195995669-0eb76d22-2a94-4d30-9db8-abf51833be4d.png)

Los números primos son los números enteros que solamente son divisibles por el 1 y por ellos mismos. Algunos de los números primos son: 2, 3, 5, 7, 11, 13,….

El número 1 no es primo porque solo tiene un divisor. Ejemplos de números primos: 2, 3, 5, 7, 11, 13, 17, 19, 23, ...

**Ejemplo de salida por consola:**

![image](https://user-images.githubusercontent.com/91023374/195577716-c55f784f-3c37-414f-94b0-577b263d0651.png)


## EJERCICIO 2: divisoresPrimos 
Escribir una función que se le pase un número entero y devuelva el número de divisores primos que tiene.


**Ejemplo de salida por consola:**

![image](https://user-images.githubusercontent.com/91023374/195577014-79e3ebd8-1c23-4b51-ad67-c5f723a9b79a.png)



## EJERCICIO 3: calculaSegundos
Escribe una función a la que se pase como parámetros de entrada una cantidad de días, horas y minutos.

La función claculará y devolverá el número de segundos totales.

![image](https://user-images.githubusercontent.com/91023374/195579683-8149e26f-0eb6-4934-8031-5ee1496c8495.png)


## EJERCICIO 4: calcularCuotas
Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó 10 €, el segundo 12.5 €, el tercero 15.625 €, el cuarto 19.53125 €... y así sucesivamente. Como puedes observar la cuota cada mes se incrementó un 25%.

Realizar un programa para determinar cuánto debe pagar mensualmente y el total de lo que pagará después de los 20 meses. 

Este programa puede servir para calcular otras compras y con diferentes plazos, por tanto pide esta información al usuario.

Implementa una función que:
- reciba el importe de la cuota del primer mes y el número de meses.
- muestre por consola los pagos de cada mes
- devuelva el total del importe a pagar.

**Ejemplo de salida por consola**

![image](https://user-images.githubusercontent.com/91023374/196460190-dda0ca93-bab1-47f1-beac-597701eec6bd.png)


## EJERCICIO 5: vinicultores

La asociación de vinicultores tiene como política fijar un precio inicial al kilo de uva, y dependiendo de la clasificación tipos (A y B), y además en tamaños (1 y 2) se modifica el precio. 

Cuando se realiza la venta del producto, ésta es de un sólo tipo y tamaño, se requiere determinar cuanto recibirá un productor por la uva que entrega en un embarque considerando lo siguiente:

- **Si es de tipo A:** se le suman  20 céntimos al precio inicial por kilo  cuando es de tamaño 1 y 30 céntimos si es de tamaño 2.
- **Si es de tipo B:** se rebajan 50 céntimos cuando es de tamaño 1, y 30 céntimos cuando es de tamaño 2.  

Para el desarrollo del ejercicio es necesario crear un método que calcule el precio. 
