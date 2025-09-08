/**
 * 
 */
package set;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import modelo.Persona;

public class EjemploSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
                //No se garantiza que se devuelva en el orden de insercción
		//Set<Persona> juntaDirectiva = new HashSet<>();
                
                //Exception in thread "main" java.lang.ClassCastException: class modelo.Persona cannot be cast to class java.lang.Comparable
                //Para ordenar, Persona debe implementar Comparable
		Set<Persona> juntaDirectiva = new TreeSet<>(); 
                
                //Se devuelve en el orden de insercción
		//Set<Persona> juntaDirectiva = new LinkedHashSet<>();
		
		juntaDirectiva.add(new Persona("23456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
		juntaDirectiva.add(new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
		juntaDirectiva.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
		juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));
		
		//Si tratamos de añadir un elemento repetido...
                //No da error, simplement no se inserta el nuevo elemento
		juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

                
                System.out.println("* Personas en orden ascendente:");
                //Comprobamos que al listarlos todos, no aparece duplicado
		for(Persona p : juntaDirectiva)
			System.out.println(p);
		
                //Iterator it = juntaDirectiva.descendingIterator(); //está en java doc
                ArrayList<Persona> lista = new ArrayList(juntaDirectiva);
                //lista.sort( (pa,pb) -> pa.getNombre().compareTo(pb.getNombre()));
                lista.sort(Comparator.reverseOrder());
                
                System.out.println("* Personas en orden descendente:");
                lista.forEach(System.out::println);
                //lista.sort(Collections.reverseOrder());
                
		
		
	}

}
