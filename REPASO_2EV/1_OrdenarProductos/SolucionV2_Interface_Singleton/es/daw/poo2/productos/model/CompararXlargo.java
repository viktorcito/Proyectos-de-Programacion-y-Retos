
package es.daw.poo2.productos.model;

import java.util.Comparator;

/**
 *
 * @author natali
 */
public class CompararXlargo implements Comparator<Producto> {

    @Override
    public int compare(Producto t, Producto t1) {
        
        return t.getLargo()- t1.getLargo();
    }
    
    
    
    
    
}
