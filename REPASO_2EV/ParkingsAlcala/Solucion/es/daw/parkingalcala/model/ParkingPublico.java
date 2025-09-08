package es.daw.parkingalcala.model;

/**
 *
 * @author melola
 */
public class ParkingPublico extends Parking{
    private int numTrabajadoresDiscapacitados;

    public ParkingPublico(int numTrabajadoresDiscapacitados, String nombre, String direccion, int capacidad) {
        super(nombre, direccion, capacidad);
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }
    
    // Doy por hecho que el numTrabajadoresDiscapacitados lo podré modificar
    // en un futuro
    public void setTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados){
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }
    
    @Override
    public double mostrarGananciasTotales(){
        //return getCantidadGanada() + (numTrabajadoresDiscapacitados *250);
        return cantidadGanada + (numTrabajadoresDiscapacitados *250);
    }
}
