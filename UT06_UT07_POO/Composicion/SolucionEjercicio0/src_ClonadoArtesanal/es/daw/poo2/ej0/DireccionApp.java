/*
 * https://www.arquitecturajava.com/java-composicion-y-la-reutilizacion-del-codigo/
 */
package es.daw.poo2.ej0;

import es.daw.poo2.ej0.model.Persona;
import es.daw.poo2.ej0.model.Empresa;
import es.daw.poo2.ej0.model.Direccion;

/**
 *
 * @author melola
 */
public class DireccionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Direccion d1 = new Direccion("calle A", 3);
        Direccion d2 = new Direccion("calle B", 7);
        
        Persona p = new Persona("pepe", 20);
        p.setDirección(d1);
        
        Empresa e = new Empresa();
        e.setCif("1A");
        e.setDirección(d2);

//        System.out.println("Pinto las calles");
//        System.out.println(p.getDirección().getCalle());
//        System.out.println(e.getDirección().getCalle());
 
        System.out.println("***** 1 *****");
        System.out.println(p);
        System.out.println(e);
        
        //Modifico la dirección 1 (no en la persona)
        System.out.println("Modificada la dirección de persona a Rue del Percebe");
        d1.setCalle("Calle Rue del Percebe");
        
//        System.out.println("Pinto de nuevo las calles");
//        System.out.println(p.getDirección().getCalle());
//        System.out.println(e.getDirección().getCalle());
        
        System.out.println("***** 2 *****");
        System.out.println(p);
        System.out.println(e);
        
        

    }
    
    

}
