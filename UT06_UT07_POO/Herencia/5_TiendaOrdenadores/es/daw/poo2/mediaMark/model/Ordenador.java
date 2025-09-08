package es.daw.poo2.mediaMark.model;

import java.util.Objects;

/**
 *
 * @author melola
 */
public class Ordenador implements Comparable<Ordenador>{
    private String codigo;
    private float precio;
    private int duracion; //meses
    
    public final static String SLOGAN ="Todos los ordenadores de la tienda son los mejores";

    public Ordenador(String codigo, float precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Ordenador{" + "codigo=" + codigo + ", precio=" + precio + ", duracion=" + duracion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Ordenador other = (Ordenador) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public int compareTo(Ordenador other) {
        return codigo.compareTo(other.getCodigo());
    }

    
}
