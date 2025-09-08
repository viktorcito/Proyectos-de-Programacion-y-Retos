/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.model;

/**
 *
 * @author carlo
 */
public class Coche extends Vehiculo {

    //CONSTANTES
    private final int EXTRA = (int) 1.5;

    //ATRIBUTOS
    private int numPlazas;

    //CONSTRUCTORES
    public Coche(String matricula, int dias, int numPlazas, boolean esAlquilado) {
        super(matricula, dias, esAlquilado);
        this.numPlazas = numPlazas;
    }
    //GETTERS

    public int getNumPlazas() {
        return numPlazas;
    }

    //METODOS
    @Override
    public int getPrecioAlquiler() {

        int precioAlquiler = super.getPrecioAlquiler();

        precioAlquiler = (precioAlquiler + EXTRA) + (this.numPlazas * EXTRA);

        return precioAlquiler;

    }

    //EQUALS Y HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.EXTRA;
        hash = 59 * hash + this.numPlazas;
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
        final Coche other = (Coche) obj;
        if (this.EXTRA != other.EXTRA) {
            return false;
        }
        return this.numPlazas == other.numPlazas;
    }

    //TO STRING 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Coche{");
        sb.append("numPlazas=").append(numPlazas);
        sb.append('}');
        sb.append("ALQUILER :").append(getPrecioAlquiler());
        return sb.toString();
    }

}
