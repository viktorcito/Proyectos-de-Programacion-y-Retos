/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.model;

/**
 *
 * @author carlo
 */
public class Microbus extends Vehiculo {

    //CONSTANTES 
    private final int EXTRA = 3;

    //ATRIBUTOS    
    private int numPlazas;

    //CONSTRUCTORES
    public Microbus(String matricula, int dias, int numPlazas, boolean esAlquilado) {
        super(matricula, dias, esAlquilado);
        this.numPlazas = numPlazas;
    }

    //GETTERS
    public int getNumPlaza() {
        return numPlazas;
    }

    //METODOS
    @Override
    public int getPrecioAlquiler() {

        int precioAlquiler = super.getPrecioAlquiler();

        precioAlquiler = (precioAlquiler + EXTRA) * (this.numPlazas * EXTRA);

        return precioAlquiler;

    }
    //equals y hashcode

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
        final Microbus other = (Microbus) obj;
        return true;
    }

    //to string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Microbus{");
        sb.append("numPlazas=").append(numPlazas);
        sb.append('}');
        sb.append("ALQUILER :").append(getPrecioAlquiler());
        return sb.toString();
    }

}
