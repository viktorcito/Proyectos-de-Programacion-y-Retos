package es.daw.poo2.abstractvsinterface.model;

/**
 *
 * @author melola
 */
public class Video implements Validator{
    
    private String formato;
    private String titulo;
    private float duracion;

    public Video(String formato, String titulo, float duracion) {
        this.formato = formato;
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Override
    public void validar() {
        System.out.printf("El VIDEO con título %s, de formato %s y de duración %.2f ha sido validado!!!!\n",titulo,formato,duracion);
    }
    
    
}
