/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos.model;

/**
 *
 * @author Knox
 */
public class Camion extends Furgoneta{
    private final int EXTRA = 40;
    
    public Camion(String MATRICULA, float PMA) {
        super(MATRICULA, PMA);
    }

    @Override
    public float getPrecioAlquiler() {
        return super.getPrecioAlquiler() + EXTRA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
    
    
    
    
}
