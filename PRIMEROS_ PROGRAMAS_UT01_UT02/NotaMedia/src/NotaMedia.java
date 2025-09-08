/*
 * https://github.com/profeMelola/Programacion_2022-23/blob/main/Primeros%20Programas/NotaMedia/readme.md
ENUNCIADO DEL EJERCICIO:
 
Escribe un programa que pregunte el nombre al alumno.

Después le preguntará la nota (que puede tener decimales) de los 6 módulos que está cursando:

"Qué nota tienes en el módulo 1?"

"Qué nota tienes en el módulo 2?"

..................

"Qué nota tienes en el módulo 6?"

Al finalizar le devolverá un mensaje en el que le indicará la nota media del curso (redondeando al entero inferior).

"Hola xxxxxx tu nota media en el curso es: "
 */
package notamedia;

import java.util.Scanner;

/**
 *
 * @author melola
 */
public class NotaMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String nombre;
        
        float nota1, nota2, nota3, nota4, nota5, nota6, media;
        
        //int numNotas = 6;
        final int NUM_NOTAS = 6;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Cuál es tu nombre? ");
        nombre = sc.nextLine();
        
        System.out.println("Qué nota tienes en el módulo 1?");
        nota1 = sc.nextFloat();
        System.out.println("Qué nota tienes en el módulo 2?");
        nota2 = sc.nextFloat();
        System.out.println("Qué nota tienes en el módulo 3?");
        nota3 = sc.nextFloat();
        System.out.println("Qué nota tienes en el módulo 4?");
        nota4 = sc.nextFloat();
        System.out.println("Qué nota tienes en el módulo 5?");
        nota5 = sc.nextFloat();
        System.out.println("Qué nota tienes en el módulo 6?");
        nota6 = sc.nextFloat();
        
        //media = (nota1 + nota2 + nota3 + nota4 + nota4 + nota6) / 6;
        media = (nota1 + nota2 + nota3 + nota4 + nota4 + nota6) / NUM_NOTAS;
        
        System.out.println("Hola "+nombre+" ! tu nota media del curso es "+media);
        
        
        int notaFinal = (int)media;
        
        //System.out.println("Hola "+nombre+" ! tu nota media del curso es "+(int)media);
        System.out.println("Hola "+nombre+" ! tu nota media del curso es "+notaFinal);
        
        /*System.out.println("Hola "+nombre+" ! tu nota media del curso es "+Math.round(media));
        System.out.println("Hola "+nombre+" ! tu nota media del curso es "+Math.ceil(media));
        System.out.println("Hola "+nombre+" ! tu nota media del curso es "+Math.floor(media));*/
        
        
        
        
        
    }
    
}

