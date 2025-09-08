/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos.Model;

/**
 *
 * @author Dani
 */
public class Furgoneta extends Vehiculo {
    private float pma;
    private final int EXTRA=20;

    public Furgoneta(float pma, String matricula, int dias,boolean alquilado) {
        super(matricula, dias,alquilado);
        this.pma = pma;
    }

    public Furgoneta(float pma, String matricula) {
        super(matricula);
        this.pma = pma;
    }
    

    public float getPMA() {
        return pma;
    }

    public void setPMA(float PMA) {
        this.pma = pma;
    }
    
    public float calcularAlquiler(){
        return super.calcularAlquiler() + (EXTRA * pma);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(getClass().getSimpleName().equalsIgnoreCase("furgoneta")){
        sb.append("Furgoneta{");
        }
        sb.append(super.toString());
        sb.append(" PMD: ").append(pma);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
