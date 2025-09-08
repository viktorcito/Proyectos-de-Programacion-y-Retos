package es.daw.enumeradoprogramadores.dao;

import es.daw.enumeradoprogramadores.model.Lenguajes;
import es.daw.enumeradoprogramadores.model.Programador;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class ProgramadorDAO {
    
    private final ArrayList<Programador> programadores;

    
    public ProgramadorDAO(){
        programadores = new ArrayList<>();
        // AÑADIENDO PROGRAMADORES....
        /* dni, nombre, edad, lenguajeProgramación, años de experiencia*/
        programadores.add(new Programador("12121212R","Fernando", 23, Lenguajes.JAVA, 4));
        programadores.add(new Programador("12121212L","Ruth", 40, Lenguajes.PYTHON, 7));
        programadores.add(new Programador("12121212Q","Alberto", 27, Lenguajes.PHP, 1));
        programadores.add(new Programador("12121212J","Sergio", 30, Lenguajes.PYTHON, 3));
        programadores.add(new Programador("12121212T","Ana", 31, Lenguajes.PYTHON, 5));
        
        
        
    }
    
    public ArrayList<Programador> select(){
        //return (ArrayList<Programador>) programadores.clone();
        return new ArrayList<Programador> (programadores);
    }      
    
}
