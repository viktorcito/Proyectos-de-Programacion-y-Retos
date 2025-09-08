/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw;

import es.daw.utilidades.Util;
import java.util.Scanner;

/**
 *
 * @author luismi
 */
public class Sudoku {

    public static void main(String[] args) {

        int eleccion;
        Scanner sc = new Scanner(System.in);

        do {
                eleccion = 0;
                Util.pintaMenu();
                if (sc.hasNextInt()) {
                    eleccion = sc.nextInt(); 
                }
                sc.nextLine();
                if (eleccion < 1 || eleccion > 5) {
                    System.out.println("Introduce una respuesta correcta");
                }

            if (eleccion > 0 && eleccion < 5) {
                int[][][][] sudoku = Util.creaArray();
                int[][][][] sudokuPuzle;
                if (eleccion > 0 && eleccion < 4) sudokuPuzle = Util.sudokupuzle(sudoku, 81 - eleccion * 10 - (eleccion - 1) * 10);
                else {
                    System.out.println("Introduce el número de incognitas (minimo 1, maximo 81)");
                    int incognitas = 10;
                    if (sc.hasNextInt()) {
                        incognitas = sc.nextInt();
                    } 
                    sudokuPuzle = Util.sudokupuzle(sudoku, 81 - Math.min(Math.max(incognitas, 1), 81));
                }

                do {

                    Util.pintaSudoku(sudokuPuzle);
                    sudokuPuzle = Util.ModificaSudoku(sudokuPuzle);

                } while (!Util.compruebaResultados(sudokuPuzle) && sudokuPuzle[0][0][0][0] != -1);
                
                if (sudokuPuzle[0][0][0][0] != -1) {
                    
                    System.out.println(Util.AZUL + "\n\\\\      \\\\       ||         //      //" + Util.RESET);
                    Util.pintaSudoku(sudokuPuzle);
                    System.out.println(Util.AZUL + "//      //       ||         \\\\      \\\\" + Util.RESET);
                    System.out.println(Util.VERDE + "\t¡¡¡ Has ganado !!!!!\n\n" + Util.RESET);
                    
                }else{
                    System.out.println("Te has rendido  :( \n la respuesta era:\n");
                    Util.pintaSudoku(sudoku);
                }
                
            }

        } while (eleccion != 5);

    }

}
