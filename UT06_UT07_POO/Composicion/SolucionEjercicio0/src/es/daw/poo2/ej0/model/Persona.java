package es.daw.poo2.ej0.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melola
 */
public class Persona {

    private String nombre;
    private int edad;

    private Direccion dirección;

    public Persona(String nombre, int edad) {
        //super();
        this.nombre = nombre;
        this.edad = edad;
    }

    public Direccion getDirección() {
        return dirección;
    }

    public void setDirección(Direccion dirección){
        this.dirección = dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", direcci\u00f3n=" + dirección + '}';
    }

    
}



