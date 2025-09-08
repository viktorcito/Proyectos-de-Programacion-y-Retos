package es.daw.poo2.abstractvsinterface.model;

/**
 *
 * @author melola
 */
public class DocumentoPDF extends Documento{

    private boolean protegido;

    public boolean isProtegido() {
        return protegido;
    }

    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }

    
    public DocumentoPDF(boolean protegido, String titulo) {
        super(titulo);
        this.protegido = protegido;
    }
    
    @Override
    public void validar() {
        // Aquí habría toda una lógica de conexión contra un servicio validador bla bla bla...
        System.out.printf("El documento PDF con título %s ha sido validado!!!!\n",getTitulo());
    }
    
}
