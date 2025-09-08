/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos.Model;

/**
 *
 * @author Dani
 */
public class Vehiculo {
    private String matricula;
    private int dias;
    private final int PRECIO_BASE=50;
    private boolean alquilado;

    public Vehiculo(String matricula, int dias,boolean alquilado) {
        this.matricula = matricula;
        this.dias = dias;
        this.alquilado=alquilado; 
   }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }
    
    
    
    public float calcularAlquiler(){
        return PRECIO_BASE *dias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("matricula: ").append(matricula).append(", ");
        
        if(alquilado){
            
        sb.append("Está alquilado").append(",");
        sb.append(", días alquilado: ").append(dias).append(", ");
        }else{
            sb.append("No alquilado").append(",");
        }
        return sb.toString();
    }

    
    
}
