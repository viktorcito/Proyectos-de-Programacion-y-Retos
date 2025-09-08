package es.daw.parkingalcala.model;

import java.time.LocalDate;

/**
 *
 * @author melol
 */
public class Seguro {
    private int numPoliza;
    private String nombreAseguradora;
    private LocalDate fechaFinSeguro;

    public Seguro(int numPoliza, String nombreAseguradora, LocalDate fechaFinSeguro) {
        this.numPoliza = numPoliza;
        this.nombreAseguradora = nombreAseguradora;
        this.fechaFinSeguro = fechaFinSeguro;
    }

    public int getNumPoliza() {
        return numPoliza;
    }

    public String getNombreAseguradora() {
        return nombreAseguradora;
    }

    public LocalDate getFechaFinSeguro() {
        return fechaFinSeguro;
    }

}
