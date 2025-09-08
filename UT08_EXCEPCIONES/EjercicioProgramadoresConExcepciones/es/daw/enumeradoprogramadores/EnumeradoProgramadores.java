/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Enumerados
 * 
 */
package es.daw.enumeradoprogramadores;

import es.daw.enumeradoprogramadores.dao.ProgramadorDAO;
import es.daw.enumeradoprogramadores.exceptions.LimiteEdadException;
import es.daw.enumeradoprogramadores.model.*;
import es.daw.enumeradoprogramadores.util.Utilidades;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melol
 */
public class EnumeradoProgramadores {

    public static Scanner sc = new Scanner(System.in);
    
    // Si lo usara a nivel general
    //ArrayList<Programador> programadores = new ArrayList<>();
    
    // Colección de excepciones
    public static ArrayList<LimiteEdadException> excepciones = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 1. Cargo la colección de programadores
        ArrayList<Programador> programadores = new ArrayList<>();
        
        ProgramadorDAO dao = new ProgramadorDAO();
        programadores = dao.select();
        
        // 2. Muestro el menú en bucle hasta que elija la opción de Salir
        boolean salir = false;
        
        do{
            System.out.println("");
            Utilidades.pintaMenu();
            
            int opt=0; //salir por defecto
            
            if (sc.hasNextInt())
                opt = sc.nextInt();
            
            sc.nextLine();
            
            switch(opt){
                case 1:
                {
                    try {
                        // Dar de alta
                        Utilidades.darProgramadorAlta(programadores);
                    } catch (LimiteEdadException ex) {
                        ex.getMessage();
                        ex.printStackTrace();
                        excepciones.add(ex);
                    }
                }
                    break;

                case 2:
                    // Consultar información por DNI
                    System.out.println(Utilidades.consultarProgramadorById(programadores));
                    break;
                case 3:
                    // Consultar información de todos los programadores
                    System.out.println("* Información de todos los programadores:");
                    programadores.forEach(System.out::println);
                    break;
                case 4:
                    // Eliminar un programador de la lista por DNI
                    Utilidades.eliminarProgramadorById(programadores);
                    break;
                case 5:
                    // Obtener el número total de programadores expertos en un lenguaje concreto
                    System.out.println("Elige una opción:");
                    Lenguajes lenguaje = Utilidades.getListadoLenguajes();
                    int total = Utilidades.getNumProgsExpByLeng(programadores,lenguaje);
                    System.out.println("El número total de programadores expertos en "+lenguaje.name()+" son: "+total);
                    break;
                case 6:
                    System.out.println("En obras....");
                    break;
                case 7:
                    System.out.println("** Informe de juniors!!!!!!!!!!!******");
                    //excepciones.sort((e1,e2) -> Integer.compare(e1.getEdad(), e2.getEdad()));
                    //excepciones.sort(Comparator.naturalOrder());
                    Collections.sort(excepciones);
                    excepciones.forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Vas a salir del programa!");
                    sc.nextLine();
                    salir = true;
                    break;
                
                    
                default:
                    System.out.println("Elige una opción correcta del menú");
                
            }
            
        }while(!salir);
        
    }
    
    
}
