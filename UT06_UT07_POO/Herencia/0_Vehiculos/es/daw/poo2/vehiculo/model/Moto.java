package es.daw.poo2.vehiculo.model;

/**
 *
 * @author melola
 */
public class Moto extends Vehiculo{
    private boolean carenado;

    public Moto(String matricula, String marca, String modelo, float potencia, int kilometros) {
        super(matricula, marca, modelo, potencia, kilometros);
    }

    public Moto(String matricula) {
        super(matricula);
    }
    

    public boolean isCarenado() {
        return carenado;
    }

    public void setCarenado(boolean carenado) {
        this.carenado = carenado;
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString()+" carenado=" + carenado + '}';
    }
    
    
}
