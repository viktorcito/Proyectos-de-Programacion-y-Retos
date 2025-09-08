 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.po.sudoku;

import static es.daw.po.sudoku.util.Utilidades.*;
import java.util.Scanner;

/**
 *
 * @author Cons, Ivan, Victor, Daniel
 */
public class SudokuApp {

    public static int[][] tablero = new int[9][9];
    public static String[][] tableroJugador = new String[9][9];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 4;
        do {

            mostrarMenuPrincipal();

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();

                switch (opcion) {
                    
                    case 1:
                        ajustarDificultad();
                        rellenarTablero();
                        ocultarTablero();

                        mostrarMenuJuego();
                        break;
                    case 2:
                        if (tablero[0][0] != 0) {
                            mostrarMenuJuego();
                        } else {
                            System.out.println("No hay una partida guardada. Volviendo al menú principal...");
                        }
                        break;
                    case 3:
                        mostrarInstrucciones();
                        break;
                    case 4:
                        System.out.println("saliendo del SUDOKU SUPER POP!\n");
                        break;
                    default:
                        System.out.println("\nEscogistes la opcion CORRECTA!!! Has descubierto el final secreto! este es el fin del juego GOD ENDING...\n");
                }

            } else {
                System.out.println("¿No vas a introducir un número? Huir es de sabios ¡¡corre!!");
            }

        } while (opcion != 4);
        
    }

}
