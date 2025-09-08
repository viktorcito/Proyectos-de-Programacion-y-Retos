/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.main;

import static es.daw.util.util.*;
import java.util.Scanner;

/**
 *
 * @author CARLOS MARTIN SALVATIERRA
 */
public class main {

    public static void main(String[] args){
        //VARIABLES.
        Scanner teclado = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        int fila = 0;
        int columna = 0;
        int valor = 0;

        REGLAS();

        //CARGAMOS EL JUEGO.
        sudoku = cargar_juego(nivel);

        while (true) {

            //IMPRIMIMOS EL VECTOR.
            imprime_sudoku(sudoku);

            //PEDIMOS LOS DATOS.
            System.out.println("Inserte las coordenadas (fila/columna): ");

            //FILA.
            System.out.print("[fila]: ");
            fila = Integer.parseInt(teclado.nextLine());

            //COLUMNA.
            System.out.print("[columna]: ");
            columna = Integer.parseInt(teclado.nextLine());

            //VALOR.
            System.out.print("[valor]: ");
            valor = Integer.parseInt(teclado.nextLine());

            //COMPROBAMOS LA FILA ESTA EN RANGO.
            if (!comprobar_indice(fila)) {
                mensaje("El valor de la fila no es correcto..");
            } //COMPROBAMOS LA COLUMNA ESTA EN RANGO.
            else if (!comprobar_indice(columna)) {
                mensaje("El valor de la columna no es correcto.");
            } //COMPROBAMOS QUE EL VALOR ESTA EN RANGO.
            else if (!comprobar_valor(valor)) {
                mensaje("El valor introducido no es valido..");
            } //COMPROBAMOS QUE USE CASILLAS DISPONIBLES.
            else if (es_origen((fila - 1), (columna - 1), cargar_juego(nivel))) {
                mensaje("Ese valor es predeterminado del juego...");
            } //COMPRUEBA QUE NO SE REPITA EL VALOR EN LA FILA.
            else if (existe_fila(valor, fila, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la fila..");
            } //COMPRUEBA QUE NO SE REPITA EL VALOR EN LA COLUMNA..
            else if (existe_columna(valor, columna, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } //COMPRUEBA QUE EL VALOR NO ESTÉ EN LA CAJA.
            else if (existe_caja(valor, fila, columna, sudoku)) {
                mensaje("[X] El valor ya existe en la caja..");
            } //INTRODUCIMOS EL VALOR A LA MATRIZ.
            else {
                sudoku[(fila - 1)][(columna - 1)] = valor;
                mensaje("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }

            //COMPRUEBA SI SE TERMINÓ EL JUEGO.
            if (terminado(sudoku)) {
                mensaje("FELICIDADES!!!! HAS TERMINADO EL JUEGO!!");
                imprime_sudoku(sudoku);
                System.out.println("Presiona una tecla para continuar en el siguiente nivel..");
                teclado.nextLine();

                //AUMENTAMOS EL NIVEL DEL JUEGO.
                nivel++;
                sudoku = cargar_juego(nivel);
                mensaje("SUDOKU NIVEL " + nivel);
            }
        }

    }

}
