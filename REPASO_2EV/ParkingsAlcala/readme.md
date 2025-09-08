# PARKINGS DE ALCALÁ

Se pretende implementar un control de parkings públicos y privados de Alcalá.

**Deberías poder completar el ejercicio en un máximo de 2h 45m**

## Coches

Cada **coche** estará caracterizado por a marca, el modelo, la matrícula y si esElectrico (booleano).

Los parámetros definidos en el momento de crear el coche no podrán ser modificados.

## Parkings

Las características comunes a todos los parkings son:

- un identificador del parking
- su nombre
- dirección
- capacidad
- cantidadGanada
- colección con los coches aparcados.
- seguro: de tipo Seguro con la siguiente información: número de póliza, nombre de la aseguradora, fecha fin de seguro.

Todos los parking deben ser capaces de mostrar su **porcentaje de ocupación**, respecto al total de plazas del propio parking y respecto la ocupación total de los parking de Alcalá (número de total de plazas ocupadas/ número total de plazas disponibles).

El **identificador de parking** será un valor numérico que se obtendrá automáticamente. 

Ej: el primer parking tendrá id =1, el segundo id = 2…


Para **dar de alta un parking** se necesita únicamente el nombre, dirección y la capacidad (que es el número de coches que pueden aparcar dentro).  


Cualquiera de estos parámetros podrá modificarse una vez creado el parking.


La **tarifa** del parking es 5 € por coche, salvo los coches eléctricos que aparcan gratis.  

Por lo tanto la **cantidad ganada por el parking** es el número de coches aparcados multiplicado por  la tarifa.


La colección de coches y el número de coches se actualizarán a través de los siguientes métodos, que simularán el comportamiento del parking:

- **[void/boolean] addCoche(Coche):**

Si el parking no está completo podrá aparcar y se incrementará el número de coches aparcados. En el caso de que el parking esté completo, el método lanzará una excepción del tipo Exception con el nombre del parking y el número de plazas ocupadas.

Se debe guardar la excepción en una colección, de forma que se puedan consultar en cualquier momento.  

- **[void/boolean] deleteCoche(int):** Se eliminará un coche por la posición que ocupa en el parking (es la posición en la colección de datos).

- **int getNumero_Coches():** Obtener el número de coches aparcado.

- **String mostrarCoches():** Mostrar todos los coches aparcados.

- **String mostrarCochesElectricos():** Mostrar los coches aparcados eléctricos.

- **int mostrarPorcentajeOcupacionLocal();**

- **int motrarPorcentajeOcupacionTotal();**

- La información del parking, devuelta por el método toString() será:

```
El parking con id XX y XX, situado en XX cuenta con una capacidad de XX Coches.

Ahora están aparcados XX Coches. El porcentaje de ocupación es del XX %.

En Alcalá hay XX plazas disponibles. El porcentaje de ocupación es del : XX %

Estos son los coches:

XX (coches)

Solo son eléctricos:

XX(coches eléctricos)


El seguro del parking está contradado con la aseguradora XXXX. El número de póliza es YYYYYY y quedan ZZZZ días para que se cumpla el seguro.

```

## INTERFACE PROFITABLE

Un parking tendrá un comportamiento común a las empresas públicas del ayuntamiento. Para ello debes crear la **interface Profitable** (rentable) con el siguiente método abstracto **double obtenerGananciasTotales ()** 


### Ganancias del Parking Público

Un **ParkingPublico** recibe  financiación por tener una serie de numTrabajadoresDiscapacitados.  

Para calcular las **obtenerGananciasTotales**, se aplica la siguiente fórmula:

cantidadGanada +  (numTrabajadoresDiscapacitados * 250)

### Ganancias del Parking Privado

Un **ParkingPrivado** tiene un número de numSocios que se repartirán la cantidadGanada. 

El método **obtenerGananciasTotales** devuelve la lo ganado por cada socio.


 
# Para probar el funcionamiento del código

Usa el DAO de Parking que se proporciona para crear diferentes parkings públicos y privados.

Usa el DAO de coches que se proporciona para aparcar coches en los diferentes parkings.
