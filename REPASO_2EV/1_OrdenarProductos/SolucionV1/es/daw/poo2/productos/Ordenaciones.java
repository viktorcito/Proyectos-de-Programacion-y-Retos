package es.daw.poo2.productos;

import java.util.ArrayList;
import es.daw.poo2.productos.model.*;
import java.util.Comparator;


/**
 *
 * @author melola
 */
public class Ordenaciones{
    
    private ArrayList<Producto> listaClonada;
    
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

    public ArrayList<Producto> ordenarAnchoProducto(ArrayList<Producto> coleccion) {
        listaClonada = (ArrayList<Producto>) coleccion.clone();
        
        //para que ordene descendente uso reversed();
        listaClonada.sort(new CompararXancho().reversed());

        return listaClonada;
    }

    public ArrayList<Producto> ordenarLargoProducto(ArrayList<Producto> coleccion) {
        listaClonada = (ArrayList<Producto>) coleccion.clone();

        listaClonada.sort(new CompararXlargo().reversed());
        return listaClonada;
    }
}
