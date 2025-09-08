package es.daw.poo2.empleados.model;

/**
 *
 * @author melol
 */
public class Oficial extends Operario {

    public Oficial() {
    }

    public Oficial(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return super.toString() + " -> Oficial";
    }

}