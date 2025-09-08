/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.util;

import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS MARTIN SALVATIERRA
 */
public class util {

    //PROPIEDADES.
    public static int nivel = 1;

    //METODO PARA CARGAR JUEGO.
    public static int[][] cargar_juego(int nivel) {

        int[][] matriz = new int[9][9];

        switch (nivel) {

            case 2:

                matriz[0][0] = 7;
                matriz[0][4] = 5;
                matriz[0][6] = 4;
                matriz[1][0] = 4;
                matriz[1][3] = 1;
                matriz[1][4] = 9;
                matriz[1][6] = 6;
                matriz[1][7] = 2;
                matriz[1][8] = 7;
                matriz[2][2] = 6;
                matriz[2][8] = 9;
                matriz[3][0] = 9;
                matriz[3][2] = 3;
                matriz[3][6] = 8;
                matriz[4][3] = 4;
                matriz[4][5] = 3;
                matriz[5][2] = 8;
                matriz[5][6] = 5;
                matriz[5][8] = 2;
                matriz[6][0] = 5;
                matriz[6][6] = 2;
                matriz[7][0] = 2;
                matriz[7][1] = 9;
                matriz[7][2] = 1;
                matriz[7][4] = 4;
                matriz[7][5] = 7;
                matriz[7][8] = 8;
                matriz[8][2] = 7;
                matriz[8][4] = 1;
                matriz[8][8] = 5;

                break;

            case 1:
            default:

                matriz[0][2] = 9;
                matriz[0][5] = 8;
                matriz[0][6] = 5;
                matriz[0][7] = 4;
                matriz[1][8] = 7;
                matriz[2][1] = 5;
                matriz[2][2] = 4;
                matriz[2][4] = 9;
                matriz[2][6] = 1;
                matriz[3][5] = 6;
                matriz[3][6] = 3;
                matriz[3][7] = 2;
                matriz[4][1] = 8;
                matriz[4][2] = 2;
                matriz[4][6] = 4;
                matriz[4][7] = 1;
                matriz[5][1] = 3;
                matriz[5][2] = 5;
                matriz[5][3] = 2;
                matriz[6][2] = 7;
                matriz[6][4] = 3;
                matriz[6][6] = 2;
                matriz[6][7] = 5;
                matriz[7][0] = 9;
                matriz[8][1] = 4;
                matriz[8][2] = 3;
                matriz[8][3] = 8;
                matriz[8][7] = 9;

                break;

        }

        return matriz;
    }

    //METODO PARA NO SOBREESCRIBIR VALORES EN EL JUEGO.
    public static boolean es_origen(int fila, int columna, int[][] matriz) {

        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;

    }

    //METODO QUE DETECTA SI EL JUEGO FUE TERMINADO.
    public static boolean terminado(int[][] matriz) {

        boolean resultado = true;

        for (int[] matriz1 : matriz) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz1[c] == 0) {
                    resultado = false;
                }
            }
        }

        return resultado;

    }

    //METODO QUE IMPRIME UN MENSAJE CON BORDE.
    public static void mensaje(String mensaje) {

        //CABECERA.
        System.out.print("É");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("Í");
        }
        System.out.print("»\n");

        //CUERPO.
        System.out.print("º          ");
        System.out.print(mensaje);
        System.out.print("          º\n");

        //PIE
        System.out.print("È");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("Í");
        }

        System.out.print("¼\n\n");

    }

//METODO QUE IMPRIME EL VECTOR.
    public static void imprime_sudoku(int[][] matriz) {

        System.out.println(" ------------------------------------- ");

        for (int f = 0; f < matriz.length; f++) {

            System.out.print(" | ");

            for (int c = 0; c < matriz.length; c++) {

                if (matriz[f][c] != 0) {
                    System.out.print(matriz[f][c]);
                } else {
                    System.out.print(" ");
                }

                if (es_origen(f, c, cargar_juego(nivel))) {
                    System.out.print(" ");
                } else {
                    System.out.print(" ");
                }

                if (c == 2 || c == 5) {
                    System.out.print("¡ ");
                } else {
                    System.out.print("| ");
                }

            }
            System.out.println();
            if (f != 2 && f != 5) {
                System.out.print(" ------------------------------------- ");
            } else {
                System.out.print(" ²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²² ");
            }
            System.out.println();
        }
    }

    //METODO PARA COMPROBAR FILAS.
    public static boolean existe_fila(int numero, int fila, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[(fila - 1)][i] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;

    }

    //METODO PARA COMPROBAR COLUMNAS.
    public static boolean existe_columna(int numero, int columna, int[][] matriz) {

        boolean resultado = false;

        for (int[] matriz1 : matriz) {
            if (matriz1[(columna - 1)] == numero) {
                resultado = true;
                break;
            }
        }

        //COMPROBAMOS SI ES 0.
        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }

    // METODO PARA COMPROBAR LOS INDICES.
    public static boolean comprobar_indice(int indice) {

        return indice > 0 && indice < 10;

    }

    // METODO PARA COMPROBAR LOS VALORES.
    public static boolean comprobar_valor(int valor) {

        return valor >= 0 && valor < 10;

    }

    //METODO PARA COMPROBAR LAS CAJAS.
    public static boolean existe_caja(int valor, int fila, int columna, int[][] matriz) {

        //VARIABLES.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //DETERMINAMOS LAS FILAS DE LA CAJA.
        if (fila > 0 && fila < 4) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila > 3 && fila < 7) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //DETERMINAMOS LAS COLUMNAS DE LA CAJA.
        if (columna > 0 && columna < 4) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna > 3 && columna < 7) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //RECORREMOS EL RANGO DE LA CAJA, Y BUSCAMOS EL VALOR.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (matriz[f][c] == valor) {
                    resultado = true;
                    break;

                }
            }
        }

        //COMPROBAMOS SI ES 0.
        if (valor == 0) {
            resultado = false;
        }

        //REGRESAMOS EL VALOR BOOLEANO.
        return resultado;
    }
// MUESTRA LAS REGLAS DEL SUDOKU
    public static void REGLAS(){
        
        String MENSAJE = "<html>"
                        + "<h1>REGLAS DE ESTE SUDOKU V6</h1>"
                        + "<h2>HECHO POR CARLOS MARTIN SALVATIERRA 1º DAW A</h2>"
                        + "<p>Este sudoku solo tiene 2 niveles , este juego esta para que te enfades un poquito la verdad ;)</p>"
                                              
                        + "<ol>"
                        + "<li>Cada fila de la cuadrícula debe contener los números del 1 al 9 sin repetirse.</li>"
                        + "<li>Cada columna de la cuadrícula debe contener los números del 1 al 9 sin repetirse.</li>"
                        + "<li>Cada uno de los 9 subcuadros de 3x3 de la cuadrícula debe contener los números del 1 al 9 sin repetirse.</li>"
                        + "</ol>"
                        
                        + "<ul>"
                        + "<li>Cuando querrais introducir un numero en fila o en la columna tambien debe ser del 1 al 9 (no del 0 al 8)</li>"
                        + "</ul>"
                    
                    
                        + "<p>No le he puesto ninguna dificultad , porque ya es dificil hasta para mi , pero bueno que los disfruteis la verdad :3</p>" 
                    
                        + "<p>Todo el codigo esta comentado.</p>"
                        + "<p>QUERIA METER UN GIF PERO NO ME DEJA LLORO :(</p>"              
                        + "</html>";
    
            JOptionPane.showMessageDialog(null, MENSAJE, "Reglas del Sudoku", JOptionPane.INFORMATION_MESSAGE);
    }

   
    
}
