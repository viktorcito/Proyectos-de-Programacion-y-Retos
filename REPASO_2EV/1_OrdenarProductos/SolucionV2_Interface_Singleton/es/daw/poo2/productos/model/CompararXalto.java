
package es.daw.poo2.productos.model;

import java.util.Comparator;

/**
 *
 * @author natali
 */
public class CompararXalto implements Comparator<Producto>{

    @Override
    public int compare(Producto t, Producto t1) {
        // Tenemos que devolver negativo, cero o positivo
        
        return t.getAlto() - t1.getAlto();
    }
    
    
}
