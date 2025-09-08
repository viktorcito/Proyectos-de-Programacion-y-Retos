package es.daw.enumeradoprogramadores.exceptions;

import es.daw.enumeradoprogramadores.model.Lenguajes;

/**
 *
 * @author melola
 */
public class LimiteEdadException extends Exception implements Comparable<LimiteEdadException>{
    
    private String dni;
    private int edad;
    private Lenguajes lp;
    
    private static final String MESSAGE ="El programador con DNI %s y con %d años y debe realizar el curso formativo previo";

    public LimiteEdadException(String dni, int edad, Lenguajes lp) {
        super(String.format(MESSAGE,dni,edad));
        this.dni = dni;
        this.edad = edad;
        this.lp = lp;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public Lenguajes getLp() {
        return lp;
    }

    
    @Override
    public String toString() {
        return "LimiteEdadException{" + "dni=" + dni + ", edad=" + edad + ", lp=" + lp + '}';
    }

    @Override
    public int compareTo(LimiteEdadException e) {
        return dni.compareTo(e.dni);
    }


    
}
