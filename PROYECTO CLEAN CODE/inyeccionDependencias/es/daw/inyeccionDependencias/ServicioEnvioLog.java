package es.daw.inyeccionDependencias;

/**
 * ESTA CLASE AÑADE UN ASPECTO NUEVO AL SERVICIO DE ENVÍO
 * @author melola
 */
public class ServicioEnvioLog extends ServicioEnvio{

    @Override
    public void enviar() {
        System.out.println("Haciendo log previo del envío del documento...");
        super.enviar(); 
    }
    
    
    
}
