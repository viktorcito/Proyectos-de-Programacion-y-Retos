/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.po.sudoku.util;

import static es.daw.po.sudoku.SudokuApp.*;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan, Cons, Victor, Daniel
 */
public class Utilidades {
    
    private final static Scanner scLine = new Scanner(System.in);
    private final static Scanner scInt = new Scanner(System.in);
    
    private final static int OCULTOS_FACIL = 30;
    private final static int OCULTOS_NORMAL = 46;
    private final static int OCULTOS_DIFICIL = 60;

    private static int erroresGenerar = 0;
    public static int pistas = 4;
    public static boolean usoPista = false;
    private static int numeroDeCeldasOcultas = OCULTOS_NORMAL;
    

    // *********************************************************************
    // ************************* M�TODOS DE MEN� ***************************
    // *********************************************************************
    public static void mostrarMenuPrincipal() {

        System.out.println("\n*************************************************************************");
        System.out.println("************************** SUDOKU SUPER-POP *****************************");
        System.out.println("*************************************************************************");
        System.out.print("\t\t  Pulsa [[ INTRO ]] para continuar\n");
        scLine.nextLine();
        System.out.println("************************* MEN� PRINCIPAL ********************************");
        System.out.println("\t\t\t[ 1 ] Iniciar partida");
        System.out.println("\t\t\t[ 2 ] Continuar partida");
        System.out.println("\t\t\t[ 3 ] Instrucciones");
        System.out.println("\t\t\t[ 4 ] Salir");
        System.out.print("Elige una opci�n: ");
    }

    public static void mostrarMenuJuego() {
        int op;
        do {
            System.out.print("\t\t  Pulsa [[ INTRO ]] para continuar\n");
            scLine.nextLine();
            System.out.println("\n*************************************************************************");
            System.out.println("************************** SUDOKU SUPER-POP *****************************");
            System.out.println("*************************** MEN� DE JUEGO *******************************");
            mostrarTablero(tableroJugador);

            System.out.println("\n*************************************************************************");
            System.out.println("\t\t\t[ 1 ] Resolver");
            System.out.println("\t\t\t[ 2 ] ~ Pitonisa Loli ~");
            System.out.println("\t\t\t[ 3 ] Reiniciar juego");
            System.out.println("\t\t\t[ 4 ] Salir");
            System.out.print("Elige una opci�n: ");
            op = scInt.nextInt();

            switch (op) {
                case 1:
                    insertarNumero();
                    break;
                case 2:
                    menuPistas();
                    break;
                case 3:
                    ajustarDificultad();
                    rellenarTablero();
                    ocultarTablero();
                    break;
                case 4:
                    System.out.println("Saliendo al men� principal...");
                    break;
                default:
                    System.out.println("\nYa te cansastes, normal a mi tambien me huebiese pasado (no se hacer un sudoku).");
            }

            if (hasGanado()) {
                System.out.println("\t\t****************************************");
                System.out.println("\t\t*        ��ENHORABUENA CHAMPION!!      *");
                System.out.println("\t\t*   �Has logrado completar el sudoku!  *");
                System.out.println("\t\t*           �Y sin despeinarte!        *");
                System.out.println("\t\t*                                      *");
                System.out.println("\t\t*   Tu premio es...                    *");
                System.out.println("\t\t*       [ LOS AMIGOS QUE HICISTE ]     *");
                System.out.println("\t\t*       [      EN EL CAMINO      ]     *");
                System.out.println("\t\t****************************************");
                System.out.println("\nSaliendo al men� principal...");
                break;
            }
        } while (op != 4);
    }

    public static void menuPistas() {
        int opt;
        System.out.println("\n******************************************************************************************");
        System.out.println("************************************** SUDOKU SUPER-POP ***********************************");
        System.out.println("************************************* ~ PITONISA LOLI ~ ***********************************");
        System.out.println("*******************************************************************************************\n");
        verLogoLoli();
        mapaSectores();
        System.out.println("~ Dime, �Qu� futuro quieres ver?");
        System.out.println("\t\t[ 1 ] Revelar n�mero ( introduce coordenadas fila[1-9] columna[1-9] )");
        System.out.println("\t\t[ 2 ] Revelar fila ( introduce fila[1-9] )");
        System.out.println("\t\t[ 3 ] Revelar columna ( introduce columna[1-9] )");
        System.out.println("\t\t[ 4 ] Revelar sector ( introduce sector[1-9] )");
        System.out.println("\t\t[ 5 ] Revelar tablero");
        System.out.println("\t\t[ 6 ] Salir al men� de juego");
        System.out.println("\nVeo, veo, [" + (pistas) + "] bits en tu banco\n");
        System.out.print("Elige una opci�n: ");

        opt = scInt.nextInt();

        switch (opt) {
            case 1:
                pistaNum();
                break;
            case 2:
                pistaFila();
                break;
            case 3:
                System.out.println("~ �Qu� veo...? ~ ");
                pistaCol();
                break;
            case 4:
                pistaSector();
                break;
            case 5:
                System.out.println("~ Ya veo c�mo sufres. Te dar� este servicio gratis... ~");
                mostrarTablero(tablero);
                break;
            case 6:
                System.out.println("Veo, veo como vas a salir del men�...");
                break;
            default:
                System.out.println("\n���Dejame que te revele algo!!!");
        }

        System.out.println("\nTE QUEDAN [" + (pistas) + "] BITS");
    }

    // ********************************************************************
    // ****************** M�TODOS DE IMPRESI�N ****************************
    // ********************************************************************
    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {

            if (i % 3 == 0) {
                System.out.println("\n\t=========================================================");
            } else {
                System.out.println("\n\t---------------------------------------------------------");
            }
            System.out.print("\t");
            for (int j = 0; j < tablero[i].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|| [" + tablero[i][j] + "] ");
                } else {
                    System.out.print("| [" + tablero[i][j] + "] ");
                }
            }

            System.out.print("|");
        }
        System.out.println("\n\t=========================================================");
    }

    public static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {

            if (i % 3 == 0) {
                System.out.println("\n\t=========================================================");
            } else {
                System.out.println("\n\t---------------------------------------------------------");
            }
            System.out.print("\t");
            for (int j = 0; j < tablero[i].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|| [" + tablero[i][j] + "] ");
                } else {
                    System.out.print("| [" + tablero[i][j] + "] ");
                }
            }

            System.out.print("|");
        }
        System.out.println("\n\t=========================================================");
    }

    public static void mapaSectores() {

        String[][] sectores = new String[9][9];

        sectores[1][1] = "1";
        sectores[1][4] = "2";
        sectores[1][7] = "3";
        sectores[4][1] = "4";
        sectores[4][4] = "5";
        sectores[4][7] = "6";
        sectores[7][1] = "7";
        sectores[7][4] = "8";
        sectores[7][7] = "9";

        System.out.print("\t\t  [1]   [2]   [3]     [4]   [5]   [6]     [7]   [8]   [9]");
        for (int i = 0; i < sectores.length; i++) {
            if (i % 3 == 0) {
                System.out.println("\n\t         =========================================================");
            } else {
                System.out.println("\n                                                          ");
            }
            System.out.print("\t [" + (i + 1) + "] ");
            System.out.print("\t|");

            for (int j = 0; j < sectores[i].length; j++) {

                if (sectores[i][j] == null) {
                    sectores[i][j] = " ";
                }

                if (j % 3 == 0 && j != 0) {
                    System.out.print("||  " + sectores[i][j] + "  ");

                } else {
                    System.out.print("   " + sectores[i][j] + "  ");
                }
            }
            System.out.print("|");
        }
        System.out.println("\n\t         =========================================================");
    }

    public static void mostrarInstrucciones() {
        System.out.println("\n*************************************************************************");
        System.out.println("*********************** �� AYUDA, SUPER-POP!! ***************************");
        System.out.println("*************************************************************************\n");
        System.out.println("El Sudoku de la Super Pop es un acertijo matem�tico sueco (aunque se populariz� en Jap�n)\n"
                + "de deducci�n. Para jugar, tenemos un tablero de 81 casillas (9 filas, 9 columnas),\ndivididas en 9 sectores:");

        mapaSectores();

        System.out.println("\nRepasemos las normas b�sicas del sudoku y de este juego:\n"
                + "\t* Al inicio del juego ocultaremos un determinado n�mero de casillas.\n"
                + "\t* Deber�s adivinar el n�mero que hay en cada casilla.\n"
                + "\t* En cada casilla debe ir un n�mero del 1 al 9\n"
                + "\t* El n�mero introducido no debe repetirse en la misma fila, columna o sector.\n"
                + "\t* El juego finaliza cuando se hayan rellenado todas las casillas.\n"
                + "\t* El juego se guarda autom�ticamente con cada movimiento realizado.");

        System.out.println("\n�Demasiado f�cil? ��No te preocupes, ya sab�amos que eras una m�quina!! Atento a esto:\n\n"
                + "*************************** NIVELES DE DIFICULTAD *****************************************\n\n"
                + "Podr�s ajustar el nivel de dificultad a tu gusto antes de empezar la partida.\n"
                + "En funci�n de la dificultad se ajustar� el n�mero de casillas a resolver y los bits disponibles\n\n"
                + "\"�Qu� es un bit?\", �dices? ��Muy f�cil, nuestra moneda oficial!! (�Aqu� solo vale 1 eso s�!)\n"
                + "Te las ofrecemos ��gratis!! solo por jugar, aunque solo sirve para una cosa:\n"
                + "\n\t\t\t\t<< Comprar pistas >>\t\t\t\n\n"
                + "�S�, has leido bien, pistas! No las necesitar�s, pero nos gusta ayudar igual ;)\n"
                + "�Y que d�nde se compran? �Un segundo, que eso es de otro apartado!\n"
                + "\nTenemos 3 niveles de dificultad:\n"
                + "\tF�cil:\t\t\tNormal:\t\t\tDif�cil:\n"
                + "\t* Bits: 5\t\t* Bits: 4\t\t* Bits: 3\n"
                + "\t* Casillas ocultas: 30\t* Casillas ocultas: 46\t* Casillas ocultas: 60\n\n");

        System.out.println("Por si alguien te pide ayuda y est�s ocupado en ese momento �no te preocupes, dile que visite \n"
                + "a la pitonisa Lola! Por un m�dico precio puede ver el futuro, decirte alg�n numero e incluso ense�arte\nel tablero ya resuelto por tu yo del futuro! (si le caes bien):\n\n"
                + "******************************** SERVICIO PITONISA LOLI *******************************************\n\n");
        verLogoLoli();
        System.out.println("Sin importar de qu� nivel de dificultad provengas, la pitonisa Loli ofrece los siguientes servicios:\n"
                + "\t* Por casilla: revela una casilla a tu elecci�n. Cuesta UN bit.\n"
                + "\t* Por fila: revela una fila entera a tu elecci�n. Servicio Premium. Costar� TODOS tus bits.\n"
                + "\t* Por columna: revela una columna entera a tu elecci�n. Servicio Premium. Costar� TODOS tus bits.\n"
                + "\t* Por sector: revela un sector (de 3x3) a tu elecci�n. Servicio Premium. Costar� TODOS tus bits.\n"
                + "\t* Ver tablero: revela el tablero. �S�lo para clientes exclusivos!"
                + "\nTen en cuenta que podr�s usar las pistas de fila, columna o sector siempre que no\n"
                + "hayas gastado ninguno de tus bits anteriormente �Vas a tener que elegir!\n"
                + "\n�Y ya est� todo! �Mucha suerte y gracias por jugar!\n");

    }

    private static void verLogoLoli() {
        System.out.println("                                          ********                    *          ");
        System.out.println("         *                              *       *  *                *****            ");
        System.out.println("       *****               *           *       ***  *               *  *          ");
        System.out.println("        * *               ****        *          *   *                          ");
        System.out.println("                           *  *        *            *                           *      ");
        System.out.println("                    *                   *          *              *            ****       ");
        System.out.println("                  *****                   ********               ***            * *        ");
        System.out.println("                 *  *                   ************             * *              ");
        System.out.println("                                     *****************                           \n\n");
    }

    // ********************************************************************
    // ************** M�TODOS DE GENERACI�N DE TABLERO ********************
    // ********************************************************************
    public static int[][] rellenarTablero() {
        int limiteErrores = 1000;
        int numero;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                do {
                    numero = (int) (Math.random() * 9 + 1);
                    if (erroresGenerar == limiteErrores) {
                        break;
                    }
                } while (existeNumero(numero, i, j));

                if (erroresGenerar == limiteErrores) {
                    i = 0;
                    j = 0;
                    reiniciarGenerarTablero();
                }

                tablero[i][j] = numero;
                tableroJugador[i][j] = String.valueOf(tablero[i][j]);
            }
        }

        return tablero;
    }

    public static void reiniciarGenerarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 0;
            }
        }
        erroresGenerar = 0;
    }

    public static boolean existeNumero(int num, int fila, int columna) {
        for (int i = 0; i < tablero.length; i++) {
            if (num == tablero[i][columna] || (num == tablero[fila][i]) || existeEnSector(num, fila, columna)) {
                erroresGenerar++;
                return true;
            }
        }

        return false;
    }

    public static boolean existeEnSector(int num, int fila, int columna) {
        int inicioFil;
        int inicioCol;

        if (fila >= 0 && fila <= 2) {
            inicioFil = 0;
        } else if (fila >= 3 && fila <= 5) {
            inicioFil = 3;
        } else {
            inicioFil = 6;
        }

        if (columna >= 0 && columna <= 2) {
            inicioCol = 0;
        } else if (columna >= 3 && columna <= 5) {
            inicioCol = 3;
        } else {
            inicioCol = 6;
        }

        for (int i = inicioFil; i < inicioFil + 3; i++) {
            for (int j = inicioCol; j < inicioCol + 3; j++) {
                if (num == tablero[i][j] && i != fila) {
                    return true;
                }
            }
        }
        return false;
    }

    // *********************************************************************
    // ************** M�TODO DE PREPARACI�N DE TABLERO *********************
    // *********************************************************************
    public static void ajustarDificultad() {
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        int op;
        String[] dificultad = {"F�cil", "Intermedia", "Dificil"};
        op = JOptionPane.showOptionDialog(dialog, "Elige dificultad", "DIFICULTAD JUEGO", 1, JOptionPane.QUESTION_MESSAGE, null, dificultad, 1);
        System.out.println("\t\t\t��Tablero generado!!");
        switch (op) {
            case 0:
                pistas = 5;
                numeroDeCeldasOcultas = OCULTOS_FACIL;
                System.out.println("\n\t\t\tDificultad [[ F�cil ]]");
                break;
            case 1:
                pistas = 4;
                numeroDeCeldasOcultas = OCULTOS_NORMAL;
                System.out.println("\n\t\t\tDificultad [[ Normal ]]");
                break;
            case 2:
                pistas = 3;
                numeroDeCeldasOcultas = OCULTOS_DIFICIL;
                System.out.println("\n\t\t\tDificultad [[ Dif�cil ]]");
                break;
            default:
                System.out.println("Has cancelado la opci�n. La dificultad se ha ajustado por defecto a\n\t\t\t   [[ Normal ]]");
                System.out.println("Para reajustar la dificultad inicia una nueva partida o reinicia el juego.\n");
                break;
        }

        usoPista = false;
        dialog.dispose();
    }

    public static void ocultarTablero() {
        int fila, columna;

        for (int i = 0; i < numeroDeCeldasOcultas; i++) {
            do {
                fila = (int) (Math.random() * tableroJugador.length);
                columna = (int) (Math.random() * tableroJugador.length);
            } while (tableroJugador[fila][columna].equals("*"));
            tableroJugador[fila][columna] = "*";
        }
    }

    // *********************************************************************
    // ************************ M�TODOS DE JUEGO ***************************
    // *********************************************************************
    public static void insertarNumero() {
        int numero, fila, columna;
        do {
            System.out.println("�En qu� fila est�s pensando?");
            fila = scInt.nextInt() - 1;
            if (fila < 0 || fila > 8) {
                System.out.println("La fila introducida no existe");
            }

        } while (fila < 0 || fila > 8);
        do {
            System.out.println("�Y qu� columna");
            columna = scInt.nextInt() - 1;
            if (columna < 0 || columna > 8) {
                System.out.println("La columna introducida no existe");
            }
        } while (columna < 0 || columna > 8);

        if (!tableroJugador[fila][columna].equals("*")) {
            System.out.println("�Est�s perdido? � Ese n�mero ya lo sabes !");
        } else {
            do {
                System.out.println("�Qu� n�mero va ah�?");
                numero = scInt.nextInt();

                if (numero < 1 || numero > 9) {
                    System.out.println("No puedes meter ese n�mero");
                } else if (tablero[fila][columna] == numero) {
                    System.out.println("�� Clavao !! ��Impresionante!! ");
                    tableroJugador[fila][columna] = Integer.toString(numero);
                } else {
                    System.out.println("��Paquet�n has fallado!!!");
                }
            } while (numero < 1 || numero > 9);
        }
    }

    public static void pistaNum() {
        int fila, col;

        mostrarTablero(tableroJugador);

        if (pistas != 0) {
            System.out.println("Estoy viendo la fila...");
            fila = scInt.nextInt() - 1;
            System.out.println("Y estoy viendo la columna...");
            col = scInt.nextInt() - 1;

            if ((fila >= 0 && fila < 9) && (col >= 0 && col < 9)) {
                if (tableroJugador[fila][col].equals("*")) {
                    tableroJugador[fila][col] = String.valueOf(tablero[fila][col]);
                    pistas--;
                    System.out.println("Mira tu tablero y ver�s algo nuevo...");
                    usoPista = true;
                } else {
                    System.out.println("��Esto es el pasado!! Y se ve que ya tienes ese numero");
                }
            } else {
                System.out.println("No veo... �estar� ciega? �me has dicho bien las coordenadas?");
            }
        } else {
            System.out.println("�Ya no hay dinero? De repente, �estoy ciega!");
        }

    }

    public static void pistaSector() {
        //solo se podra revelar un sector una vez, agotando todas las pistas 
        int inicioFi = 0, inicioCo = 0, sector;

        if (!usoPista) {
            System.out.println("Veo el sector...");
            sector = scInt.nextInt();

            if (sector > 0 && sector <= 9) {
                switch (sector) {
                    case 1:
                        inicioFi = 0;
                        inicioCo = 0;
                        break;
                    case 2:
                        inicioFi = 0;
                        inicioCo = 3;
                        break;
                    case 3:
                        inicioFi = 0;
                        inicioCo = 6;
                        break;
                    case 4:
                        inicioFi = 3;
                        inicioCo = 0;
                        break;
                    case 5:
                        inicioFi = 6;
                        inicioCo = 3;
                        break;
                    case 6:
                        inicioFi = 3;
                        inicioCo = 6;
                        break;
                    case 7:
                        inicioFi = 6;
                        inicioCo = 0;
                        break;
                    case 8:
                        inicioFi = 6;
                        inicioCo = 3;
                        break;
                    case 9:
                        inicioFi = 6;
                        inicioCo = 6;
                        break;
                }

                for (int y = inicioFi; y < inicioFi + 3; y++) {
                    for (int g = inicioCo; g < inicioCo + 3; g++) {
                        tableroJugador[y][g] = String.valueOf(tablero[y][g]);
                    }
                }

                pistas = 0;
                System.out.println("�Un poquito m�s rica y un sector m�s despejado! Adoro los negocios.");
                usoPista = true;
            } else {
                System.out.println("�No lo veo porque no existe! Y no veo universos paralelos as� que tendr�s que indicarme bien...");
            }
        } else {
            System.out.println("Soy ciega, no puedo ver a alguien tan pobre...");
        }

    }

    public static void pistaFila() {
        int fila;
        if (!usoPista) {
            System.out.println("Estoy viendo la fila...");
            fila = scInt.nextInt() - 1;

            if (fila >= 0 && fila < 9) {
                for (int i = 0; i < tablero.length; i++) {
                    tableroJugador[fila][i] = String.valueOf(tablero[fila][i]);
                }

                pistas = 0;
                System.out.println("�Lo veo! Y t� lo ver�s en tu tablero �Sal con cuidado y recomi�ndame a tus amigos, coraz�n!");
                usoPista = true;

            } else {
                System.out.println("Yo veo el futuro, pero t� no el presente... �Dime bien la fila!");
            }
        } else {
            System.out.println("El futuro dice que... �lo sabr�s cuando tengas m�s bits!");
        }
    }

    public static void pistaCol() {
        //solo se podra revelar columna entera una vez, agotando todas las pistas 
        int col;
        if (!usoPista) {
            System.out.println("Veo la columna...");
            col = scInt.nextInt() - 1;

            if (col >= 0 && col < 9) {
                for (int i = 0; i < tablero.length; i++) {
                    tableroJugador[i][col] = String.valueOf(tablero[i][col]);
                }
                pistas = 0;
                System.out.println("Y con esta moneda... �un pasito m�s cerca del todoterreno!");
                System.out.println("�Ah, s�, lo del futuro! Mira en tu tablero.");
                usoPista = true;
            } else {
                System.out.println("�Mira al tablero! �Ves esa columna? �no? �Pues porque no existe!");
            }
        } else {
            System.out.println("El futuro no s�, pero el presente... pobre, pobre...");
        }
    }

    public static boolean hasGanado() {
        if (tablero[0][0] != 0) {

            for (String[] filaTableroJ : tableroJugador) {
                for (String valorCasilla : filaTableroJ) {
                    if (valorCasilla.equals("*")) {
                        return false;
                    }
                }
            }
            return true;

        } else {
            return false;
        }

    }

}
