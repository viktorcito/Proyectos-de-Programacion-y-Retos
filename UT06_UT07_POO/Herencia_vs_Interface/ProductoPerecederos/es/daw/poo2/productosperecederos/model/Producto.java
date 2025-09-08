package es.daw.poo2.productosperecederos.model;

import java.util.Objects;

/**
 *
 * @author melol
 */
public abstract class Producto implements ConvertibleToXML{
//public abstract class Producto {
//public class Producto implements ConvertibleToXML{
//public class Producto{
    private String nombre;
    private double precio;

    // CONSTRUCTOR
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // MÉTODO PROPIOS DE COMPORTAMIENTO
    public double calcular(int cantidad){
        return precio*cantidad;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    // MÉTODO ABSTRACTO AMPLIACIÓN
    public abstract boolean permiteDevolucion();
    
    /*
    @Override
    public String convert2XML() {
        return "<producto>bla bla <producto>";
    } */   
    
}
