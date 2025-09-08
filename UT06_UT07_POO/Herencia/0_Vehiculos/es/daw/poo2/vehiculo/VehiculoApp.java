/**
 * https://java.codeandcoke.com/apuntes:objetos
 */
package es.daw.poo2.vehiculo;

import es.daw.poo2.vehiculo.model.*;

/**
 * 
 * @author melola
 */
public class VehiculoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Coche coche1 = new Coche("BBV4567");
        System.out.println(coche1);
        
        Coche coche2 = new Coche(5, 100, "KKK6666", "Seat", "Ibiza", 1.900f, 10000);
        System.out.println(coche2);
        
        Coche coche3 = new Coche("BBV4567");
        
        Moto moto1 = new Moto("XXX1234");
        System.out.println(moto1);
        
        Moto moto2 = new Moto("BBV4567");
        
        /*       
        if(coche1.equals(coche3))
            System.out.println("iguales!!!");
        else
            System.out.println("distintos!!!");
        */
        
        System.out.println(coche1.equals(moto2)? "iguales!!!":"distintos!!!");
        
    }
    
}
