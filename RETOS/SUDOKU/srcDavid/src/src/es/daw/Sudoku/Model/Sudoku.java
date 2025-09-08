/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.es.daw.Sudoku.Model;

import javax.swing.JOptionPane;
import src.es.daw.Sudoku.SudokuApp;

/**
 *
 * @author sebas
 */
public class Sudoku {

    public static String menuSudoku() {
        String[] mensaje = {"Jugar (Fácil)", "Jugar (Difícil)", "salir"};
        String opcion = (String) JOptionPane.showInputDialog(null,
                "Bienvenido a Sudoku v1.0\n" + SudokuApp.juego, "Sudoku", 1, null, mensaje, null);
        return opcion;
    }

    public static void ComenzarJuego() {
        String[] opciones = {
            "Seleccionar columna",
            "Salir"
        };
        String opcion = (String) JOptionPane.showInputDialog(null,
                "             Sudoku \n" + SudokuApp.juego + "\n", "Sudoku", 1, null, opciones, null);

        pedirColFila(opcion);
    }

    private static void pedirColFila( String opcion) {
        Integer columna=0, fila=0;
        if (null != opcion) {
            switch (opcion) {
                case "Salir":
                    System.exit(0);
                case "Seleccionar columna":
                    //Seleccionar columna del 1-9
                    columna = pedirColumna() - 1;
                    fila = pedirFila() - 1;
                    break;
            }
            modificarNumero(columna,fila);
        }
    }

    private static void modificarNumero(int columna, int fila) {

        int tablero = 0;
        //tablero
        if (0 <= columna && columna <= 2) {
            tablero = 0;
        } else if (3 <= columna && columna <= 5) {
            tablero = 1;
            columna -= 3;
        } else if (6 <= columna && columna <= 8) {
            tablero = 2;
            columna -= 6;
        }
        //fila_sud (en jerarquía justo debajo de tablero
        //seccion[i][j]
        int i = 0;
        //fila -> seccion, por debajo de fila, el valor de fila irá a secc[fila]
        if (0 <= fila && fila <= 2) {
            i = 0;
        } else if (3 <= fila && fila <= 5) {
            i = 1;
            fila -= 3;
        } else if (6 <= fila && fila <= 8) {
            i = 2;
            fila -= 6;
        }

//        datos[0] = tablero; //tablero[tablero
//        datos[1] = columna; // -> fila[columna]
//        datos[2] = i;  // -> seccion[i][fila]
//        datos[3] = fila;

          sacarNumero(tablero, fila, i, fila);
    }
    private static void sacarNumero(int tablero, int fila, int i, int j){
        SudokuApp.juego.mostrarNum(tablero,fila,i,j);
        
        JOptionPane.showConfirmDialog(null, SudokuApp.juego);
        ComenzarJuego();
    }

    private static int pedirColumna() {
        String columna;
        Integer[] columnas = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        columna = String.valueOf(JOptionPane.showInputDialog(null,
                "Seleccione columna \n" + SudokuApp.juego + "\n", "Sudoku", 1, null, columnas, columnas[0]));
        return Integer.parseInt(columna);
    }

    private static int pedirFila() {
        String fila;
        Integer[] filas = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        fila = String.valueOf(JOptionPane.showInputDialog(null,
                "Seleccione fila \n" + SudokuApp.juego + "\n", "Sudoku", 1, null, filas, filas[0]));
        return Integer.parseInt(fila);
    }
}
