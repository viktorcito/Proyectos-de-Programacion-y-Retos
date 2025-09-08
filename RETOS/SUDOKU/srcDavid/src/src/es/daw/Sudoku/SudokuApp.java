/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.es.daw.Sudoku;

import src.es.daw.Sudoku.Model.Tablero;
import src.es.daw.Sudoku.Model.Sudoku;


/**
 *
 * @author davidarroyo
 */
public class SudokuApp {

    public static Tablero juego = new Tablero(0);
    
    public static void main(String[] args) {

        String opcion = Sudoku.menuSudoku();
        

        if(null == opcion)System.exit(0);
        else switch (opcion) {
            case "Jugar (Fácil)":
                juego = new Tablero(0);
                Sudoku.ComenzarJuego();
                break;
            case "Jugar (Difícil)":
                juego = new Tablero(1);
                Sudoku.ComenzarJuego();
                break;
            default:
                System.exit(0);
        }
        }

    }
