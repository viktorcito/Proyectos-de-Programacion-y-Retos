package es.daw.parkingalcala.model;

/**
 *
 * @author melola
 */
public class ParkingPrivado extends Parking{
    private int numSocios;

    public ParkingPrivado(int numSocios, String nombre, String direccion, int capacidad) {
        super(nombre, direccion, capacidad);
        this.numSocios = numSocios;
    }
    
    // El número de socios se puede modificar en un futuro
    public void setNumSocios(int numSocios){
        this.numSocios = numSocios;
    }
    
    @Override
    public double mostrarGananciasTotales(){
        return cantidadGanada / numSocios;
    }
    
}
