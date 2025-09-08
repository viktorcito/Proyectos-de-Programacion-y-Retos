package es.daw.poo2.abstractvsinterface.model;

/**
 *
 * @author melola
 */
public abstract class Documento implements Validator{
    // Atributos
    private String titulo;
    
    // Constructores
    public Documento(String titulo) {
        this.titulo = titulo;
    }

    // Getters&Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}
