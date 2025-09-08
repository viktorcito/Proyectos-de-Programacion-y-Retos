# RETO: Implementa un sudoku con Java

![image](https://user-images.githubusercontent.com/91023374/146168358-c31a9f0f-9413-455d-8a80-641add94fe99.png)

## TRABAJO GRUPAL

Vamos a montar equipos. El requisito es que cada equipo esté formado como mínimo por tres miembros.

De forma consesuada, cada equipo eligirá:
- un portavoz: que hará las preguntas al profesor si fuera necesario.
- un jefe de proyecto: que organizará de forma equitativa el trabajo entre los tres miembros.

El portavoz y el jefe de proyecto no pueden ser la misma persona.

**Problema que debemos resolver**

Implementar un sudoku clásico 9x9 en java:

- Se debe mostrar al usuario el sudoku.
- El usuario debe ir diciendo la casilla y el número que quiere rellenar.
- Debemos indicar al usuario si ha acertado con la solución.

![image](https://user-images.githubusercontent.com/91023374/146061101-1154dd26-808a-47f3-8784-82c14ffa9ee1.png)

## REQUISITOS

Puedes utilizar todos los recursos Java vistos en clase el primer trimestre, única y exclusivamente (Clases, objetos, arrays... nada de colecciones dinámicas!!!!! )

Podéis buscar por internet toda la información que consideréis necesaria, pero todos los miembros del equipo deben saber lo que se va a implementar.

El trabajo debe estar repartido. Todos debéis participar.

Tenéis total libertad para diseñar el Sudoku y sus reglas de juego (desde un Sudoku sencillo a uno más complejo):
- si se va resolviendo según el usuario va introduciendo números.
- si se resuelve una vez completado
- si le damos más de una oportunidad
- el nivel de dificultad 
- etc...

**Antes de empezar, tengamos claro qué es un Sudoku**

https://aprendiendomatematicas.com/sudokus-descargables-para-ninos/


## PISTAS

El profesor irá publicando pistas semanalmente para ayudar a aquellos bloqueados en diferentes fases del programa... 

![image](https://user-images.githubusercontent.com/91023374/146194724-942f3b84-3bfc-423e-921c-34a55faa7c0b.png)

### PISTA 1: array de 4 dimensiones

**Si vemos el tablero del Sudoku pensamos en un array bidimensional de 9x9:**

![image](https://user-images.githubusercontent.com/91023374/211816486-4421f912-9dac-4a24-b172-4c9597db69a3.png)

**Pero si pensamos en los sectores, cada sector es un array bidimensional de 3 x 3.**

Por tanto, podemos ver el tablero completo como un array de 4 dimensiones 3 x 3 x 3 x 3, ya que tendríamos un array bidimensional de 3 filas y 3 columnas donde cada celda tendría a su vez dos dimensiones más, las tres filas y tres columnas del sector.

**EJEMPLO DE CÓDIGO TRABAJANDO CON ARRAY DE 4 DIMENSIONES**

```
        int DIM0 = 3;
        int DIM1 = 3;
        int DIM2 = 3;
        int DIM3 = 3;
        
        int tablero[][][][];
        
        tablero = new int[DIM0][DIM1][DIM2][DIM3];
        
        int valor = 10;
        for(int dim0=0; dim0 < DIM0; dim0++){
            for(int dim1=0; dim1 < DIM1; dim1++){
                for(int dim2=0; dim2 < DIM2; dim2++){
                    for(int dim3=0; dim3 < DIM3; dim3++){
                        tablero[dim0][dim1][dim2][dim3] = valor;
                        valor++;
                    }
                }
            }
        }

```
Este código daría como resultado el siguiente tablero 3 x 3 x 3

![image](https://user-images.githubusercontent.com/91023374/211818999-8353e673-82f6-4bae-93e5-a5b5f84f15ab.png)

O por ejemplo este código sería totalmente válido:

```
int sector[][] = {{1, 5, 9}, {2, 7, 4}, {3, 8, 6}};
tablero[0][0] = sector;
```

### PISTA 2: algoritmo para generar aleatoriamente un tablero de sudoku

![image](https://user-images.githubusercontent.com/91023374/146333140-faab5f14-2c63-4759-b14d-9587a779077f.png)


### PISTA 3: creación del soduko con sectores bidimensionales y el tablero 

**No hace falta trabajar con la clase Sector. Piensa en el sector como un array de dos dimensiones 3x3**

![image](https://user-images.githubusercontent.com/91023374/214313172-ee41025f-3098-46b4-94bb-e733ba46f5e7.png)

**tablero = 4 dimensiones 9x9**

**getSector() = devuelve un array de dos dimensiones 3x3**

![image](https://user-images.githubusercontent.com/91023374/214314994-6de01c9e-49d0-49e1-875d-f3fbcd8d9b65.png)

**Ejemplo de método que convierte un array de 4 dimensiones en otro de 2 dimensiones**

![image](https://user-images.githubusercontent.com/91023374/214316844-d90e0502-feae-4e6e-8975-81f48643a22b.png)

### PISTA 4: algoritmo para borrar celdas (nivel medio)

![image](https://user-images.githubusercontent.com/91023374/146376460-78485609-121c-435c-a6e3-01b7f5b5da75.png)

- Borrar las diagonales del tablero completo. Esto afecta a 5 sectores, borrando 3 celdas en cada sector.
- En los cuatro sectores restantes borrar solo 1 celda.
- Todo hace un total de 5 * 3 + 4 * 1 = 19 celdas borradas


## ENTREGA VOLUNTARIA

El programa podrá entregarse en el aula virtual (los fuentes y el jar versión jdk 11).

**Fecha límite: sábado 11 de febrero a las 23:59**

No es una actividad evaluable, no cuenta para el 15% de la nota pero sí es un "reto grupal" el sacar adelante el SUDOKU.

Jugaremos en clase con los Sudokus entregados y el profesor podrá preguntar a cualquier miembro del equipo por el código. 

**El objetivo es aprender unos de otros!!!!**

La entrega está en la sección principal del curso en el aula virtual:

![image](https://user-images.githubusercontent.com/91023374/211314285-757b94e0-8143-424c-adc7-fbb84c9cbc48.png)

https://aulavirtual3.educa.madrid.org/ies.alonsodeavellan.alcala/mod/assign/view.php?id=61985


