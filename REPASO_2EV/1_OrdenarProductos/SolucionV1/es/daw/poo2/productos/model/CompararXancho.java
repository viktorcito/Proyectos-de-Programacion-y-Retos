
package es.daw.poo2.productos.model;
import java.util.Comparator;

/**
 *
 * @author natali
 */
public class CompararXancho implements Comparator<Producto> {

    @Override
    public int compare(Producto t, Producto t1) {
        return t.getAncho() - t1.getAncho();
        //return t1.getAncho() - t.getAncho();
    }
    
}
