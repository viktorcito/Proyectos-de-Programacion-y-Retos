package es.daw.inyeccionDependencias;

/**
 *
 * @author melola
 */
public class AppImpresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // CASO 1
        // SIN INYECCIÓN DE DEPENDENCIAS: en el constructor se crean los objetos
        //ServicioImpresion servicio = new ServicioImpresion();
        
        // CASO 2
        // EL RESPONSABLE DE DEFINIR LAS DEPENDENCIAS ES EL PROGRAMA PRINCIPAL
        // CON INYECCIÓN DE DEPENDENCIAS: inyecto los objetos en el constructor
        //ServicioImpresion servicio = new ServicioImpresion(new ServicioEnvio(), new ServicioPDF());
        
        // CASO 3
        // INYECTO UN NUEVO ASPECTO. UN OBJETO QUE TIENE UNA NUEVA FUNCIONALIDAD PERO NO TENGO
        // QUE MODIFICAR LA CLASE SERVICIOIMPRESIÓN PARA QUE LO USE
        ServicioImpresion servicio = new ServicioImpresion(new ServicioEnvioLog(), new ServicioPDF());
        servicio.imprimir();
        
        
        
    }
    
}
