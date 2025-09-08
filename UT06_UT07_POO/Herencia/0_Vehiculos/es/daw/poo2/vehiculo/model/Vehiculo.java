package es.daw.poo2.vehiculo.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author melola
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private float potencia;
    private int kilometros;
    private LocalDate ultimaRevision;

    public Vehiculo(String matricula, String marca, String modelo, float potencia, int kilometros) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.kilometros = kilometros;
        this.ultimaRevision = LocalDate.now();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public LocalDate getUltimaRevision() {
        return ultimaRevision;
    }

    public void setUltimaRevision(LocalDate ultimaRevision) {
        this.ultimaRevision = ultimaRevision;
    }

    // Resto de métodos

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + ", kilometros=" + kilometros + ", ultimaRevision=" + ultimaRevision + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.matricula);
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
        return Objects.equals(this.matricula, other.matricula);
    }

    


}

