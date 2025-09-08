package es.daw.excepciones;

/**
 * Una excepción propia de tipo unchecked debe heredar de RuntimeException, 
 * no de Exception
 * @author melol
 */
public class MiExceptionUnchecked extends RuntimeException{
    private int dia;
    private String descripcion;

    public MiExceptionUnchecked(int dia, String descripcion) {
        //super(descripcion); //Si paso el mensaje al padre
        this.dia = dia;
        this.descripcion = descripcion;
    }

    @Override
    public String getMessage() {
        return descripcion+": "+dia;
    }
    
}
