package es.daw.parkingalcala.model;

/**
 *
 * @author melola
 */
public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private boolean esElectrico;

    public Coche(String marca, String modelo, String matricula, boolean esElectrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.esElectrico = esElectrico;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isEsElectrico() {
        return esElectrico;
    }

    
    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", esElectrico=" + esElectrico + '}';
    }
    
    
}
