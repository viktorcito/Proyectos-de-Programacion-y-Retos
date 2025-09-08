/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.es.daw.Sudoku.Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author davidarroyo
 */
public class Columna{

    int[] numerosNoVisibles;
    ArrayList<Integer> listaNumero;

    Seccion[] fila = new Seccion[3];

    public Columna(ArrayList<Integer> listaNumero) {
        this.listaNumero = listaNumero;
        this.fila = generarColumna();
    }
    
    public Columna(ArrayList<Integer> listaNumero,  int[] numerosNoVisibles) {
        this.numerosNoVisibles = numerosNoVisibles;
        this.listaNumero = listaNumero;
        this.fila = generarColumna();
    }

    private Seccion[] generarColumna() {
        for (int i = 0; i < 3; i++) {
            if(numerosNoVisibles != null) fila[i] = new Seccion(listaNumero, numerosNoVisibles);
            else    fila[i] = new Seccion(listaNumero);
            modificarFilaLista();
        }
        return fila;
    }


    public void modificarFilaLista() {
        Collections.rotate(listaNumero, 3);
    }

        //mostrar seccion "mensaje con la k kieras"
    public String mostrarSeccion(int fila, int i, int j){
        String mensaje = "";
        mensaje+=(this.fila[fila]).mostrarFila(i, j);
        return mensaje;
    }

    @Override
    public String toString() {
        String mensaje="";
        mensaje+=(" ------------------------------------");
        for (Seccion sec : fila) {
            mensaje+=("\n"+sec);
        }
        
        return mensaje;
    }

}
