package es.daw.poo2.productos.model;

import java.util.ArrayList;

/**
 *
 * @author melola
 */
public interface Sortable {
    
    public abstract ArrayList<Producto> ordenarAltoProducto(ArrayList<Producto> coleccion);
    public abstract ArrayList<Producto> ordenarAnchoProducto(ArrayList<Producto> coleccion);
    public abstract ArrayList<Producto> ordenarLargoProducto(ArrayList<Producto> coleccion);
    
}
