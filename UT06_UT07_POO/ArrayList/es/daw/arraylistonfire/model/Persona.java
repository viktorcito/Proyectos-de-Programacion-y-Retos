package es.daw.arraylistonfire.model;

/**
 *
 * @author melola
 */
public class Persona implements Comparable<Persona>{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Persona(){
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
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

    /*
    @Override
    public int compareTo(Object t) {
                
    }
    */

    @Override
    public int compareTo(Persona other) {
        /*if (other.getEdad() > edad)
            return -1;
        else if (edad > other.getEdad())
            return 1;
        else
            return 0;*/
        
        return edad - other.getEdad();
        
    }

    /*
    // EN OBSERVACIÓN!!!!!!!!!
    // It is strongly recommended (though not required) that natural orderings be consistent with equals.
    // https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.edad;
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
        final Persona other = (Persona) obj;
        return this.edad == other.edad;
    }
    */
    
    
    
    
}
