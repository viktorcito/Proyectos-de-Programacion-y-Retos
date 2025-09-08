/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.sudoku;

import es.daw.sudoku.model.*;
import java.util.Scanner;

/**
 *
 * @author Patry
 */
public class SudokuApp {

    /**
     * @param args the command line arguments
     */
    
    private static Scanner sc = new Scanner(System.in); 
    public static int brillo;
    
    public static void main(String[] args) {
        // TODO code application logic here  

        int colorBase = 5;
        int dificultad = 2; 
        int brillo = 1;
        Util.colorNormal = "\033[" + brillo + ";30m".replace("0m", colorBase +"m");           
        
        int opcion = -1;
        do {            
            System.out.println(Util.creaMenu());
            if (sc.hasNextInt()) opcion = sc.nextInt();
            else {
                sc = new Scanner(System.in);
                opcion = -1;
            }
                
            switch (opcion){
                case 1:
                    Util.pintaBienvenida();
                    break;
                case 2:
                    Util.pintaInstrucciones();
                    break;
                case 3:
                    colorBase = Util.eligeColor();
                    break;
                case 4:
                    dificultad = Util.eligeDificultad();
                    break;
                case 5:
                    jugarSudoku(false, dificultad, colorBase);                        
                    break;
                case 6:
                    jugarSudoku(true, dificultad, colorBase);                        
                    break;
                case 7:
                    System.out.println(Util.pintaFin());
                    break;
                default:
                    System.out.println("Elige un número entre 1 y 7");
            }            
            
        } while (opcion != 7);
        
        sc.close(); //RECUERDA: No es necesario, pero es mejor hacerlo.                

        System.out.println("Chim-pún!!!\n");
    }
    
    static void jugarSudoku(boolean superMolon, int dificultad, int colorBase){        
        Sudoku sudoku = new Sudoku(superMolon, dificultad, colorBase, brillo);
        
        sc = new Scanner(System.in);
        
        String jugada;
        do {
            System.out.println(sudoku);
            System.out.println("[Brillo: "+ brillo + "] Cambiar Brillo: CB");
            System.out.println("[Salir: X] Haz tu jugada:");
            jugada = sc.nextLine();
            
            if (!jugada.isEmpty()){
                
                int posX, posY;
                
                if (Util.esNumerico(jugada) && jugada.length() == 3)
                    sudoku.actualizarCasilla(Character.getNumericValue(jugada.charAt(0)), Character.getNumericValue(jugada.charAt(1)), Character.getNumericValue(jugada.charAt(2)));
                
                else if (jugada.equalsIgnoreCase("VO"))
                    sudoku.setVO(!sudoku.isVO());
                
                else if (jugada.equalsIgnoreCase("CB"))
                    brillo = sudoku.cambiarBrillo();
                
                else if (jugada.equalsIgnoreCase("X"))
                    System.out.println("Ohhhh.... más suerte las próxima vez.");
                
                else if (jugada.equalsIgnoreCase("PE")) 
                    sudoku.setPE(!sudoku.isPE());
                
                else if (sudoku.isModoSuperMolon()){
                    
                    if (jugada.equalsIgnoreCase("PR")){
                        sudoku.usarPistaResolver();
                        System.out.println("Esta era la solución que estábamos buscando: ");
                        System.out.println(sudoku);
                        jugada = "X";
                    }
                    else if (jugada.toUpperCase().startsWith("PC") && jugada.length() == 4 && Util.esNumerico(jugada.toUpperCase().replace("PC", ""))){
                        
                        posX = Character.getNumericValue(jugada.charAt(2));
                        posY = Character.getNumericValue(jugada.charAt(3));

                        if (sudoku.usarPistaCasilla(posX-1, posY-1)) 
                            System.out.println("Se ha destapado la casilla " + posX + "x" + posY);

                    }
                    else if (jugada.toUpperCase().startsWith("PS")&& jugada.length() == 4 && Util.esNumerico(jugada.toUpperCase().replace("PS", ""))){
                        
                        posX = Character.getNumericValue(jugada.charAt(2));
                        posY = Character.getNumericValue(jugada.charAt(3));
                        
                        if (sudoku.usarPistaSector(posX -1, posY-1))
                            System.out.println("Se ha destapado una casilla del sector " + posX + "x" + posY);
                    
                    }
                    else if(jugada.toUpperCase().startsWith("PN")&& jugada.length() == 3 && Util.esNumerico(jugada.toUpperCase().replace("PN", ""))){
                        
                        int numero = Character.getNumericValue(jugada.charAt(2));
                        
                        if (sudoku.usarPistaNumero(numero))
                            System.out.println("Se han destapado todos los números " + numero + " del tablero");                        
                    }
                    else
                        System.out.println("Auch! esa jugada no está permitida");
                }                    
                
                else
                    System.out.println("Auch! esa jugada no está permitida");
            }                
            
        } while (!jugada.equalsIgnoreCase("x") && !sudoku.checkResuelto());
        
        if (!jugada.equalsIgnoreCase("x"))
            Util.pintaGanador();
        
        System.out.println("Volvemos al menú principal");
        
    }
    
}
        
    /*
    // COLORES:
    public static final String REGULAR = "\033[0;30m";
    public static final String INTENSO = "\033[1;30m";
    public static final String OPACO = "\033[2;30m";
    public static final String FONDO = "\033[40m";

    // NO FUNCIONAN:
    public static final String NEGRITA_INTENSO = "\033[1;90m"; // --> funciona raro
    public static final String INTENSO = "\033[0;90m";
    public static final String SUBRAYADO = "\033[4;30m";
    public static final String FONDO_INTENSO = "\033[0;100m";
    */ 

        
    /* // PARA VER TODOS LOS COLORES 
    Sudoku sudoku = new Sudoku(true,2,2);
    for (int i = 0; i < 8; i++) {
        sudoku.setColorBase(i);
        System.out.println(sudoku);      
    }
    */      