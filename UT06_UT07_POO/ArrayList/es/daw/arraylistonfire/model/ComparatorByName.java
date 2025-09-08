package es.daw.arraylistonfire.model;

import java.util.Comparator;

/**
 *
 * @author melola
 */
public class ComparatorByName implements Comparator<Persona>{

    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
    
}
