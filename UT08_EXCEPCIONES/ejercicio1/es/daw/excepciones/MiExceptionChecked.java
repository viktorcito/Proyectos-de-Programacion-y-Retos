package es.daw.excepciones;

/**
 * FORMA 1: creo la excepción sin pasar el mensaje al padre (Exception) y
 * por tanto para no perder el mensaje del método getMesage() tengo que
 * sobreescribir el método
 * 
 * @author melola
 */
public class MiExceptionChecked extends Exception{
    private int dia;
    private String descripcion;

    public MiExceptionChecked(int dia, String descripcion) {
        this.dia = dia;
        this.descripcion = descripcion;
    }
    
    @Override
    public String getMessage() {
        return descripcion+" : "+dia;
    }
    
    
    
    
}
