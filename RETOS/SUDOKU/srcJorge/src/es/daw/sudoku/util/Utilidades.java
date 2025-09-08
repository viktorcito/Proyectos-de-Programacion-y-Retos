package es.daw.sudoku.util;

import java.util.Random;
import es.daw.sudoku.Main;
import java.util.Scanner;

public class Utilidades {

    static Scanner sc = new Scanner(System.in);
    static Random r = new Random(System.currentTimeMillis());

    public static int[][] crearBloqueRandom() {

        int[][] array = new int[3][3];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int num;
                boolean isUnique;
                do {
                    num = r.nextInt(9) + 1;
                    isUnique = true;
                    for (int k = 0; k <= i; k++) {
                        for (int l = 0; l < array[k].length; l++) {
                            if (k == i && l == j) {
                                continue;
                            }
                            if (array[k][l] == num) {
                                isUnique = false;
                                break;
                            }
                        }
                    }
                } while (!isUnique);
                array[i][j] = num;
            }
        }
        return array;
    }

    public static int[][] crearBloqueHoriz(int[][] bloqueInicio) {

        int[][] bloqueFin = new int[3][3];

        bloqueFin[0] = bloqueInicio[2];
        bloqueFin[1] = bloqueInicio[0];
        bloqueFin[2] = bloqueInicio[1];

        return bloqueFin;
    }

    public static int[][] crearBloqueVert(int[][] bloqueInicio) {

        int[][] bloqueFin = new int[3][3];

        for (int i = 0; i < bloqueInicio.length; i++) {
            bloqueFin[i][0] = bloqueInicio[i][2];
            bloqueFin[i][1] = bloqueInicio[i][0];
            bloqueFin[i][2] = bloqueInicio[i][1];
        }

        return bloqueFin;

    }

    public static int[][][][] crearSudoku() {

        int[][] bloque1, bloque2, bloque3, bloque4, bloque5, bloque6, bloque7, bloque8, bloque9;

        bloque1 = Utilidades.crearBloqueRandom();
        bloque4 = Utilidades.crearBloqueVert(bloque1);
        bloque7 = Utilidades.crearBloqueVert(bloque4);

        bloque2 = Utilidades.crearBloqueHoriz(bloque1);
        bloque3 = Utilidades.crearBloqueHoriz(bloque2);

        bloque5 = Utilidades.crearBloqueHoriz(bloque4);
        bloque6 = Utilidades.crearBloqueHoriz(bloque5);

        bloque8 = Utilidades.crearBloqueHoriz(bloque7);
        bloque9 = Utilidades.crearBloqueHoriz(bloque8);

        int[][][][] sudoku = {{bloque1, bloque2, bloque3}, {bloque4, bloque5, bloque6}, {bloque7, bloque8, bloque9}};

        return sudoku;
    }

    public static void pintarSudoku() {

        for (int[][][] i : Main.sudoku) {
            for (int[][] j : i) {
                for (int[] k : j) {
                    for (int l : k) {
                        System.out.print(l + " ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int dificultad() {

        boolean salir = false;
        int numCeros = 0, nivel;

        do {
            System.out.println("Indica el nivel de dificultad del Sudoku (del 0 al 5):\n"
                    + "\n\t0. Modo 'prueba' (1 cero)\n"
                    + "\t1. Nivel fácil (10 ceros)\n"
                    + "\t2. Nivel medio (20 ceros)\n"
                    + "\t3. Nivel difícil (30 ceros)\n"
                    + "\t4. Nivel imposible (50 ceros)\n"
                    + "\t5. Nivel GOD (70 ceros)");
            if (sc.hasNextInt()) {
                nivel = sc.nextInt();
                switch (nivel) {
                    case 0:
                        numCeros = 1;
                        salir = true;
                        break;
                    case 1:
                        numCeros = 10;
                        salir = true;
                        break;
                    case 2:
                        numCeros = 20;
                        salir = true;
                        break;
                    case 3:
                        numCeros = 30;
                        salir = true;
                        break;
                    case 4:
                        numCeros = 50;
                        salir = true;
                        break;
                    case 5:
                        numCeros = 70;
                        salir = true;
                        break;
                    default:
                        System.out.println("\n\t¡AVISO! " + nivel + " no es una opción válida\n");
                        break;
                }
            } else {
                pintarAviso(1);
                sc.next();
            }
        } while (salir != true);

        return numCeros;
    }

    public static int[][][][] vaciarSudoku() {

        int[][][][] sudokuNuevo = new int[Main.sudoku.length][Main.sudoku[0].length][Main.sudoku[0][0].length][Main.sudoku[0][0][0].length];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(Main.sudoku[i][j][k], 0, sudokuNuevo[i][j][k], 0, 3);
                }
            }
        }

        int contadorCeros;
        int nivel = dificultad();

        do {
            int a = r.nextInt(3);
            int b = r.nextInt(3);
            int c = r.nextInt(3);
            int d = r.nextInt(3);

            sudokuNuevo[a][b][c][d] = 0;

            contadorCeros = 0;

            for (int[][][] iseses : sudokuNuevo) {
                for (int[][] ese : iseses) {
                    for (int[] is : ese) {
                        for (int i : is) {
                            if (i == 0) {
                                contadorCeros++;
                            }
                        }
                    }
                }
            }
        } while (contadorCeros != nivel);

        return sudokuNuevo;
    }

    public static void pintarSudokuNuevo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(Main.sudokuNuevo[i][j][k][l] + " ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void preguntarCeldas() {

        int row, col, num;

        boolean salir = false;

        do {
            System.out.println("Indica el número de fila (de 1 a 9): ");
            if (sc.hasNextInt()) {
                row = sc.nextInt();
                if (row >= 1 && row <= 9) {
                    salir = true;
                } else {
                    pintarAviso(2);
                    salir = false;
                    continue;
                }

                System.out.println("Indica el número de columna (de 1 a 9): ");
                if (sc.hasNextInt()) {
                    col = sc.nextInt();
                    if (col >= 1 && col <= 9) {
                        salir = true;
                    } else {
                        pintarAviso(2);
                        salir = false;
                        continue;
                    }

                    System.out.println("Indica el número que quieres rellenar: ");
                    if (sc.hasNextInt()) {
                        num = sc.nextInt();
                        if (num >= 1 && num <= 9) {
                            rellenarCasillas(row, col, num);
                            salir = true;
                        } else {
                            pintarAviso(2);
                            salir = false;
                        }
                    } else {
                        pintarAviso(1);
                        sc.next();
                        salir = false;
                    }

                } else {
                    pintarAviso(1);
                    sc.next();
                    salir = false;
                }

            } else {
                pintarAviso(1);
                sc.next();
                salir = false;
            }

        } while (salir != true);

        System.out.println("");
        pintarSudokuNuevo();

    }

    public static void pintarAviso(int aviso) {
        switch (aviso) {
            case 1:
                System.out.println("\n\t¡AVISO! No has escrito un número.\n");
                break;
            case 2:
                System.out.println("\n\t¡AVISO! Has escrito un número no comprendido entre 1 y 9.\n");
                break;
        }
    }

    public static void rellenarCasillas(int row, int col, int num) {

        int i = 0, j = 0, k = 0, l = 0;

        switch (row) {
            case 1:
            case 2:
            case 3:
                j = row - 1;
                break;
            case 4:
            case 5:
            case 6:
                i = 1;
                j = row - 4;
                break;
            case 7:
            case 8:
            case 9:
                i = 2;
                j = row - 7;
                break;
            default:
                break;
        }

        switch (col) {
            case 1:
            case 2:
            case 3:
                l = col - 1;
                break;
            case 4:
            case 5:
            case 6:
                k = 1;
                l = col - 4;
                break;
            case 7:
            case 8:
            case 9:
                k = 2;
                l = col - 7;
                break;
            default:
                break;
        }

        Main.sudokuNuevo[i][j][k][l] = num;
    }

    public static void comprobarSolucion() {
        int fila, columna;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (Main.sudokuNuevo[i][j][k][l] != Main.sudoku[i][j][k][l]) {
                            switch (i) {
                                case 0:
                                    fila = j + 1;
                                    break;
                                case 1:
                                    fila = j + 4;
                                    break;
                                default:
                                    fila = j + 7;
                                    break;
                            }
                            switch (k) {
                                case 0:
                                    columna = l + 1;
                                    break;
                                case 1:
                                    columna = l + 4;
                                    break;
                                default:
                                    columna = l + 7;
                                    break;
                            }
                            System.out.println("\t¡¡El número en la fila " + fila + " y la columna " + columna + " es incorrecto.!!\n");
                        }
                    }
                }
            }
        }

    }
}
