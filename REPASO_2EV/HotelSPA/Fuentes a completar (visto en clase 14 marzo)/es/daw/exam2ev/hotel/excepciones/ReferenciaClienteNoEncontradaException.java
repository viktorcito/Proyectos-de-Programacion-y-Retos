package es.daw.exam2ev.hotel.excepciones;

import es.daw.exam2ev.hotel.util.UtilFechas;
import java.time.LocalDateTime;

/**
 *
 * @author melola
 */
public class ReferenciaClienteNoEncontradaException extends Exception{
    
    private String ref;
    private LocalDateTime horaBusqueda;
    
    private static final String MESSAGE = "Número de referencia %s no encontrada en la fecha %s";
    

    public ReferenciaClienteNoEncontradaException(String ref, LocalDateTime horaBusqueda) {
        //super("Número de referencia "+ref+" no encontrada en la fecha "+UtilFechas.convertirFechaHora(horaBusqueda));
        super(String.format(MESSAGE,ref,UtilFechas.convertirFechaHora(horaBusqueda)));
        this.ref = ref;
        this.horaBusqueda = horaBusqueda;
    }

    
    public ReferenciaClienteNoEncontradaException(String ref) {
        //super("Número de referencia "+ref+" no encontrada en la fecha "+UtilFechas.convertirFechaHora(horaBusqueda));
        super(String.format(MESSAGE,ref,UtilFechas.convertirFechaHora(LocalDateTime.now())));
        this.ref = ref;
        this.horaBusqueda = horaBusqueda;
    }
    
    /*
    @Override
    public String getMessage() {
        return String.format(MESSAGE,ref,UtilFechas.convertirFechaHora(horaBusqueda));
    }
    */
    
   
    
}
