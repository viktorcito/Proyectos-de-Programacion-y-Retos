# Tienda de ordenadores
## Ejercicio para practicar la herencia y ordenación de ArrayList

En una **tienda** se venden 2 tipos de ordenadores: **portátiles y de sobremesa.**

Ambos tipos de ordenadores se caracterizan por su **código y por su precio.**

**Los ordenadores portátiles tienen además:**

- un atributo peso

**Los de sobremesa tienen además:**

- la descripción del tipo de torre.


Por otro lado, cada uno tiene un **slogan**:

- "Ideal para sus viajes" en el caso de todos los portátiles.
- "Es el que más pesa, pero el que menos cuesta" para el caso de todos los ordenadores de sobremesa.

Dicho slogan no se puedo modificar.

Y una **duración de la garantía:**
- 1 año para los portátiles.
- 6 meses para los ordenadores de sobremesa.

Se podrá modificar la duración de la garantía de cada equipo no pudiendo pasar de 5 años los portátiles y 2 años los equipos de sobremesa.

Ten en cuenta además que el **método natural de ordenación** de los ordenadores será a través del código **(implementar interface Comparable)**.

### Se pide:

- Definir e implementar las clases.
- Crear un programa en Java que cree un par de objetos de tipo sobremesa y portátiles que muestre las características de ambos. 
- Añadir dichos objetos a una colección dinámica (ArrayList) y **devolverlos ordenados.**
- Pintar los ordenadores **ordenados por el método natural de ordenación (código)**
- Pintar los ordenadores **ordenador por precio**
- **Recorre la lista de ordenadores y borra aquellos que tengan en su código la cadena HP. Muestra de nuevo la lista.**
