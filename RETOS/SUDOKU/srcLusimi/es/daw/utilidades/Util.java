/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.utilidades;

import java.util.Scanner;

public class Util {

    // Informacion cambio de colores: https://www.campusmvp.es/recursos/post/como-cambiar-los-colores-de-la-consola-con-java-y-system-out-println.aspx
    public static final String AZUL = "\u001B[34;1m";
    public static final String BLANCO = "\u001B[47;1m";
    public static final String VERDE = "\u001B[32;40m";
    public static final String MORADO = "\u001B[35m";
    public static final String ROJO = "\u001B[31;43m";
    public static final String RESET = "\u001B[0m";

    public static Scanner sc = new Scanner(System.in);
    public static boolean[][][][] numerosDefecto = new boolean[3][3][3][3];
    public static boolean[][][][] fallosfilas = new boolean[3][3][3][3];
    public static boolean[][][][] falloscolumnas = new boolean[3][3][3][3];
    public static boolean[][][][] falloscuadrantes = new boolean[3][3][3][3];

    public static void pintaMenu() {
        System.out.println("\tSUDOKU SAMURAI");
        System.out.println("\n");
        System.out.println("Elige la dificultad:");
        System.out.println("---------------------------");
        System.out.println("1: facil (10 incognitas)");
        System.out.println("2: medio (30 incognitas)");
        System.out.println("3: dificil (50 incognitas)");
        System.out.println("4: Personalizado (n incognitas)");
        System.out.println("---------------------------");
        System.out.println("5: salir");
        System.out.println("---------------------------");
        System.out.println("");
    }

    public static int[][][][] creaArray() {

        int[][][][] sudoku = new int[3][3][3][3];
        int[][] array = new int[9][9];
        int[] numeros = new int[9];
        int numero;
        boolean comprobacion;
        int intentos = 0;

        for (int linea = 0; linea < 8; linea++) {
            
            //Crea lineas
            for (int i = 0; i < numeros.length; i++) {
                numero = (int) (Math.random() * 9) + 1;
                comprobacion = true;
                for (int j = 0; j < i; j++) {
                    if (numeros[j] == numero) {
                        comprobacion = false;
                    }
                }
                if (comprobacion) {
                    numeros[i] = numero;
                } else {
                    i--;
                }
            }
            
            //Comprueba columnas
            comprobacion = true;
            for (int i = linea - 1; i >= 0; i--) {
                for (int j = 0; j < numeros.length; j++) {
                    if (numeros[j] == array[i][j]) {
                        comprobacion = false;
                    }
                }
            }
            // Comprueba sectores
            if (comprobacion) {
                for (int k = linea - linea % 3; k < linea; k++) {
                    for (int l = 0; l < numeros.length; l++) {
                        for (int m = (l / 3) * 3; m < (l / 3) * 3 + 3; m++) {

                            if (numeros[l] == array[k][m]) {
                                comprobacion = false;
                            }
                        }
                    }
                }
                if (comprobacion) {
                    for (int i = 0; i < numeros.length; i++) {
                        array[linea][i] = numeros[i];
                    }
                } else {
                    linea--;
                }
            } else {
                linea--;
            }
        }

        // Crea ultima linea
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 10; j++) {
                comprobacion = true;
                for (int k = 0; k < 9; k++) {
                    if (array[k][i] == j) {
                        comprobacion = false;
                        break;
                    }
                }
                if (comprobacion) {
                    array[8][i] = j;
                }
            }
        }

        // Pasa array 2 dimensiones a array 4 dimensiones
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sudoku[i / 3][j / 3][i % 3][j % 3] = array[i][j];
            }
        }
        return sudoku;
    }

    public static int[][][][] sudokupuzle(int[][][][] sudoku, int visibles) {
        
        // Reinicia el juego
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                for (int k = 0; k < sudoku[i][j].length; k++) {
                    for (int l = 0; l < sudoku[i][j][k].length; l++) {
                        numerosDefecto[i][j][k][l] = false;
                        fallosfilas[i][j][k][l] = false;
                        falloscolumnas[i][j][k][l] = false;
                        falloscuadrantes[i][j][k][l] = false;
                    }
                }
            }
        }

        // Genera el sudoku que ve el jugador y define los numeros visibles por defecto
        int[][][][] sudokupuzle = new int[3][3][3][3];
        int[] numeros = new int[visibles];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = -1;
        }

        int numero;
        boolean comprobacion;
        for (int i = 0; i < numeros.length; i++) {
            numero = (int) (Math.random() * 81);
            comprobacion = true;
            for (int j = 0; j < i; j++) {
                if (numeros[j] == numero) {
                    comprobacion = false;
                }
            }
            if (comprobacion) {
                numeros[i] = numero;
            } else {
                i--;
            }
        }
        for (int num : numeros) {
            sudokupuzle[num / 27][((num % 9) / 3)][(num / 9) % 3][num % 3] = sudoku[num / 27][((num % 9) / 3)][(num / 9) % 3][num % 3];
            numerosDefecto[num / 27][((num % 9) / 3)][(num / 9) % 3][num % 3] = true;
        }

        return sudokupuzle;
    }

    public static void pintaSudoku(int[][][][] sudoku) {

        System.out.println("");
        System.out.println("   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < sudoku.length; i++) {
            System.out.print(" " + BLANCO + "                                     " + RESET);
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.println("");
                if (j != 0) {
                    System.out.println(" " + BLANCO + " " + VERDE + "-----------" + BLANCO + " "
                            + VERDE + "-----------" + BLANCO + " " + VERDE + "-----------" + BLANCO + " " + RESET);
                }
                for (int k = 0; k < sudoku[i][j].length; k++) {
                    if (k == 0) {
                        System.out.print((i * 3 + j + 1));
                    }
                    System.out.print(BLANCO + " " + RESET + " ");
                    for (int l = 0; l < sudoku[i][j][k].length; l++) {

                        if (sudoku[i][k][j][l] == 0) {
                            System.out.print(" ");
                        } else if (numerosDefecto[i][k][j][l]) {
                            System.out.print(MORADO + sudoku[i][k][j][l] + RESET);
                        } else if (fallosfilas[i][k][j][l] || falloscolumnas[i][k][j][l] || falloscuadrantes[i][k][j][l]) {
                            System.out.print(ROJO + sudoku[i][k][j][l] + RESET);
                        } else {
                            System.out.print(sudoku[i][k][j][l]);
                        }

                        if (l != 2) {
                            System.out.print(" " + VERDE + "|" + RESET + " ");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.print(BLANCO + " " + RESET);
            }
            System.out.println("");
        }
        System.out.println(" " + BLANCO + "                                     " + RESET);
        System.out.println("");
    }

    public static int[][][][] ModificaSudoku(int[][][][] sudoku) {

        int fila = -1;
        do {
            System.out.println("Indica la FILA que desea modificar (1-9, 10 para rendirse)");
            if (sc.hasNextInt()) {
                fila = sc.nextInt() - 1;
            }
            sc.nextLine();
            
        } while (fila < 0 || fila > 9);

        if (fila != 9) {

            int columna = -1;
            do {
                System.out.println("Indica la COLUMNA que desea modificar (1-9)");
                if (sc.hasNextInt()) {
                    columna = sc.nextInt() - 1;
                }
                sc.nextLine();
            } while (columna < 0 || columna > 8);

            if (!numerosDefecto[fila / 3][columna / 3][fila % 3][columna % 3]) {
                int numero = 0;
                do {
                    System.out.println("Que numero deseas introducir (1-9, 0 para borrar)");
                    if (sc.hasNextInt()) {
                        numero = sc.nextInt();
                    }
                    sc.nextLine();
                } while (numero < 0 || numero > 9);
                sudoku[fila / 3][columna / 3][fila % 3][columna % 3] = numero;
            } else {
                System.out.println("Ese número estaba por defecto");
            }
        }else sudoku[0][0][0][0] = -1;

        return sudoku;
    }

    public static boolean compruebaResultados(int[][][][] sudoku) {

        boolean filas = true;
        boolean columnas = true;
        boolean cuadrantes = true;

        //Comprueba filas
        for (int fila = 0; fila < 9; fila++) {
            if (filas) {
                filas = compruebaFila(fila, sudoku);
            } else {
                compruebaFila(fila, sudoku);
            }

        }

        // Comprueba columans
        for (int columna = 0; columna < 9; columna++) {
            if (columnas) {
                columnas = compruebaColumna(columna, sudoku);
            } else {
                compruebaColumna(columna, sudoku);
            }
        }

        //Comprueba cuadrantes
        for (int cuadrante = 0; cuadrante < 9; cuadrante++) {
            if (cuadrantes) {
                cuadrantes = compruebaCuadrante(cuadrante, sudoku);
            } else {
                compruebaCuadrante(cuadrante, sudoku);
            }

        }

        //Comprueba bacios
        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (sudoku[fila / 3][columna / 3][fila % 3][columna % 3] == 0) {
                    return false;
                }
            }
        }

        return filas && columnas && cuadrantes;

    }

    public static boolean compruebaFila(int fila, int[][][][] sudoku) {

        boolean filas = true;

        for (int columna = 0; columna < 9; columna++) {
            for (int i = 0; i < 9; i++) {
                if (columna != i && sudoku[fila / 3][columna / 3][fila % 3][columna % 3] != 0) {
                    if (sudoku[fila / 3][columna / 3][fila % 3][columna % 3] == sudoku[fila / 3][i / 3][fila % 3][i % 3]) {
                        fallosfilas[fila / 3][columna / 3][fila % 3][columna % 3] = true;
                        filas = false;
                        break;
                    } else {
                        fallosfilas[fila / 3][columna / 3][fila % 3][columna % 3] = false;
                    }
                }
            }
        }
        return filas;
    }

    public static boolean compruebaColumna(int columna, int[][][][] sudoku) {

        boolean columnas = true;

        for (int fila = 0; fila < 9; fila++) {
            for (int i = 0; i < 9; i++) {
                if (fila != i && sudoku[fila / 3][columna / 3][fila % 3][columna % 3] != 0) {
                    if (sudoku[fila / 3][columna / 3][fila % 3][columna % 3] == sudoku[i / 3][columna / 3][i % 3][columna % 3]) {
                        columnas = false;
                        falloscolumnas[fila / 3][columna / 3][fila % 3][columna % 3] = true;
                        break;
                    } else {
                        falloscolumnas[fila / 3][columna / 3][fila % 3][columna % 3] = false;
                    }
                }

            }
        }
        return columnas;
    }

    public static boolean compruebaCuadrante(int cuadrante, int[][][][] sudoku) {

        boolean cuadrantes = true;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (fila != i && columna != j && sudoku[cuadrante / 3][cuadrante % 3][fila][columna] != 0) {
                            if (sudoku[cuadrante / 3][cuadrante % 3][fila][columna] == sudoku[cuadrante / 3][cuadrante % 3][i][j]) {
                                cuadrantes = false;
                                falloscuadrantes[cuadrante / 3][cuadrante % 3][fila][columna] = true;
                                break;
                            } else {
                                falloscuadrantes[cuadrante / 3][cuadrante % 3][fila][columna] = false;
                            }
                        }
                    }
                }

            }
        }
        return cuadrantes;

    }

}
