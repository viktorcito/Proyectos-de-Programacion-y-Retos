package es.daw.poo.sudoku;

import es.daw.poo.sudoku.model.Sudoku;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SudokuApp {

    public static Scanner sc = new Scanner(System.in);
    
    public static String[][] sudokuRelleno = Sudoku.tableroRelleno;
    public static String[][] sudokuHueco = Sudoku.tableroHueco;
    public static String[][] sudokuJuego = Sudoku.tableroJuego;

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int numero = 0;
        boolean fin = false;
        
        JOptionPane.showMessageDialog(null,"**** BIENVENIDO AL JUEGO SUDOKU **** \n-COMO JUGAR: "
                + "\n-Introduce las coordenadas de la casilla a rellenar. \n-Las casillas con parentesis son editables. "
                + "\n-El juego no acabara hasta que el sudoku sea completado. \n-Al introducir 666 como numero, el juego terminara." );
        System.out.println("VAMOS A COMENZAR...");
        System.out.println(" ");

        pintarTableroJuego();

        do {
            if (!Arrays.deepEquals(sudokuRelleno, sudokuJuego)) {
           
                System.out.println("Introduce la coordenada y:");
                x = sc.nextInt() - 1;
                

                System.out.println("Introduce la coordenada x:");
                y = sc.nextInt() - 1;
                if((x < 0) || (x > 9) || (y < 0) || (y > 9)){
                    System.out.println("Introduzca una coordenada valida!!");
                    pintarTableroJuego();
                }
                else if (sudokuHueco[x][y] == "( )") {
                    System.out.println("Introduce un numero:");
                    numero = sc.nextInt();
                    
                    if (numero == 666){
                        System.out.println("NO HAS PODIDO COMPLETAR EL SUDOKU");
                        System.out.println("ESTA ERA LA SOLUCION: ");
                        pintarSolucionJuego();
                        break;
                    }
                    if (numero > 9 || numero < 1) {
                        System.out.println("Introduzca un numero valido!!");
                        pintarTableroJuego();
                    } else{
                        System.out.println("Rellenando posicion...");
                        sudokuJuego[x][y] = "("+Integer.toString(numero)+")";
                        pintarTableroJuego();
                    }
                }
                else {
                    System.out.println("Introduzca una coordenada editable!!");
                    pintarTableroJuego();
                }
                fin = false;
            }
            else{
                JOptionPane.showMessageDialog(null,"FELICIDADES, COMPLETASTE EL SUDOKU!!");
                fin = true;
                
            }
            
        }
        while (!fin);

    }

    public static void pintarTableroJuego() {
        for (int i = 0; i < sudokuJuego.length; i++) {
            if(i%3==0){
                System.out.println("-------------------------------------------");
            }
            for (int j = 0; j < sudokuJuego[i].length; j++) {
                System.out.print(sudokuJuego[i][j] + "  ");
            }
            System.out.println("  ");
        }
        System.out.println("-------------------------------------------");
    }
    
        public static void pintarSolucionJuego() {
        for (int i = 0; i < sudokuRelleno.length; i++) {
            if(i%3==0){
                System.out.println("-------------------------------------------");
            }
            for (int j = 0; j < sudokuRelleno[i].length; j++) {
                System.out.print(sudokuRelleno[i][j] + "  ");
            }
            System.out.println("  ");
        }
        System.out.println("-------------------------------------------");
    }
    

}
