package es.daw.poo2.productosperecederos;

import es.daw.poo2.productosperecederos.model.Perecedero;
import es.daw.poo2.productosperecederos.model.Producto;
import es.daw.productosperecederos.dao.ProductoDAO;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class ProductosPerecederosApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.select();
        
        for(Producto p:productos){
            System.out.println(p);
            System.out.println("\tPrecio: "+p.calcular(5));
            
            System.out.println("\tPermite devolución: "+p.permiteDevolucion());
            
            System.out.println("\tXML:"+ p.convert2XML());
        }
        
        // Mostrar el número de productos totales que tengo
        System.out.println("\nNÚMERO PRODUCTOS TOTALES EN ALMACÉN: "+productos.size());
        
    }
    
}
