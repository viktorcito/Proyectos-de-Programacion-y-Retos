/*
 * Ejemplos vistos en clase (no es un ejercicio)
 */
package es.daw.arraylistonfire;

import es.daw.arraylistonfire.model.ComparatorByName;
import es.daw.arraylistonfire.model.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author melola
 */
public class ArrayListApp {

    static List<Persona> listPersonas;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // MÉTODO CON TODAS LAS PRUEBAS DE UN ARRAYLIST DE ENTEROS
        //testListInteger();
        
        
        // MÉTODO CON TODAS LAS PRUEBAS DE UN ARRAYLIST DE PERSONAS
        testListPersonas();
        
        
    }
    
    
    private static void testListPersonas(){
        System.out.println("***************************************************");
        System.out.println("**EJEMPLOS DE ORDENACIÓN DE ARRAYLIST DE PERSONAS *");
        System.out.println("***************************************************");

        listPersonas = new ArrayList<>();
        
        //Persona p1 = new Persona("Pepe",28);
        Persona p1 = new Persona("Pepe",20);
        //Persona p2 = new Persona("Juan",32);
        Persona p2 = new Persona("Juan",20);
        Persona p3 = new Persona("Paco",40);
        Persona p4 = new Persona("Lola",21);
        Persona p6 = new Persona("Lola",20);
        Persona p7 = new Persona("Lola",22);
        Persona p5 = new Persona("Susi",24);
        Persona p8 = new Persona("Susi",25);
        Persona p9 = new Persona("Susi",26);
        
        //listPersonas.add(p1);
        //listPersonas.add(p2);
        // .....
        
        // Unsupportted exception al borrar
        //listPersonas = Arrays.asList(p1,p2,p3,p4,p5, p6, p7,p8,p9);
        
        listPersonas = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5, p6, p7,p8,p9));
        
        
        System.out.println("* Lista de personas no ordenada:");
        
        //listPersonas.forEach( p -> System.out.println(p));
        
        for (int i = 0; i < listPersonas.size(); i++) {
            System.out.println(listPersonas.get(i));
        }
        
        System.out.println("* Lista de personas inversa:");
        Collections.reverse(listPersonas);
        
        listPersonas.forEach(System.out::println);
        
        /*System.out.println("* Lista de personas ordenada por defecto (ascendente):");
        //Forma 1
        System.out.println("\tForma 1: con Collections.sort");
        // Da error si se quiere ordenar una lista de objetos que no tengan implementado la interface
        // Comparable (criterio natural de ordenación) o si no se usa la inteface Comparator (otros criterios)
        Collections.sort(listPersonas);
        listPersonas.forEach(System.out::println);        
        
        //Forma 2
        System.out.println("\tForma 2 con sort del ArrayList");
        listPersonas.sort(Comparator.naturalOrder());
        listPersonas.forEach(System.out::println);        
        
        System.out.println("* Lista de personas ordenada descendente:");
        //Forma 1
        System.out.println("\tForma 1: con Collections.sort");
        Collections.sort(listPersonas, Comparator.reverseOrder());
        listPersonas.forEach(System.out::println);
        
        //Forma 2
        System.out.println("\tForma 2 con sort del ArrayList");
        listPersonas.sort(Comparator.reverseOrder());
        listPersonas.forEach(System.out::println);*/
        
        // --------------- USANDO COMPARATOR PARA AÑADIR NUEVO MÉTODOS DE ORDENACIÓN ----------------
        //System.out.println("********** LISTADO DE PERSONAS ORDENADAS POR NOMBRE **********");
        
        // Forma 1: creando la clase que implementa la interface Comparator
        /*ComparatorByName cbyName = new ComparatorByName();
        listPersonas.sort(cbyName);
        listPersonas.forEach(System.out::println);*/
        
        // Forma 2: con Collections sort
        /*Collections.sort(listPersonas, cbyName);
        listPersonas.forEach(System.out::println);*/
        
        // Forma 3: con clase anónima
        /*Collections.sort(listPersonas, new Comparator<Persona>(){
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });
        listPersonas.forEach(System.out::println);*/
        
        // Forma 4: Con programación funcional
        //Comparator<Persona> comparatorByName = (pa,pb) -> pa.getNombre().compareTo(pb.getNombre());
        //listPersonas.sort(comparatorByName);
        
        /*listPersonas.sort((pa,pb) -> pa.getNombre().compareTo(pb.getNombre()));
        listPersonas.forEach(System.out::println);*/
        
        //System.out.println("************* Y ESTO???????????? **************");
        // API stream() JAVA .... PROXIMAMENTE!!!!!!!!!!!
        //listPersonas.stream().sorted().forEach(System.out::println);
        
        /*System.out.println("********** LISTADO DE PERSONAS ORDENADAS POR NOMBRE Y EDAD DESCENDENTE **********");
        Comparator<Persona> comparatorByName = (pa,pb) -> pa.getNombre().compareTo(pb.getNombre());
        //Comparator<Persona> comparatorByName2 = Comparator.comparing(p -> p.getNombre());
        listPersonas.sort(comparatorByName.thenComparing(Comparator.naturalOrder()));
        
        listPersonas.forEach(System.out::println);
        */
        
        
        // -----------------------------
        // EN OBSERVACIÓN....
        /*System.out.println("********** LISTADO DE PERSONAS ORDENADAS POR EDAD DESCENDENTE Y LUEGO NOMBRE **********");
        Comparator<Persona> comparatorByName3 = (pa,pb) -> pa.getNombre().compareTo(pb.getNombre());
        Comparator<Persona> comparatorByEdad = (pa,pb) -> Integer.valueOf(pa.getEdad()).compareTo(Integer.valueOf(pb.getEdad()));
        listPersonas.sort(comparatorByEdad.thenComparing(comparatorByName3));
        listPersonas.forEach(System.out::println);
        
        
        // No me deja enlazar el thenComparing después de la ordenación natural
        Comparator.naturalOrder().thenComparing(comparatorByName3);
        Comparator.naturalOrder().thenComparing(Comparator.reverseOrder());
        
        comparatorByName3.thenComparing(Comparator.naturalOrder());*/
        // -----------------------------
        
        
        // BORRADO DE ELEMENTOS MIENTRAS RECORRO LA LISTA
        borraPersonasConEdadPar();
        
        System.out.println("********** LISTADO DE PERSONAS DESPUÉS DE BORRAR LAS QUE TIENEN EDAD PAR ********************");
        listPersonas.forEach(System.out::println);
        
        
    }
    /**
     * 
     */
    private static void borraPersonasConEdadPar(){
        
        
        // Esto da excepción!!! CASCA!!!!!! NO PUEDO RECORRER Y BORRAR A LA VEZ UN ARRAYLIST
        // java.util.ConcurrentModificationException
        /*for(Persona p: listPersonas){
            if (p.getEdad() % 2 == 0){
                listPersonas.remove(p);
            }
        }*/
        
        Iterator<Persona> it = listPersonas.iterator();
        
        while (it.hasNext()) {
          Persona p = it.next();
          if (p.getEdad() % 2 == 0){
            it.remove();
          }
        }
        
        
    }
    
    
    
    
    /**
     * Método para hacer pruebas listando enteros
     */
    private static void testListInteger(){
        /*
         * ARRAYLIST DE ENTEROS
         */
        System.out.println("**************************************************");
        System.out.println("**EJEMPLOS DE ORDENACIÓN DE ARRAYLIST DE ENTEROS *");
        System.out.println("**************************************************");

        System.out.println("**************************************************");
        System.out.println("** ARRAYLIST ENTEROS 1 *");
        System.out.println("**************************************************");
        
        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(3);
        listInt.add(4);
        listInt.add(2);
        listInt.add(6);
        listInt.add(5);
        listInt.add(1);
        listInt.add(7);
        
        System.out.println("* Lista de enteros no ordenada");
        listInt.forEach(System.out::println);
        
        System.out.println("* Lista de enteros inversa:");
        Collections.reverse(listInt);
        listInt.forEach(System.out::println);
        
        System.out.println("* Lista de enteros ordenada por defecto (ascendente):");
        //Forma 1
        System.out.println("\tForma 1: con Collections.sort");
        Collections.sort(listInt);
        listInt.forEach(System.out::println);
        
        //Forma 2
        System.out.println("\tForma 2 con sort del ArrayList");
        listInt.sort(Comparator.naturalOrder());
        listInt.forEach(System.out::println);
        
        System.out.println("* Lista de enteros ordenada descendente:");
        //Forma 1
        System.out.println("\tForma 1: con Collections.sort");
        Collections.sort(listInt, Comparator.reverseOrder());
        listInt.forEach(System.out::println);
        
        //Forma 2
        System.out.println("\tForma 2 con sort del ArrayList");
        listInt.sort(Comparator.reverseOrder());
        listInt.forEach(System.out::println);
        
        System.out.println("**************************************************");
        System.out.println("** ARRAYLIST ENTEROS 2 *");
        System.out.println("**************************************************");
      
        List<Integer> listInt2 = Arrays.asList(4,5,1,2,8,9,6);
        
        // El resto igual .....
        
    }
    
}

