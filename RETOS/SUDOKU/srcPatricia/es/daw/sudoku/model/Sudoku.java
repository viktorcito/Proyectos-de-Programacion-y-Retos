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
public class Sudoku {
    private boolean modoSuperMolon;
    private boolean PE = false; //Ver Pista Errores 
    private boolean VO = false; //Ver Original o ver tablero jugador
    private int dificultad;
    private int[][] tablero;
    private int[][] tabJugador;
    private String numerosFijos;
    private int colorBase;
    private int brillo;
    private String colorNormal;
    private String colorOpaco;
    private String colorIntenso;

    
    // CONSTRUCTOR    
    public Sudoku(boolean modoSuperMolon, int dificultad, int colorBase, int brillo) {        
        this.modoSuperMolon = modoSuperMolon;        
        this.dificultad = dificultad;
        this.brillo = Math.min(Math.max(0, brillo),2);
        setColorBase(colorBase);
        crearSudokuAleatorio();
        ponerNumerosFijos();
    }

    //SETTER Y GETTERS
    public int[][] getTablero() {
        return tablero;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void setPE(boolean PE) {
        this.PE = PE;
    }

    public boolean isPE() {
        return PE;
    }

    public void setVO(boolean VO) {
        this.VO = VO;
    }

    public boolean isVO() {
        return VO;
    }

    public boolean isModoSuperMolon() {
        return modoSuperMolon;
    }

    public void setColorBase(int colorBase) {
        this.colorBase = colorBase;
        colorNormal = "\033[" + brillo +";3" + colorBase +"m";
        colorIntenso = "\033[4" + colorBase +"m";
        colorOpaco = "\033[0;37m";   
    }
    
    public int cambiarBrillo() {
        brillo++;
        if(brillo > 2)brillo = 0;        
        setColorBase(colorBase);
        return brillo;
    }
    
    //MÉTODOS       
    public int[][] crearSudokuAleatorio(){        
        tablero = new int[9][9];
        Random rnd = new Random();                
        String disponibles;
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {                                
                
                disponibles = checkDisponibles(i,j);
                
                if (disponibles.length() > 0){                        
                    int ale = rnd.nextInt(disponibles.length());
                    tablero[i][j] = Character.getNumericValue(disponibles.charAt(ale));
                }else{ //Sin solucion
                    //Arrays.fill(tablero, 0); //¿POR QUÉ DA ERROR ESTA INSTRUCCIÓN ?
                    tablero = new int[tablero.length][tablero.length];                    
                    i = -1; 
                    break;
                }
            }            
        }
        
        return tablero;
    }
    
    private String checkDisponibles(int x, int y){
        String disponibles = "123456789";

        //Eliminamos de los nºs ya usados en la fila o la columna de la casilla actual
        for (int i = 0; i < tablero.length; i++) {            
            disponibles = disponibles.replace(String.valueOf(tablero[x][i]), "");
            disponibles = disponibles.replace(String.valueOf(tablero[i][y]), "");
        }
        
        //Eliminamos los nº ya usados en el sector de la casilla actual
        int iniX = (x/3)*3;
        int iniY = (y/3)*3;
        for (int i = iniX; i < iniX + 3; i++) {
            for (int j = iniY; j < iniY + 3; j++) {
                disponibles = disponibles.replace(String.valueOf(tablero[i][j]), "");
            }
        }
        return disponibles;
    }
    
    private void ponerNumerosFijos(){
        
        Random rnd = new Random();
        int casilla; //Almacena fila y columna en formato FC (ej: 25 = fila 2 columna 5)                        
        int nFijos;
        
        switch (dificultad){
            case 1: //FACIL
                nFijos = rnd.nextInt(71-50) + 50;
                break;
            
            case 2: //NORMAL
                nFijos = rnd.nextInt(51-20) + 20;
                break;
            
            default://DIFICIL
                nFijos = rnd.nextInt(21-10) + 10;
        }
        //System.out.println("Fijos: " + nFijos);
        numerosFijos = "";
        do {
            casilla = rnd.nextInt(100 - 11) + 11;
            if (casilla % 10 != 0 && !numerosFijos.contains(casilla + ",")) numerosFijos += casilla + ",";
            
        } while (numerosFijos.length() < (nFijos * 3));        
        
        crearTableroJugador();
    }
    
    private void crearTableroJugador(){
        // Creamos un clon del sudoku para el jugador
       tabJugador = new int[tablero.length][tablero.length];
        for (int i = 0; i < tablero.length; i++)
            tabJugador[i] = tablero[i].clone();
        
        // Ponemos a 0 las casillas que no son fijas
        for (int i = 0; i < tablero.length; i++) 
            for (int j = 0; j < tablero.length; j++) 
                if (!numerosFijos.contains((i+1) + "" + (j+1) + ","))
                    tabJugador[i][j] = 0;
      
    }
    
    public void actualizarCasilla(int x, int y, int numero){
        
        if (x < 1 || x > 9 || y < 1 || y > 9 )
            System.out.println("La casilla " + x + "x" + y + " no existe");
        
        else if (numerosFijos.contains(x + "" + y + ","))
            System.out.println("La casilla " + x + "x" + y + " no se puede cambiar");
        
        else{
            tabJugador[x-1][y-1] = numero;
            System.out.println("Se ha actualizado la casilla " + x + "x" + y);
        }        
    }
    
    /**
     * Comprueba si el nº de una casilla determinada cumple las normas de sudoku
     * Si no hay conflictos devuelve true, sino false.
     */
    private boolean checkCasilla(int x, int y){        
        
        int numero = tabJugador[x][y];
        
        // Comprobamos la fila y la columna
        for (int i = 0; i < tabJugador.length; i++) {
            if (i != y && tabJugador[x][i] == numero) return false;
            if (i != x && tabJugador[i][y] == numero) return false;
        }
        
        // Comprobamos el sector
        int iniX = (x/3)*3;
        int iniY = (y/3)*3;     
        
        for (int i = iniX; i < iniX + 3; i++) {
            for (int j = iniY; j < iniY + 3; j++) {
                if (i==x && j == y ) continue;
                if (tabJugador[i][j] == numero) return false;
            }
        }        
        return true;
    }
    
    public boolean checkResuelto(){
        for (int i = 0; i < tabJugador.length; i++) {
            for (int j = 0; j < tabJugador.length; j++) {
                if (tabJugador[i][j] == 0) return false;
                if (!checkCasilla(i, j)) return false;
            }            
        }
        return true;
    }
    
    public boolean usarPistaCasilla(int x, int y){
       
        if(!modoSuperMolon) return false; //Redundante
        
        tabJugador[x][y] = tablero[x][y];
        
        return true;
    }
    
    public boolean usarPistaSector(int x, int y){
        
        if(!modoSuperMolon) return false; //Redundante
        
        if (x < 0 || x > 2 || y < 0 || y > 2){            
            System.out.println("El sector " + (x+1) + "x" + (y+1) +" no existe");
            return false;        
        }
        
        // Ver cual es la 1ª casilla del sector
        int iniX = x*3;
        int iniY = y*3;
        
        // Ver qué casillas faltan por descubrir        
        String ocultas = "";
        for (int i = iniX; i < iniX + 3; i++) {
            for (int j = iniY; j < iniY + 3; j++) {                
                if (tabJugador[i][j] == 0 && !ocultas.contains(i+""+j+";")) ocultas += i+""+j+";";
            }
        }    
        
        // Sacar un aleatorio entre las que están tapadas
        if(ocultas.length() > 0 ){
            String[] casillas = ocultas.split(";");
            
            Random rnd = new Random();
            int aleatorio = rnd.nextInt(casillas.length);
            
            int posX = Character.getNumericValue(casillas[aleatorio].charAt(0));
            int posY = Character.getNumericValue(casillas[aleatorio].charAt(1));
            
            // Destapar la casilla
            tabJugador[posX][posY] = tablero[posX][posY];           
        }
        else{
            System.out.println("No hay casillas ocultas en el sector " + (x+1) + "x" + (y+1));
            return false;
        }           

        return true;
    }
    
    public boolean usarPistaNumero(int numero){
        
        if (!modoSuperMolon) return false; //Redundante
        
        if (numero < 1 || numero > 9){
            System.out.println("El tablero sólo puede tener números de 1 a 9");
            return false;
        }
        
        for (int i = 0; i < tablero.length; i++) 
            for (int j = 0; j < tablero.length; j++) 
                if (tablero[i][j] == numero)
                    tabJugador[i][j] = tablero[i][j];            

        return true;
    }
    
    public boolean usarPistaResolver(){
        if(!modoSuperMolon) return false; //Redundante
        
        for (int i = 0; i < tablero.length; i++) 
            //¿MÁS CORRECTO?: --> System.arraycopy(tablero[i], 0, tabJugador[i], 0, tablero.length);
            for (int j = 0; j < tablero.length; j++) 
                tabJugador[i][j] = tablero[i][j];
        
        return true;
    }

    @Override
    public String toString() {
        String resetColor = "\u001B[0m";
        if(colorNormal == null) colorNormal = "\u001B[36m";
        if (colorOpaco == null) colorOpaco ="\u001B[30;1m"; //GRIS
        
        // PLANTILLAS:
        String Separador = colorNormal +  "|" + resetColor; // Principales
        String Separador2 = colorOpaco + "¦" + resetColor; // Interiores
        String linea = colorOpaco + "-----------" + resetColor;
        String lineaSeparador = "\t  " + Separador + linea + colorNormal + "|" + resetColor + linea + colorNormal + "|" + resetColor + linea + Separador;
        String lineaSector = "\t" + colorNormal + "  +-----------+-----------+-----------+" + resetColor;        
        
        // ENCABEZADO:
        String titulo = Util.pintaTitulo().replace("\n\t", "\n\t    ");
        if (!modoSuperMolon) titulo = titulo.replace("SUPER MOLÓN", "TRADICIONAL");
        titulo += "\n\t\tDificultad: " + ((dificultad == 1)? "Facil":(dificultad == 2)?"Normal":"Difícil") + " (" + numerosFijos.length()/3 + ")";
        titulo += "\n\t\tPistas: " + ((!modoSuperMolon)?"PE ("+ ((PE)?"A":"D") + ")":"PE (" + ((PE)?"A":"D") + "), PC, PS, PN, PR") + "\n";
            
        // TABLERO:
        StringBuilder sbTablero = new StringBuilder(titulo);
        sbTablero.append("\n\t").append(colorNormal).append("    1   2   3   4   5   6   7   8   9\n").append(resetColor);
        
        for (int i = 0; i < 9; i++) { //Filas
            
            if (i % 3 == 0) sbTablero.append(lineaSector);
            else sbTablero.append(lineaSeparador);
            
            sbTablero.append("\n\t").append(colorNormal).append(i + 1).append(" ").append(resetColor);
            
            for (int j = 0; j < 9; j++) { // Columnas
                if (j % 3 == 0) sbTablero.append(Separador).append(coloreaNumero(i,j));
                else sbTablero.append(Separador2).append(coloreaNumero( i,j));
            }        
            
            sbTablero.append(Separador);
            if (i== 1 || i == 4 || i == 7) sbTablero.append(colorNormal).append(" Sector ").append((i/3)+1);
            sbTablero.append("\n").append(resetColor);
        }
        sbTablero.append(lineaSector);   
        sbTablero.append(colorNormal).append("\n\t     Sector 1    Sector 2    Sector 3").append(resetColor);        
        
        //Esta funcionalidad es sólo para facilitar el diseño, no debería de estar en fase producción
        sbTablero.append("\n\n[TOP SECRET] alterna vistas con 'vo' -->  Tablero actual: Vista ").append((VO)?"Original":"Jugador");
        return sbTablero.toString();
    }
    
     private String coloreaNumero(int x, int y){       
        
        String resetColor = "\u001B[0m";
        String numColoreado;
        
        //Comprobamos qué vista de tablero estamos usando: Vista Original o Jugador
        if (VO)
            numColoreado = " " + Integer.toString(tablero[x][y]) + " ";
        
        else // En vista jugador ocultamos los 0 mostrando un espacio
            if (tabJugador[x][y] == 0) numColoreado = "   ";
            else numColoreado = " " + Integer.toString(tabJugador[x][y]) + " ";
        
        //Pintamos las casillas fijas:
        if (numerosFijos.contains((x+1) + "" + (y+1) + ",")){
            if (colorBase==0)
                numColoreado = "\033[2;37;47m" + numColoreado + resetColor;
            else if (colorBase == 7)
                numColoreado = "\033[2;30;47m" + numColoreado + resetColor;
            else
                numColoreado = colorIntenso + numColoreado +  resetColor;
            
            if(colorBase == 1 || colorBase == 4 || colorBase == 5)
                numColoreado = "\033[1;37m" + numColoreado;
        }
        else{             
            // En las demás casillas hay que ver si debemos mostrar los fallos y cómo
            if (tabJugador[x][y] != 0 && PE){ //Si está activada la Pista Errores (mostrar fallos)
                String colorErrores = (colorBase == 1)?"\033[43m":"\033[1;37;41m"; //Otros posibles colores --> "\033[0;37;41m":"\033[2;31;43m"
                
                //En el modo Super Molón la única solución es la del tablero original
                if(modoSuperMolon && tablero[x][y] != tabJugador[x][y])
                    numColoreado = colorErrores + numColoreado +  resetColor;
                
                //En el modo Tradicional debemos comprobar si se cumplen las normas de sudokus
                else if (!modoSuperMolon && !checkCasilla(x, y))
                    numColoreado = colorErrores + numColoreado +  resetColor;
            }                
        }
        
        return numColoreado;        

    }    
   
}
