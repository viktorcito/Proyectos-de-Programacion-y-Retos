package es.daw.poo2.abstractvsinterface.model;

/**
 *
 * @author melola
 */
public class DocumentoWord extends Documento{

    private String version;

    public DocumentoWord(String version, String titulo) {
        super(titulo);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    @Override
    public void validar() {
        // Aquí habría toda una lógica de conexión contra un servicio validador bla bla bla...
        System.out.printf("El documento WORD con título %s ha sido validado!!!!\n",getTitulo());
    }
    
}
