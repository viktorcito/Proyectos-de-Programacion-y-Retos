/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.es.daw.Sudoku.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author davidarroyo
 */
public class Tablero {

    int dificultad=0;
    Random rm = new Random();
    int[] numerosNoVisibles = {rm.nextInt(10), rm.nextInt(10), rm.nextInt(10), rm.nextInt(10)};
    ArrayList<Integer> listaNumero = new ArrayList<>( Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    
    Columna[] tablero = new Columna[3];

    public Tablero() {
        tablero = generarTablero();
        
    }
    public Tablero(int dificultad){
        this.dificultad = dificultad;
        tablero = generarTablero();
    }
    

 
    private Columna[] generarTablero() {
        Collections.shuffle(listaNumero);
        for (int i = 0; i < 3; i++) {
            if(dificultad == 1) tablero[i] = new Columna(listaNumero, numerosNoVisibles);
            else    tablero[i] = new Columna(listaNumero);
            Collections.rotate(listaNumero, 1);
        }
        return tablero;
    }
    
    public void mostrarNum(int tablero, int fila, int i, int j){
        System.out.println(this.tablero[tablero].mostrarSeccion(fila, i, j));
    }
    
    @Override
    public String toString() {
        String mensaje = "";
        //System.out.println(tablero[2].mostrarSeccion());
        for (Columna com : tablero) {
            mensaje += "\n" + (com);
        }
        mensaje+=("\n ------------------------------------");
        
        return mensaje;
    }

}
