/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos.Model;

/**
 *
 * @author Dani
 */
public class Camion extends Furgoneta {
    private final int EXTRA_CAMION=40;

    public Camion(float pma, String matricula, int dias,boolean alquilado) {
        super(pma, matricula, dias,alquilado);
    }

    public Camion(float pma, String matricula) {
        super(pma, matricula);
    }
    


public float calcularAlquiler(){
    return super.calcularAlquiler() + EXTRA_CAMION;
}    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Camion{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
