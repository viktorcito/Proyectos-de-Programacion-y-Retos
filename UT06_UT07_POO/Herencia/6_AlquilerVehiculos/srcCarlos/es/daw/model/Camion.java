/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.model;

/**
 *
 * @author carlo
 */
public class Camion extends Vehiculo {

    //CONSTANTES
    private final int EXTRA = 20;
    private final int PRECIO_FIJO = 40;

    //ATRIBUTOS
    private float peso;

    //CONSTRUCTORES   
    public Camion(String matricula, int dias, float peso, boolean esAlquilado) {
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

        precioAlquiler = PRECIO_FIJO + ((int) ((precioAlquiler + EXTRA) * this.peso));

        return 0;

    }

    //equals y hashcode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.EXTRA;
        hash = 97 * hash + this.PRECIO_FIJO;
        hash = 97 * hash + Float.floatToIntBits(this.peso);
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
        final Camion other = (Camion) obj;
        if (this.EXTRA != other.EXTRA) {
            return false;
        }
        if (this.PRECIO_FIJO != other.PRECIO_FIJO) {
            return false;
        }
        return Float.floatToIntBits(this.peso) == Float.floatToIntBits(other.peso);
    }
    
    //to string

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Camion{");
        sb.append("peso=").append(peso);
        sb.append('}');
        sb.append("ALQUILER :").append(getPrecioAlquiler());
        return sb.toString();
    }
    
    
    
}
