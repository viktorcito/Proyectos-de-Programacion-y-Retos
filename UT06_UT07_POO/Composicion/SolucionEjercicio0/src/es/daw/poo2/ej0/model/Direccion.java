package es.daw.poo2.ej0.model;

/**
 *
 * @author melola
 */
public class Direccion{

    private String calle;
    private int numero;

    public Direccion(String calle, int numero) {
        //super();
        this.calle = calle;
        this.numero = numero;
    }
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", numero=" + numero + '}';
    }

}
