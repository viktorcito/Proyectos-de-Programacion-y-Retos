
package es.daw.poo2.clonadoarraylistclase;

import es.daw.poo2.clonadoarraylistclase.model.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melola
 */
public class ClonadoArrayListClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //pruebasClonadoArrayListString();
        
        pruebasClonadoArrayListPersonas();
        
    }
    
    /**
     * Método para probar el clonado de un ArrayList de Personas (shallow and deep copy)
     */
    private static void pruebasClonadoArrayListPersonas(){
        // Personas será una colección que no quiero que se modifique
        ArrayList<Persona> personas = new ArrayList<>();
        
        Persona p1 = new Persona("Pepe",20);
        Persona p2 = new Persona("Juan",10);
        Persona p3 = new Persona("Paco",40);
        
        // Forma 1: cuidadín que devuelve un arraylist no modificable (iterator.remove no funciona)
        //personas = new ArrayList<>(Arrays.asList(p1,p2,p3));
        
        // Forma 2: añadiendo uno a uno objetos
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        
        System.out.println("*********************************");
        System.out.println("* Lista de personas original:");
        personas.forEach(System.out::println);
        System.out.println("*********************************");
        
        // Personas2 será una colección que ordenaré por distintos criterios 
        // para sacar diferentes informes...
        
        //ArrayList<Persona> personas2 = personas;  //esto no es una copia!!!!
        
        //ArrayList<Persona> personas2 = (ArrayList<Persona>)personas.clone(); // shallow clone
        
        //ArrayList<Persona> personas2 = deepCloneArtesanal(personas); // deep clone (forma 1)
        
        ArrayList<Persona> personas2 = deepClone(personas); // deep clone (forma 2)
        

        // Ordeno la segunda colección, como es un clonado no afectará a la primera colección
        Collections.sort(personas2);
        
        System.out.println("*******************************************");
        System.out.println("* Lista de personas ordenadas:");
        personas2.forEach(System.out::println);
        
        System.out.println("* Lista de personas original");
        personas.forEach(System.out::println);
        System.out.println("*******************************************");
        
        // Modifico el nombre de la persona2
        p2.setNombre("Juan MODIFICADO!!!!!!!");
        
        System.out.println("*******************************************");
        System.out.println("*********** UNA VEZ MODIFICADO JUAN *******");
        System.out.println("*******************************************");
        System.out.println("* Lista de personas clonada:");
        personas2.forEach(System.out::println);
        
        System.out.println("* Lista de personas original");
        personas.forEach(System.out::println);
        System.out.println("*******************************************");
        
    }

    /**
     * Este método clona de forma profunda un ArrayList de Personas
     * @param personasOriginal
     * @return ArrayList de personas clonadas y con cada objeto clonado (deep clone)
     * 
     */
    private static ArrayList<Persona> deepCloneArtesanal(ArrayList<Persona> personasOriginal){
        // PRIMERA FORMA: artesanal
        
        ArrayList<Persona> personasClonadas = new ArrayList<Persona>();
        
        for(Persona p: personasOriginal){
            personasClonadas.add(new Persona(p.getNombre(), p.getEdad()));
        }
        
        return personasClonadas;
    }

    /**
     * 
     * @param personasOriginal
     * @return 
     */
    private static ArrayList<Persona> deepClone(ArrayList<Persona> personasOriginal){
        
        ArrayList<Persona> personasClonadas = new ArrayList<Persona>();
        
        for(Persona p: personasOriginal){
            try {
                //personasClonadas.add(p.clone());
                personasClonadas.add((Persona)p.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(ClonadoArrayListClase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return personasClonadas;
    }
    
    /**
     * Método para probar el clonado de un ArrayList de String
     */
    private static void pruebasClonadoArrayListString(){
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres.add("Marta");
        nombres.add("Luis");
        nombres.add("Francisco");
        
        System.out.println("Lista de nombres 1:");
        System.out.println(nombres);
        
        ArrayList<String> nombres2 = (ArrayList<String>) nombres.clone();
        //ArrayList<String> nombres2 = nombres;
        
        System.out.println("Lista de nombres 2:");
        System.out.println(nombres2);
        
        Collections.sort(nombres2);
        
        System.out.println("Lista de nombres 2 ordenada:");
        System.out.println(nombres2);
        
        System.out.println("Lista de nombres 1:");
        System.out.println(nombres);
        
    }
    
}
