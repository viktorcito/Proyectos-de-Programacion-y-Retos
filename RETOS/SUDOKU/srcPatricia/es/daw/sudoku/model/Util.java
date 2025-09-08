/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.sudoku.model;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Patry
 */
public class Util {
    
    // Comprobar si un array contiene un integer dado:
        //if (Arrays.binarySearch(miArray, numero)>-1)

    static Random rnd = new Random();
    static Scanner sc = new Scanner(System.in);    
    
    // RESET COLORES
    public static final String RESET_COLOR = "\033[0m"; // También --> "\u001B[0m";
    
    // COLORES:
    static public String colorNormal;
    static final String[] misColores = {"Negro", "Rojo", "Verde", "Amarillo", "Azul", "Violeta", "Turquesa", "Blanco"};
    public static final String COLOR_NORMAL = "\033[0;30m";
    public static final String COLOR_INTENSO = "\033[1;30m";
    public static final String COLOR_OPACO = "\033[2;30m";
    public static final String COLOR_FONDO = "\033[40m";  
    
    
    // MÉTODOS
    public static boolean esNumerico(String s){
        String numeros = "0123456789";
        for (int i = 0; i < s.length(); i++) 
            if (!numeros.contains(Character.toString(s.charAt(i)))) return false;
        
        return true;
    }
    
    private static void esperaTecla(){
        System.out.println("\n\n\tPulsa ENTER para continuar...");
        String tecla;
        do{
           tecla  = sc.nextLine();            
        }
        while(!tecla.equals(""));       
    }
    
    public static int eligeColor(){
    
        StringBuilder sb = new StringBuilder(pintaTitulo());   
        for (int i = 0; i < misColores.length; i++) 
            sb.append(COLOR_NORMAL.replace("0m", i+"m")).append("\n\t\t").append(i+1).append(". ").append(misColores[i]).append(RESET_COLOR);

        sb.append("\n\t\t9. Aleatorio").append(RESET_COLOR);
        sb.append("\n\t---------------------------------");
        sb.append("\n\tElige una ocpión:");        
        
        
        sc = new Scanner(System.in);
        int color = -1;
        do {
            System.out.println(sb);
            if (sc.hasNextInt()) color = sc.nextInt() -1;
            else {
                sc = new Scanner(System.in);
                color = -1;
            }
            
            if (color == 8) color = rnd.nextInt(7);
            
            if (color >-1 && color < 8)
                colorNormal = COLOR_NORMAL.replace("0m", (color) + "m");

        } while (color < 0 || color > 7 );
        
        System.out.println("Color: " + misColores[color]);
        return color;
    }
    
    public static int eligeDificultad(){
                //if (titulo.length()==0) creaTitulo();
        StringBuilder sb = new StringBuilder(pintaTitulo());        
        sb.append("\n\t\t1. Facil (50-70 números");  
        sb.append("\n\t\t2. Normal (20-50 números)");  
        sb.append("\n\t\t3. Dificil (10-20 números");
        sb.append("\n\t\t4. Difuciultad aleatoria");
        //sb.append("\n\t\t5. Salir");
        sb.append("\n\t---------------------------------");
        sb.append("\n\tElige una ocpión:");
        
        int dificultad = -1;
        do {
            System.out.println(sb);
            if (sc.hasNextInt()) dificultad = sc.nextInt();
            else {
                sc = new Scanner(System.in);
                dificultad =-1;
            }
            
            if (dificultad == 4) dificultad = rnd.nextInt(3)+1;
        } while (dificultad < 1 || dificultad > 3);
        
        switch (dificultad){
            case 1:
                System.out.println("Dificultad: Fácil");
                break;
            case 2:
                System.out.println("Dificultad: Normal");
                break;
            default:
                System.out.println("Dificultad: Difícil");
        }
        
        return dificultad;        
    }
  
    
    /*********************************
     *      PINTADO DE  MENÚS        *
     *********************************/
    
    public static String pintaTitulo(){        
        StringBuilder titulo = new StringBuilder();
        titulo.append(colorNormal).append("\n\t********************************").append(RESET_COLOR);
        //titulo.append(colorNormal).append("\n\t*                               *").append(RESETEAR);
        titulo.append(colorNormal).append("\n\t*      SUDOKU SUPER MOLÓN      *").append(RESET_COLOR);
        titulo.append(colorNormal).append("\n\t*        ").append("\u001B[30;1m").append("- by Patricia -").append(RESET_COLOR).append(colorNormal).append("       *").append(RESET_COLOR);
        //titulo.append(colorNormal).append("\n\t*                               *").append(RESETEAR);
        titulo.append(colorNormal).append("\n\t********************************").append(RESET_COLOR);          
        
        return titulo.toString();
    }    
       
    public static String creaMenu(){
        //if (titulo.length()==0) creaTitulo();
        StringBuilder sb = new StringBuilder(pintaTitulo());        
        sb.append("\n\t\t1. Bienvenida");  
        sb.append("\n\t\t2. Instrucciones");  
        sb.append("\n\t\t3. Elegir color");
        sb.append("\n\t\t4. Elegir dificultad");
        sb.append("\n\t\t5. Sudoku tradicional");
        sb.append("\n\t\t6. Sudoku Super Molón");
        sb.append("\n\t\t7. Salir");
        sb.append("\n\t---------------------------------");
        sb.append("\n\tElige una ocpión:");
        return sb.toString();
    }
    
    public static void pintaBienvenida(){
        sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(pintaTitulo());      
        sb.append(colorNormal).append("\n\n\t1. BIENVENIDA").append(RESET_COLOR);
        sb.append(colorNormal).append("\n\t-----------------").append(RESET_COLOR);
        sb.append("\n\tBienvenid@ al Sudoku Super Molón: ");
        sb.append("\n\n\tJugar un sudoku por consola puede ser muy pesado");
        sb.append("\n\t(y aún más si tienes que probar 30 ¡menudo coñazo!)");
        sb.append("\n\tasí que éste se ha diseñado pensado en que sea ágil y");
        sb.append("\n\tdivertido, para lo cual, además de poder jugar al sudoku");
        sb.append("\n\t").append(colorNormal).append("Tradicional").append(RESET_COLOR).append(" (en el que puede haber varias soluciones),");
        sb.append("\n\ttienes el Sudoku ").append(colorNormal).append("'Súper Molón'").append(RESET_COLOR).append(", que tiene una única solución");
        sb.append("\n\tpero que cuenta con 'pistas' que podrás usar cuando quieras.");
        sb.append("\n\tAdemás, en ambos modos de juego puedes activar o desactivar");
        sb.append("\n\tque se muestren los números que hayas puesto mal (si los hay).");
        sb.append("\n\tAntes de empezar asegúrate de entender las instrucciones, y,");
        sb.append("\n\tsobre todo... ").append(colorNormal).append("¡¡¡¡ NO OLVIDES DIVERTIRTE !!!!").append(RESET_COLOR).append("");

        System.out.println(sb);   
        
        esperaTecla();
       
    }    
      
    public static void pintaInstrucciones(){
        sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(pintaTitulo());      
        sb.append(colorNormal).append("\n\n\t2. INSTRUCCIONES").append(RESET_COLOR);
        sb.append(colorNormal).append("\n\t-----------------").append(RESET_COLOR);        
        sb.append("\n\tExisten 2 ").append(colorNormal).append("MODOS").append(RESET_COLOR).append(" de juego: ");
        sb.append("\n\t  - Modo normal: todo depende de ti; sin pistas (salvo PE)");
        sb.append("\n\t  - Modo Super Molón: puedes utilizar todas las pistas");
        sb.append("\n\n\t¿Cómo puedo ").append(colorNormal).append("PONER").append(RESET_COLOR).append(" un número en una casilla?");
        sb.append("\n\t  - Poniendo 3 números seguidos: fila, columna y el nº a poner");
        sb.append("\n\n\t¿Y si quiero ").append(colorNormal).append("ELIMINAR").append(RESET_COLOR).append(" un número que he puesto?");
        sb.append("\n\t  - Poniendo 3 números (él último un cero): fila, columna y 0");
        sb.append("\n\n\t¿Qué ").append(colorNormal).append("PISTAS").append(RESET_COLOR).append(" puedo usar?");
        sb.append("\n\t  - PE (Pista Errores): activa/desactiva mostrar los nº mal colocados");
        sb.append("\n\t  - PC (Pista Casilla): muestra el nº que hay en la casilla que indiques");
        sb.append("\n\t  - PS (Pista Sector): muestra un nº aleatorio en el sector que indiques");
        sb.append("\n\t  - PN (Pista Número): muestra donde está el nº indicado en todo el tablero");
        sb.append("\n\t  - PR (Pista Resolver): muestra el tablero resuelto y finaliza el juego");
        sb.append("\n\n\tAquí tienes varios ").append(colorNormal).append("EJEMPLOS").append(RESET_COLOR).append(" de lo que puedes hacer:");
        sb.append("\n\t  - 375  : pone un 5 en la casilla 3x7 (fila 3, columna 7)");
        sb.append("\n\t  - 370  : elimina el número de la casilla 3x7 (salvo si es fijo)");
        sb.append("\n\t  - PE   : alterna entre mostar o no los nº incorrectos");
        sb.append("\n\t  - PC25 : muestra el nº que hay en la casilla 2x5");
        sb.append("\n\t  - PS23 : muestra un nº al azar del sector 2x3 (hoizontal 2 x vertical 3)");
        sb.append("\n\t  - PN5  : muestra todos los nº 5 del tablero");
        sb.append("\n\t  - PR   : resuelve el sudoku y finaliza el juego");
        
        System.out.println(sb);   
        
        esperaTecla();
    }
    
    public static void pintaGanador(){
        StringBuilder ganador = new StringBuilder();
        ganador.append(colorNormal).append("\n\t*********************************").append(RESET_COLOR);
        ganador.append(colorNormal).append("\n\t*      ¡¡¡ ENHORABUENA !!!      *").append(RESET_COLOR);
        ganador.append(colorNormal).append("\n\t*     ").append("\u001B[30;1m").append("Has resuelto el Sudoku").append(RESET_COLOR).append(colorNormal).append("    *").append(RESET_COLOR);
        ganador.append(colorNormal).append("\n\t*********************************").append(RESET_COLOR);          
        
        System.out.println(ganador);   
        
        esperaTecla();
    }
    
    public static String pintaFin(){
        StringBuilder titulo = new StringBuilder();
        titulo.append(colorNormal).append("\n\t*********************************").append(RESET_COLOR);
        //titulo.append(colorNormal).append("\n\t*                               *").append(RESETEAR);
        titulo.append(colorNormal).append("\n\t*      ¡¡¡ HASTA PRONTO !!!     *").append(RESET_COLOR);
        titulo.append(colorNormal).append("\n\t*        ").append("\u001B[30;1m").append("Gracias por jugar").append(RESET_COLOR).append(colorNormal).append("      *").append(RESET_COLOR);
        //titulo.append(colorNormal).append("\n\t*                               *").append(RESETEAR);
        titulo.append(colorNormal).append("\n\t*********************************").append(RESET_COLOR).append("\n\n");          
        
        return titulo.toString();
    }
}
