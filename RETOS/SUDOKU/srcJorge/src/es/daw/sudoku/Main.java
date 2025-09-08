package es.daw.sudoku;

import es.daw.sudoku.util.Utilidades;
import java.util.Arrays;

public class Main {

    public static int[][][][] sudoku = Utilidades.crearSudoku();
    public static int[][][][] sudokuNuevo = Utilidades.vaciarSudoku();

    public static void main(String[] args) {

        // sudoku[i - ejeVert][j - fila][k - ejeHor][l - columna]
        System.out.println("- Sudoku original:\n");
        Utilidades.pintarSudoku();

        System.out.println("--------------------\n"
                + "\n- Sudoku a resolver:\n");
        Utilidades.pintarSudokuNuevo();
        
        Boolean salir = false;
        int movimientos = 0;

        do {
            Utilidades.preguntarCeldas();
            movimientos++;
            if (Arrays.deepEquals(sudokuNuevo, sudoku)){
                salir = true;
            }else{
                Utilidades.comprobarSolucion();
            }
        } while (salir == false);
        
        System.out.println("¡ENHORABUENA, HAS COMPLETADO EL SUDOKU EN "+movimientos+" MOVIMIENTOS!");
    }
}
