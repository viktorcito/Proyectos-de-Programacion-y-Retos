/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos.model;

/**
 *
 * @author Knox
 */
public class Furgoneta extends Vehiculo{
    private final int EXTRA = 20;
    private float PMA;

    public Furgoneta(String MATRICULA, float PMA) {
        super(MATRICULA);
        this.PMA = PMA;
    }
    
    public float getPMA() {
        return PMA;
    }

    public void setPMA(float PMA) {
        this.PMA = PMA;
    }

    @Override
    public float getPrecioAlquiler() {
        return super.getPrecioAlquiler() + (EXTRA * PMA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n\t* PMA: ").append(PMA);
        if (isAlquilado()) {
            sb.append("\n***********************************");
            sb.append("\nPrecio del alquiler: ").append(getPrecioAlquiler()).append(" euros");
        }
        return sb.toString();
    }
    
    
    
    
    
    
}
