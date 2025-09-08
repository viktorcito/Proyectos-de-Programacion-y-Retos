/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.model;

import java.util.Objects;

/**
 *
 * @author carlo
 */
public class Vehiculo {

    //CONSTANTES
    public final int PRECIO_DIA = 50;
    //ATRIBUTOS
    private String matricula;
    private int dias;
    private boolean esAlquilado = false;
    //CONSTRUCTORES
    public Vehiculo(String matricula, int dias,boolean esAlquilado) {
        this.matricula = matricula;
        this.dias = dias;
        this.esAlquilado=esAlquilado;
    }

    //GETTERS
    public String getMatricula() {
        return matricula;
    }

    public int getDias() {
        return dias;
    }

    public boolean isEsAlquilado() {
        return esAlquilado;
    }

    public void setEsAlquilado(boolean esAlquilado) {
        this.esAlquilado = esAlquilado;
    }

    //METODOS
    public int getPrecioAlquiler() {

        int PrecioAlquiler = 0;
        PrecioAlquiler = PRECIO_DIA * this.dias;
        return PrecioAlquiler;

    }

    //EQUALS Y HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.PRECIO_DIA;
        hash = 83 * hash + Objects.hashCode(this.matricula);
        hash = 83 * hash + this.dias;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.PRECIO_DIA != other.PRECIO_DIA) {
            return false;
        }
        if (this.dias != other.dias) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }

    //TO STRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("matricula=").append(matricula);
        sb.append(", dias=").append(dias);
        sb.append('}');
        return sb.toString();
    }

}
