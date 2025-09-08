package es.daw.parkingalcala.dao;

import es.daw.parkingalcala.model.Coche;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class CocheDAO {
    
    private final ArrayList<Coche> coches = new ArrayList<>();
    
    public CocheDAO(){
        
        coches.add(new Coche("Fiat", "Bravo", "7549HDW", false));
        coches.add(new Coche("Volvo", "Yoquese", "3549PDW", false));
        coches.add(new Coche("Citroen", "C3", "7549HDW", true));
        coches.add(new Coche("Audi", "A3", "8888ADW", true));
        coches.add(new Coche("Audi", "A5", "8888BDW", false));
        
    }
    public ArrayList<Coche> select(){
        return (ArrayList<Coche>) coches.clone();
    }
    
}
