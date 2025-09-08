
package es.daw.poo2.productos.dao;
import es.daw.poo2.productos.model.Producto;
import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class ProductoDAO {  


    private final ArrayList<Producto> productos;

    
    public ProductoDAO(){
        productos = new ArrayList<>();
        productos.add(new Producto("zapatillas",2, 2, 10));
        productos.add(new Producto("zapatos",29, 10, 2));
        productos.add(new Producto("pantalones",2, 3, 9));
        productos.add(new Producto("cuadernos",28, 9, 3));
        productos.add(new Producto("ordenador",1, 4, 8));
        productos.add(new Producto("impresora", 33, 8, 4));
        productos.add(new Producto("monitor",4, 5, 33));
        productos.add(new Producto("ratón",5, 6, 6));
        productos.add(new Producto("usb",25, 8, 4));
        
    }
    
    public ArrayList<Producto> select(){
        return (ArrayList<Producto>) productos.clone();
    }    

}


