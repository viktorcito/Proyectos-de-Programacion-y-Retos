/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.sudoku.model;

import java.util.Random;

/**
 *
 * @author Patry
 */
public class Sudoku_MariLuz {
    
     /***********************************************
     *      CREAR SUDOKU AL ESTILO MARI LUZ         *
     ***********************************************/
    
    public void crearSudoku(){ // CON LA FÓRMULA DE MARI LUZ
        
        int[][] tablero = new int[9][9];
        int[][][][] sectores = new int[3][3][3][3];
        String numDesordenados = "";
        
        //Desordenamos aleatoriamente los números del 1 al 9:
        Random rnd = new Random();
        do {                    
            int numAle = rnd.nextInt(9)+1;
            if (!numDesordenados.contains(Integer.toString(numAle))) numDesordenados += numAle;
        } while (numDesordenados.length()<9);
           
        //Los colocamos en el 1º sector:        
        for (int i = 0; i < 3; i++) {            
            for (int j = 0; j < 3; j++) {                 
                sectores[0][0][i][j] = Character.getNumericValue(numDesordenados.charAt((3*i)+j));
            }
        }
        
        //Partiendo del sector 0 creamos el resto de sectores:
        for (int i = 0; i < 3; i++) {
            if (i>0) sectores[i][0] = crearSector(true, sectores[i-1][0]);
            for (int j = 1; j < 3; j++) {
                sectores[i][j] = crearSector(false, sectores[i][j-1]);
            }
        }
        
        //Colocamos los sectores en el tablero para poder pintarlo
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = sectores[(i/3)][(j/3)][i - ((i/3)*3)][j - (3*(j/3))];
            }
        }     
                  
        System.out.println("GENERADO SEGÚN MÉTODO MARI LUZ!!!!!!\n");        
    }       
     
    private int[][] crearSector(boolean vertical, int[][] iniSector){        
        int[][] nuevoSector =new int[iniSector.length][iniSector.length];
        for (int i = 0; i < iniSector.length; i++) {
            for (int j = 0; j < iniSector.length; j++) {
                if (i == iniSector.length-1){
                    if (vertical) nuevoSector[j][0] = iniSector[j][i];
                    else nuevoSector[0][j] = iniSector[i][j];
                }
                else{
                    if (vertical) nuevoSector[j][i+1] = iniSector[j][i];
                    else nuevoSector[i+1][j] = iniSector[i][j];
                }
            }
        }
        return nuevoSector;
    }            
    
}




    /*sectores[1][0] = ponerVerticales(sectores[0][0]);
    sectores[2][0] = ponerVerticales(sectores[1][0]);

    sectores[0][1] = ponerHorizontales(sectores[0][0]);
    sectores[0][2] = ponerHorizontales(sectores[0][1]);

    sectores[1][1] = ponerHorizontales(sectores[1][0]);
    sectores[1][2] = ponerHorizontales(sectores[1][1]);

    sectores[2][1] = ponerHorizontales(sectores[2][0]);
    sectores[2][2] = ponerHorizontales(sectores[2][1]);*/
    
    /*private int[][] ponerVerticales(int[][] iniSector){
        int[][] nuevoSector =new int[iniSector.length][iniSector.length];
        for (int i = 0; i < iniSector.length; i++) {
            for (int j = 0; j < iniSector.length; j++) {
                if (i == iniSector.length-1){
                    nuevoSector[j][0] = iniSector[j][i];
                }
                else{
                    nuevoSector[j][i+1] = iniSector[j][i];
                }
            }
        }
        return nuevoSector;
    }*/