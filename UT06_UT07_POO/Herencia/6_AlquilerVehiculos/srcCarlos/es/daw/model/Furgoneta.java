/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.model;

/**
 *
 * @author carlo
 */
public class Furgoneta extends Vehiculo {

    //CONSTANTES
    private final int EXTRA = 20;

    //ATRIBUTOS
    private float peso;

    //CONSTRUCTORES
    public Furgoneta(String matricula, int dias, float peso, boolean esAlquilado) {
        super(matricula, dias, esAlquilado);
        this.peso = peso;
    }

    //getters
    public float getPeso() {
        return peso;
    }

    //metodos
    @Override
    public int getPrecioAlquiler() {

        int precioAlquiler = super.getPrecioAlquiler();

        precioAlquiler = (int) ((precioAlquiler + EXTRA) * this.peso);

        return precioAlquiler;
    }

    //equals y hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Float.floatToIntBits(this.peso);
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
        final Furgoneta other = (Furgoneta) obj;
        return Float.floatToIntBits(this.peso) == Float.floatToIntBits(other.peso);
    }

    //to string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Furgoneta{");
        sb.append("peso=").append(peso);
        sb.append('}');
        sb.append("ALQUILER :").append(getPrecioAlquiler());
        return sb.toString();
    }

}
