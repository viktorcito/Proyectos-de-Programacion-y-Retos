
package es.daw.carrera.model;

/**
 *
 * @author melol
 */
public class ExcepcionTiempo extends Exception{
    private int dorsal;
    private int puntoKm;

    public ExcepcionTiempo(int dorsal, int puntoKm) {
        this.dorsal = dorsal;
        this.puntoKm = puntoKm;
    }

    @Override
    public String getMessage() {
        return "El corredor con dorsal "+dorsal+" no tiene tiempo en el punto km "+puntoKm;
    }
    
    
    
}
