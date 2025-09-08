/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos.model;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Knox
 */
public class Vehiculo {
    private final String MATRICULA;
    private int dias;
    private final int PRECIO_BASE = 50;
    private boolean alquilado;

    public Vehiculo(String MATRICULA) {
        this.MATRICULA = MATRICULA;
        alquilado = false;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        Scanner sc = new Scanner(System.in);
        
        this.alquilado = alquilado; 
        
        
        if(alquilado){
            System.out.println("Introduce los días de alquiler del "+getClass().getSimpleName());
            setDias(sc.nextInt());
            System.out.println("Precio estimado de alquiler: "+getPrecioAlquiler());
        }
    }

    public String getMATRICULA() {
        return MATRICULA;
    }
    
    public int getDias() {
        return dias;
    }

    private void setDias(int dias) {
        this.dias = dias;
    }
    
    public float getPrecioAlquiler(){
        return PRECIO_BASE * dias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.MATRICULA);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }

        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.MATRICULA, other.MATRICULA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(getClass().getSimpleName()).append(" ]");
        sb.append("\n\t* Matrícula: ").append(MATRICULA);
        sb.append((alquilado)?"\n\t* Días de alquiler: "+dias:"");
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
}
