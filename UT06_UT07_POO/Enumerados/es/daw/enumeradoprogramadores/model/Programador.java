package es.daw.enumeradoprogramadores.model;

import java.util.Objects;

/**
 *
 * @author melol
 */
public class Programador {
    
    /**
     * DNI del programador
     */
    private String DNI;
    
    /**
     * Nombre del programador
     */
    private String nombre;
 
    /**
     * Edad del programador
     */
    private int edad;
 
    /**
     * Indica el lenguaje de programación que conoce
     */
    private Lenguajes lenguaje;
 
    /**
     * Años de experiencia en ese lenguaje
     */
    private int aniosExperiencia;
    
    // CONSTRUCTOR ....
    public Programador(String DNI, String nombre, int edad, Lenguajes lenguaje, int aniosExperiencia){
        this.DNI=DNI;
        this.nombre=nombre;
        this.edad=edad;
        this.lenguaje=lenguaje;
        this.aniosExperiencia=aniosExperiencia;
    }

    // Este contructor es para crear objetos programadores solo con dni y poder
    // buscarlos en la colección
    public Programador(String DNI){
        this.DNI=DNI;
        // Llamo al constructor completo con valores por defecto
        //this(DNI,"",0,Lenguajes.C,0);
    }    
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public Lenguajes getLenguaje() {
        return lenguaje;
    }

    public String getDNI() {
        return DNI;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.DNI);
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
        final Programador other = (Programador) obj;
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Programador{" + "DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + ", experto en " + lenguaje + " con "+aniosExperiencia+" años de experiencia}";
        //return "Programador{" + "DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + ", experto en " + lenguaje.name() + " con "+aniosExperiencia+" años de experiencia}";
    }
  
}
