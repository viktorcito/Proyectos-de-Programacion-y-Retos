/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.es.daw.Sudoku.Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author davidarroyo
 */
public class Seccion {

    int[] numerosNoVisibles;
    ArrayList<Integer> listaNumero;
    int[][] sector = new int[3][3];
    boolean[][] mostrar = new boolean[3][3];

    public Seccion(ArrayList<Integer> listaNumero) {
        this.listaNumero = listaNumero;
        sector = crearSeccion();
    }

    public Seccion(ArrayList<Integer> listaNumero, int[] numerosNoVisibles) {
        this.numerosNoVisibles = numerosNoVisibles;
        this.listaNumero = listaNumero;
        sector = crearSeccion();
    }
    
    public String mostrarFila(int i, int j){
        System.out.println(sector[i][j]);
        if(!mostrar[i][j]){
            String mensaje = JOptionPane.showInputDialog(null, "Que número quieres escribir", "Sudoku", JOptionPane.QUESTION_MESSAGE);
            int num = Integer.parseInt(mensaje);
            if(num == sector[i][j])
                System.out.println("aaa");
                listaNumero.remove(sector[i][j]);
        }
        return ""+sector[i][j];
    }

    private boolean[][] mostrarNumeros() {
        for (boolean[] mos : mostrar) {
            for (int i = 0; i < mos.length; i++) {
                mos[i] = true;
            }
        }
        return mostrar;
    }
    


    private int[][] crearSeccion() {
        mostrar = mostrarNumeros();
        int contador = 0;
        for (int[] fila : sector) {
            for (int i = 0; i < fila.length; i++) {
                fila[i] = listaNumero.get(contador);
                contador++;
            }
        }
        return sector;
    }

    @Override
    public String toString() {
        String mensaje = "";
        for (int i = 0; i < sector.length; i++) {
            mensaje += " | ";
            for (int j = 0; j < sector[i].length; j++) {

                //compr si es num no mostrado y le damos mostrar false
                if (numerosNoVisibles != null) {

                    for (int num : numerosNoVisibles) {
                        if (num == sector[i][j]) {
                            mostrar[i][j] = false;
                        }
                    }

                    if (mostrar[i][j]) {
                        mensaje += " " + sector[i][j] + " ";
                    } else {
                        mensaje += "    ";
                    }

                } else {
                    mensaje += " " + sector[i][j] + " ";
                }
            }
        }
        mensaje += " | ";
        return mensaje;
    }
}
