/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos.Model;

/**
 *
 * @author Dani
 */
public class Microbus extends Vehiculo {

    private int numPlazas;
    private final int EXTRA = 3;

    public Microbus(int numPlazas, String matricula, int dias, boolean alquilado) {
        super(matricula, dias, alquilado);
        this.numPlazas = numPlazas;
    }

    public Microbus(int numPlazas, String matricula) {
        super(matricula);
        this.numPlazas = numPlazas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public float calcularAlquiler() {
        return super.calcularAlquiler() + (numPlazas * EXTRA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Microbus{ ");
        sb.append(super.toString());
        sb.append(" Número de Plazas:").append(numPlazas);
        sb.append('}');
        return sb.toString();
    }

}
