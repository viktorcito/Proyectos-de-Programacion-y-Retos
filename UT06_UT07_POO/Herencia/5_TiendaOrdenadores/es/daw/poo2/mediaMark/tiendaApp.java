/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Herencia/5_TiendaOrdenadores#tienda-de-ordenadores
 */
package es.daw.poo2.mediaMark;

import es.daw.poo2.mediaMark.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author melola
 */
public class tiendaApp {

    static ArrayList<Ordenador> listaOrdenadores;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        listaOrdenadores = new ArrayList<>();

        listaOrdenadores.add(new Portatil(1.5f, "HP_laptop_01", 800));
        listaOrdenadores.add(new Desktop("torre compacta", "DELL_desk_01", 1100));
        listaOrdenadores.add(new Portatil(1.2f, "HP_laptop_02", 1200));
        listaOrdenadores.add(new Desktop("torre gamer", "DELL_desk_02", 1100));

        printList();
        
        //printListByNaturalOrder();
        
        //printListByPrice();
        
        deleteByCode("HP");
        
        System.out.println("**** Después de borrar....");
        printList();

    }

    /**
     * Método que pinta por consola los objetos de la lista de ordenadores. Se
     * hacen uso de diferentes formas para recorrer el ArrayList
     */
    public static void printList() {
        System.out.println("\n******* LISTADO DE ORDENADORES **********");
        /*
        System.out.println("******* listado tradicional ******");
        // tradicional
        for (int i = 0; i < listaOrdenadores.size(); i++) {
            System.out.println(listaOrdenadores.get(i));
        }

        System.out.println("******* listado for each ******");
        // for each
        for (Ordenador o : listaOrdenadores) {
            System.out.println(o);
        }

        System.out.println("******* listado lambda ******");
        // lambda
        listaOrdenadores.forEach(o -> System.out.println(o));

        */
        //System.out.println("******* listado (referencia a métodos) ******");
        // referencia a métodos
        listaOrdenadores.forEach(System.out::println);

    }
    
    /**
     * Método que pinta los ordenadores ordenador por el método natural (código)
     */
    private static void printListByNaturalOrder(){
        // Forma 1: Ordenación natural usando Collections
        //Collections.sort(listaOrdenadores);
        
        // Forma 2: Ordenación natural usando el método sort del ArrayList
        listaOrdenadores.sort(Comparator.naturalOrder());
        
        System.out.println("\n**** Listado de ordenadores ordenados de forma natural (código) *****");
        listaOrdenadores.forEach(System.out::println);
    }
    
    /**
     * Método que pinta los ordenadores ordenados por precio
     */
    private static void printListByPrice(){
        
        listaOrdenadores.sort((o1,o2) -> Float.compare(o1.getPrecio(), o2.getPrecio()));
        
        System.out.println("\n **** Listado de ordenador por precio: ");
        listaOrdenadores.forEach(System.out::println);
        
    }
    
    /**
     * Método que borra los ordenadores que tengan en su código la cadena HP
     */
    private static void deleteByCode(String code){
        
        /*
        // KAKA
        for(Ordenador o: listaOrdenadores){
            if (o.getCodigo().contains(code))
                listaOrdenadores.remove(o);
        }
        */
        
        Iterator<Ordenador> it = listaOrdenadores.iterator();
        
        while(it.hasNext()){
            Ordenador o = it.next();
            if (o.getCodigo().contains(code))
                it.remove();
        }
        
        
    }
    
}
