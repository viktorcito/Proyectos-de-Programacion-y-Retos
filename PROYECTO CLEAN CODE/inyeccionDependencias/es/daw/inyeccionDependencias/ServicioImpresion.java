package es.daw.inyeccionDependencias;

/**
 *
 * @author melola
 */
public class ServicioImpresion {
    
    ServicioEnvio servEnvio;
    ServicioPDF servPDF;
    
    
    // PARA APLICAR INYECCIÓN DE DEPENDENCIAS NO USO ESTE CONSTRUCTOR
    public ServicioImpresion(){
        //servEnvio = new ServicioEnvio();
        servEnvio = new ServicioEnvioLog();
        servPDF = new ServicioPDF();
    }
    
    // PATRÓN DE INYECCIÓN DE DEPENDECIAS. EL CONSTRUCTOR RECIBE LOS OBJETOS POR ARGUMENTOS
    public ServicioImpresion(ServicioEnvio servEnvio, ServicioPDF servPDF) {
        this.servEnvio = servEnvio;
        this.servPDF = servPDF;
    }
    
    
    public void imprimir(){
        
        // COMO EL SERVICIO DE IMPRESIÓN HACE DOS COSAS, APLICO LA DIVISIÓN DE RESPONSABILIDADES
        //System.out.println("Enviando el documento a imprimir...");
        //System.out.println("Imprimiendo el documento en formato pdf");
        
        // RESPONSABILIDAD 1: EL SERVICIO DE ENVIO SE ENCARGA DE ENVIAR
        servEnvio.enviar();
        
        // RESPONSABILIDAD 2: EL SERVICIO DE IMPRIMIR PDF SE ENCARGA DE IMPRIMIR PDF (perdona Luismi)
        servPDF.imprimePDF();
    }
    
}
