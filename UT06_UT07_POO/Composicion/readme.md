# Ejercicio 0: Ejemplo de ..

https://www.arquitecturajava.com/java-composicion-y-la-reutilizacion-del-codigo/

# Ejercicio 1: Juego de azar

## Enunciado
Un juego de azar tiene  3  bolas. 

El funcionamiento de las bolas es el siguiente: al lanzar cada bola puede devolver un valor entre 0 y nueve (aleatorio) y además en cada tirada  cada bola tiene un valor de la puntuación o premio que puede ser desde 0 a 100 puntos (aleatorio). 

Se  lanzan las  tres bolas, anotando el resultado de la suma de las puntuaciones cada una, y además se comprobará :

**Si sale dos veces la misma bola  (por ejemplo tirada = 4 4 0 )  multiplica el valor de premio  x 2.**

```
Ejemplo:

                 bola 1: número 4, puntuación 15.

                 bola2: número 4, puntuación 26,

                 bola3: número 0, puntuación 100.

                 Puntuación  (15+26+100) *2.
```
 
**Si sale tres veces la misma bola (por ejemplo tirada = 4 4 4)  anota el valor del premio x3.**

```
Ejemplo:

                 bola 1: número 4, puntuación 15.

                 bola2: número 4, puntuación 26,

                 bola3: número 4, puntuación 100.

                 Puntuación  (15+26+100) *3.
```
 

En una ronda se hacen 3 tiradas (cada una de tres bolas).

Calcula la puntuación de la ronda.


### Completar el ejercicio de forma que nos muestre por pantalla el resultado de la ronda de 3 tiradas

**Ejemplo de salida de ejecución del programa:**

![Captura de pantalla de 2023-01-24 18-41-09](https://user-images.githubusercontent.com/91023374/214367931-523b5fba-cf46-4c1b-8eca-77b75905c7d7.png)


## Captura del proyecto en NetBeans

![Captura de pantalla 2023-01-20 124124](https://user-images.githubusercontent.com/91023374/213687599-21a42752-35d3-4f9e-b60b-d5f628b66e54.jpg)

 
## Diseño UML

![image](https://user-images.githubusercontent.com/91023374/148837242-cc4a674a-f091-42b4-a1bd-cc0bcb5622d9.png)


# Ejercicio 2: Login y Pwd

## Enunciado

Debes desarrollar un programa para crear cuentas de usuario. 

Para ello implementa dos clases, una llamada User y otra llamada Password,  que cumplan los siguientes requisitos:

### Clase Password

Estará compuesta por:

- longitud: todas las password tendrán una longitud mínima de 6 caracteres.
- contraseña: cadena de texto.

Se podrán crear objetos Password de dos formas:

- Por defecto sin indicar la contraseña. En este caso el programa generará automáticamente  la contraseña.
- Indicando la contraseña. En este caso habrá que validar que dicha contraseña es fuerte. Si no es fuerte el usuario recibirá un aviso  y el programa terminará.

No podrá modificarse la contraseña una vez creado el objeto.

En base a lo descrito, la clase por tanto tendrá además dos métodos:

**esFuerte:** método para comprobar que la contraseña introducida es fuerte. Para que sea fuerte  la contraseña se deben cumplir las siguiente condiciones: 
- empezar con una vocal en mayúsculas
- acabar con uno de estos tres carácteres $  &  * 
- contener exactamente el texto  DAW en cualquier parte de la contraseña.
- como mínimo una longitud de 6

Cuando no se cumpla alguna condición se mostrará un mensaje por consola indicando al usuario las condiciones que no se cumplen en su contraseña. 

**generarPassword:**  método que genera una contraseña automáticamente y de forma aleatoria. Lógicamente la contraseña generada automáticamente cumplirá las condiciones para que sea fuerte. 


## Clase User

Estará compuesta por:

- login: cade de texto.
- pwd: objeto tipo Password.

Se podrán crear objetos Login especificando el login, siendo pwd opcional. En este caso, si no se especifica pw se creará una por defecto.

No podrá modificarse ni el login ni el pwd.

## Clase principal ejecutable

Debes programar el menú para que el usuario pueda introducir los datos con los que se crearán los correspondientes objetos Password y User. 

Al ejecutar el programa debe mostrarse dicho menú y una vez creada la cuenta debe cerrarse el programa.

Crea objetos en base a los diferentes casos de prueba:

- No se indica contraseña por tanto se crea una por defecto. 
- Se indica la contraseña y cumple con los requisitos de contraseña fuerte.
- Se indica la contraseña y no cumple con algunos o todos los requisitos de contraseña fuerte. Se avisa al usuario de las condiciones que no cumple su contraseña.


**EJEMPLOS DE SALIDA:**

**Ejemplo1:** Pedimos que se cree la contraseña de forma automática

![image](https://user-images.githubusercontent.com/91023374/212065446-9d00f524-d5bc-4a6e-af02-b8749a514469.png)

**Ejemplo2:** Introducimos una contraseña débil

![image](https://user-images.githubusercontent.com/91023374/212065366-1817cc59-58d1-4ec5-a73e-4a74c244e987.png)

**Ejemplo3:** Introducimos una contraseña débil

![image](https://user-images.githubusercontent.com/91023374/212065685-47e6a4a7-5adb-4f12-9273-f9b64d000f18.png)

**Ejemplo4:** Introducimos una contraseña fuerte

![image](https://user-images.githubusercontent.com/91023374/212066036-0048b492-4d64-4052-80c2-da127581a584.png)


