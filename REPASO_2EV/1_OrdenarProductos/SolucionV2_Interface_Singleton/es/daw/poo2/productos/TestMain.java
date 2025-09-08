/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/REPASO/1_OrdenarProductos
 */
package es.daw.poo2.productos;

import java.util.ArrayList;
import java.util.Collections;
import es.daw.poo2.productos.dao.ProductoDAO;
import es.daw.poo2.productos.model.Producto;

/**
 *
 * @author melola
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();
        ArrayList<Producto> productos = dao.select(); //listado de productos original
        
        System.out.println("CATÁLOGO DE PRODUCTOS ORIGINAL: ");
        pintarLista(productos);
        
        ServicioOrdenacion servicio = ServicioOrdenacion.getInstance();
        //ServicioOrdenacion servicio2 = ServicioOrdenacion.getInstance();
        
        // Dos objetos diferentes
        //ServicioOrdenacion servicio = new ServicioOrdenacion();
        //ServicioOrdenacion servicio2 = new ServicioOrdenacion();
        
        ArrayList<Producto> productosCopia = (ArrayList<Producto>) productos.clone();
        
        // ORDENAR POR NOMBRE - EL ATRIBUTO QUE HEMOS PUESTO COMO ORDEN NATURAL - COMPARABLE
        Collections.sort(productosCopia);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORDENADOS POR NOMBRE: ");
        pintarLista(productosCopia);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORIGINAL: ");
        pintarLista(productos);
        
        // LLAMAMOS A CADA UNO DE LOS MÉTODOS DE ORDEN POR CADA COMPARATOR  
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORDENADO POR ALTO:");
        productosCopia = servicio.ordenarAltoProducto(productos);
        pintarLista(productosCopia);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORIGINAL: ");
        pintarLista(productos);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORDENADO POR ANCHO:");
        productosCopia = servicio.ordenarAnchoProducto(productos);
        pintarLista(productosCopia);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORIGINAL: ");
        pintarLista(productos);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORDENADO POR LARGO:");
        productosCopia = servicio.ordenarLargoProducto(productos);
        pintarLista(productosCopia);
        
        System.out.println("\nCATÁLOGO DE PRODUCTOS ORIGINAL: ");
        pintarLista(productos);

    }

    public static void pintarLista(ArrayList<Producto> lista) {

        for (Producto p : lista) {
            System.out.println(p);
        }

    }

}
