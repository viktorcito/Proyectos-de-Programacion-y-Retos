package es.daw.poo2.productos;

import java.util.ArrayList;
import es.daw.poo2.productos.model.*;
import java.util.Comparator;


/**
 *
 * @author melola
 */
public class ServicioOrdenacion implements Sortable{

    private ArrayList<Producto> listaClonada;
    
    // ------------ PATRON SINGLETON -----------------
    // Ahora no se podrá crear instancias (objetos) de esta clase
    //public ServicioOrdenacion(){}
    
    private static ServicioOrdenacion instance;
    
    private ServicioOrdenacion(){
        listaClonada = new ArrayList<>();
    }
    
    public static ServicioOrdenacion getInstance(){
        if (instance == null)
            instance = new ServicioOrdenacion();
        return instance;
    }
    // -----------------------------------------------------
    
    @Override
    public ArrayList<Producto> ordenarAltoProducto(ArrayList<Producto> coleccion) {

        listaClonada = (ArrayList<Producto>) coleccion.clone();

        // Forma 1
        //listaClonada.sort(new CompararXalto().reversed());
        
        // Forma 2
        //Comparator<Producto> xAlto =  (pa,pb) -> Integer.compare(pa.getAlto(), pb.getAlto());
        //listaClonada.sort(xAlto.reversed());
        
        // Forma 3
        listaClonada.sort((pa,pb) -> Integer.compare(pb.getAlto(), pa.getAlto()));
        
        return listaClonada;

    }

    @Override
    public ArrayList<Producto> ordenarAnchoProducto(ArrayList<Producto> coleccion) {
        listaClonada = (ArrayList<Producto>) coleccion.clone();
        
        //para que ordene descendente uso reversed();
        listaClonada.sort(new CompararXancho().reversed());

        return listaClonada;
    }

    @Override
    public ArrayList<Producto> ordenarLargoProducto(ArrayList<Producto> coleccion) {
        listaClonada = (ArrayList<Producto>) coleccion.clone();

        listaClonada.sort(new CompararXlargo().reversed());
        return listaClonada;
    }
    
}
